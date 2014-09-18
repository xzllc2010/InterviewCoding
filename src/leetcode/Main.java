package leetcode;

import java.util.LinkedList;

/**
 * Project : InterviewCoding
 * Package : leetcode
 * Author  : xzllc2010<xzllc2010@gmail.com>
 * Create  : On 9/18/2014
 */
public class Main {


    public static void main(String[] args) {

        int[] ar = new int[11];
        for (int i = 0; i < 5; i++){
            ar[i] = i + 1;
        }
        for (int i = 5; i < 11; i++){
            ar[i] = i - 4;
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i < 11; i++){
            ar[0] = ar[0] ^ ar[i];
        }
        System.out.println(ar[0]);

    }

    public static long upstairs(int num) {
        long[] subresult = new long[81];
        subresult[1] = 1;
        subresult[2] = 2;

        if (num <= 2) {
            return subresult[num];
        }

        for (int j = 3; j <= num; j++){
            subresult[j] = subresult[j - 1] + subresult[j - 2];
        }
       return subresult[num];

    }

    public static void permutation(int[] num, int start, int end) {
        if (start == end) {
            for (int i = 0; i <= end; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
        } else {
            for (int j = start; j <= end; j++) {
                int tmp = num[j];
                num[j] = num[start];
                num[start] = tmp;
                permutation(num, start + 1, end);
                int tmp2 = num[j];
                num[j] = num[start];
                num[start] = tmp2;
            }
        }
    }

    public static boolean isContains(char[] src, char[] des) {

        int len = src.length;
        for (int i = 0; i < len; i++) {
            char lastChar = src[len - 1];
            for (int j = len - 1; j > 0; j--) {
                src[j] = src[j - 1];
            }
            src[0] = lastChar;
            if (String.copyValueOf(src).contains(String.copyValueOf(des))) {
                return true;
            }
        }
        return false;
    }
}

