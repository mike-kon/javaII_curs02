package org.learn.curs02.fraction;

import org.learn.curs02.cache.Cache;
import org.learn.curs02.cache.Mutator;

public interface Fractionable {
  double doubleValue();

  void setNum(int num);

  void setDenum(int denum);
}
