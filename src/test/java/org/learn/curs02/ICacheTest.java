package org.learn.curs02;

import org.learn.curs02.cache.Cache;
import org.learn.curs02.cache.Mutator;

public interface ICacheTest {
  @Cache
  void cachedMethod();

  @Mutator
  public void mutatorMethod();
}
