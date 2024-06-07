package org.learn.curs02;

import lombok.Getter;

@Getter
public class CacheTest implements ICacheTest {
  private int count = 0;

  @Override
  public void cachedMethod() {
    count++;
  }

  @Override
  public void mutatorMethod() {
  }
}
