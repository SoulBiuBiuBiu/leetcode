package org.barry.algorithm.offer2;

import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/12 9:56
 */
public class P018 {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left+=1;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right-=1;
            }else{
                char c1 = Character.toLowerCase(s.charAt(left++));
                char c2 = Character.toLowerCase(s.charAt(right--));
                if (c1 != c2) {
                    return false;
                }
            }
        }
        return true;
    }
}
