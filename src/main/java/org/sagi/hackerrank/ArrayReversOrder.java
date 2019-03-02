package org.sagi.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Question from https://www.hackerrank.com
 */
public class ArrayReversOrder {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int maxPosition = a.length - 1;
        int tmpLocation;
        int midLocation = a.length / 2;

        for (int i = 0; i < midLocation; i++) {
            tmpLocation = a[i];
            a[i] = a[maxPosition - i];
            a[maxPosition - i] = tmpLocation;
        }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/Temp/result.txt"));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);
        System.out.println(Arrays.toString(res));

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }


        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

