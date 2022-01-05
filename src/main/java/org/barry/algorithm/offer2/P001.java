package org.barry.algorithm.offer2;

/**
 * 二进制的题目
 *
 * @author Barry
 * @since 2022/1/5 9:38
 */
public class P001 {
    public int divide(int a, int b) {
        // JAVA： Math.abs(Integer.MIN_VALUE)=Integer.MIN_VALUE
        // 边界处理  负数比正数多一位（导致变成正数的话会溢出）
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;

        // 异或 (不同则true，相同则false)
        boolean sign = (a > 0) ^ (b > 0);

        // 处理（32位环境 负数整形比正数多一问题）
        // 将两个数 转为 对应的 负数 做运算

        long dividend = a > 0 ? -a : a;
        long divisor = b > 0 ? -b : b;
        if (dividend > divisor) {
            return 0;
        }

        int res = 0;
        int shift = 31;

        while (dividend <= divisor) {
            while (dividend > divisor << shift) {
                shift--;
            }
            dividend -= divisor << shift;
            res += 1 << shift;
        }
        return sign ? -res : res;
    }
}
