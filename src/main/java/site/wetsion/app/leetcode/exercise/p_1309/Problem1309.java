package site.wetsion.app.leetcode.exercise.p_1309;

/**
 * 1309. 解码字母到整数映射
 * https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 *
 * @author weixin
 * @version 1.0
 * @date 2020/5/13 10:49 AM
 */
public class Problem1309 {
    class Solution {
        /**
         * 使用逆序方式
         *
         **/
        public String freqAlphabets(String s) {
            char[] chars = s.toCharArray();
            int arrLength = chars.length;
            int currentIndex = arrLength - 1;
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                if (currentIndex < 0) {
                    break;
                }
                if (chars[currentIndex] == '#') {
                    char a = chars[currentIndex - 1];
                    char b = chars[currentIndex - 2];
                    int v = Integer.parseInt(new String(new char[] {b, a}));
                    char c = (char) (v + 96);
                    stringBuilder.append(c);
                    currentIndex = currentIndex - 3;
                } else {
                    int v = Integer.parseInt(new String(new char[] {chars[currentIndex]}));
                    char c = (char) (v + 96);
                    stringBuilder.append(c);
                    currentIndex = currentIndex - 1;
                }
            }
            return stringBuilder.reverse().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'b');
        System.out.println((int) '1');
        System.out.println((char) 122);
    }
}
