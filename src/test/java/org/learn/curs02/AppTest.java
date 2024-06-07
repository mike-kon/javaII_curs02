package org.learn.curs02;


import org.junit.jupiter.api.Test;
import org.learn.curs02.cache.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
  @Test
  public void runCachTest() {
    CacheTest ct = new CacheTest();
    ICacheTest cacheTest = Util.cache(ct);
    assertEquals(0,ct.getCachedCount());
    cacheTest.cachedMethod();
    assertEquals(1,ct.getCachedCount());
    cacheTest.cachedMethod();
    cacheTest.cachedMethod();
    cacheTest.cachedMethod();
    cacheTest.cachedMethod();
    assertEquals(1,ct.getCachedCount());
  }
  @Test
  public void runMutatorTest() {
    CacheTest ct = new CacheTest();
    ICacheTest cacheTest = Util.cache(ct);
    assertEquals(0,ct.getCachedCount());
    cacheTest.cachedMethod();
    cacheTest.cachedMethod();
    assertEquals(1,ct.getCachedCount());
    cacheTest.mutatorMethod();
    cacheTest.cachedMethod();
    assertEquals(2,ct.getCachedCount());
  }

  @Test
  public void nunCachedTest(){
    CacheTest ct = new CacheTest();
    ICacheTest cacheTest = Util.cache(ct);
    assertEquals(0, ct.getNonCachedCount());
    cacheTest.nonCachedMethod();
    assertEquals(1, ct.getNonCachedCount());
    cacheTest.nonCachedMethod();
    assertEquals(2, ct.getNonCachedCount());
  }
}
