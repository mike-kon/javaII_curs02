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
  @Mutator
  public void mutatorMethod() {
  }

  @Override
  public void nonCachedMethod() {
    nonCachedCount++;
  }

}
