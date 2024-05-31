package org.learn.curs02.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerCache<T> implements InvocationHandler {
  private final Map<Method, CacheStruct> cacheData;
  private final T obj;

  public HandlerCache(T obj) {
    this.obj = obj;
    cacheData = new HashMap<>();
    Invalidate();
  }

  private void Invalidate() {
    cacheData.entrySet().stream().forEach(x -> x.getValue().invalidated = true);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (method.isAnnotationPresent(Mutator.class)) {
      Invalidate();
      return method.invoke(obj, args);
    } else if (method.isAnnotationPresent(Cache.class)) {
      Object result;
      CacheStruct cache = cacheData.get(method);
      if (cache == null || cache.invalidated) {
        result = method.invoke(obj, args);
        if (cache == null) {
          cacheData.put(method, new CacheStruct(method, result, false));
        } else {
          cache.value = result;
          cache.invalidated = false;
        }
      } else {
        result = cache.value;
      }
      return result;
    } else {
      var ret = method.invoke(obj, args);
      return ret;
    }
  }

  private class CacheStruct {
    public CacheStruct(Method method, Object value, boolean invalidated) {
      this.method = method;
      this.value = value;
      this.invalidated = invalidated;
    }

    Method method;
    Object value;
    boolean invalidated;
  }
}


