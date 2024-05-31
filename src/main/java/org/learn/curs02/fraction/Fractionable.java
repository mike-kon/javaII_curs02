package org.learn.curs02.fraction;

import org.learn.curs02.cache.Cache;
import org.learn.curs02.cache.Mutator;

public interface Fractionable {
  @Cache
  double doubleValue();

  @Mutator
  void setNum(int num);

  @Mutator
  void setDenum(int denum);
}
