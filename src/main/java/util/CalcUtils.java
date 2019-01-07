package util;

import java.math.BigDecimal;

/**
 * BigDecimal 计算类
 * see BigDecimal
 * Created by 姚磊 on 2017/11/6.
 */
public class CalcUtils {

  /**
   * 2个数相加
   */
  public static BigDecimal add(BigDecimal a, BigDecimal b) {
    return a.add(b);
  }

  /**
   * 2个数相减
   */
  public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
    return a.subtract(b);
  }

  /**
   * 2个数相乘
   */
  public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
    return a.multiply(b);
  }

  /**
   * 2个数相乘(剔除小数位)
   */
  public static BigDecimal multiplyScale(BigDecimal a, BigDecimal b) {
    return a.multiply(b).setScale(0, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * 2个数相除(剔除小数位)
   */
  public static BigDecimal divide(BigDecimal a, BigDecimal b) {
    return a.divide(b, 0, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * 格式化数字((剔除小数位)
   */
  public static BigDecimal format(BigDecimal value) {
    return value.setScale(2, BigDecimal.ROUND_HALF_UP);
  }

}
