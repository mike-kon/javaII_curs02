package org.learn.curs02.cache;

import org.learn.curs02.fraction.Fractionable;

import java.lang.reflect.Proxy;

public class Util {
  public static Object cache(Object fr){
    ClassLoader loader = fr.getClass().getClassLoader();
    Class<?>[] interfaces = fr.getClass().getInterfaces();
    HandlerCache handle =  new HandlerCache<>(fr);
    var proxy = Proxy.newProxyInstance(loader, interfaces, handle);
    return proxy;
  }

}
