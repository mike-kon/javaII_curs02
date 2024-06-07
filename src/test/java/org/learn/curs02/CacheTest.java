package org.learn.curs02;

import lombok.Getter;
import org.learn.curs02.cache.Cache;
import org.learn.curs02.cache.Mutator;

@Getter
public class CacheTest implements ICacheTest {
  private int cachedCount = 0;
  private int nonCachedCount = 0;

  @Override
  @Cache
  public void cachedMethod() {
    cachedCount++;
  }

  @Override
  @Cache
  public int cachedMethod(int i) {
    cachedCount++;
    return i;
  }

  @Override
  @Cache
  public double cachedMethod(double d) {
    cachedCount++;
    return d;
  }

  @Override
  @Mutator
  public void mutatorMethod() {
  }

  @Override
  public void nonCachedMethod() {
    nonCachedCount++;
  }

}
