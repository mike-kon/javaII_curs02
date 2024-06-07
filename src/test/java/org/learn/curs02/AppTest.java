package org.learn.curs02;


import org.junit.jupiter.api.Test;
import org.learn.curs02.cache.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
  @Test
  public void runTest() {
    CacheTest ct = new CacheTest();
    ICacheTest cacheTest = Util.cache(ct);
    assertEquals(0,ct.getCount());
    cacheTest.cachedMethod();
    assertEquals(1,ct.getCount());
    cacheTest.cachedMethod();
    cacheTest.cachedMethod();
    cacheTest.cachedMethod();
    cacheTest.cachedMethod();
    assertEquals(1,ct.getCount());
    cacheTest.mutatorMethod();
    cacheTest.cachedMethod();
    assertEquals(2,ct.getCount());
    cacheTest.cachedMethod();
    cacheTest.cachedMethod();
    cacheTest.cachedMethod();
    assertEquals(2,ct.getCount());
  }

}
