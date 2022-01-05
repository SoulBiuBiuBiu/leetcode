package org.barry.algorithm.offer2;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/5 11:02
 */
public class P002 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        //假设a的长度大于b的长度
        if (a.length() < b.length()) {
            String tmp = b;
            b = a;
            a = tmp;
        }
        //从右到左相加
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int more = 0;
        while (indexB >= 0) {
            int t = more + (a.charAt(indexA) - '0') + (b.charAt(indexB) - '0');
            sb.append(t % 2);
            more = t / 2;
            indexA--;
            indexB--;
        }
        while (indexA >= 0) {
            int t = more + (a.charAt(indexA) - '0');
            sb.append(t % 2);
            more = t / 2;
            indexA--;
        }
        if (more == 1) sb.append(1);

        return sb.reverse().toString();
    }
}
