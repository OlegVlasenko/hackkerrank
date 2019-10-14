package com.ogvlasenko;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    private static int bribeCount;

    private static  void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        bribeCount = 0;

        IntStream.range(1, 3).forEach(k -> {
            IntStream.iterate(q.length - 1, n -> n - 1)
                    .limit(q.length - 1)
                    .forEach(i -> {
                        if (q[i] < q[i - 1]) {
                            swap(q, i, i - 1);
                            bribeCount++;
                        }
                    });
        });

        if (IntStream.range(0, q.length).filter(i -> q[i] == i).count() != 0) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribeCount);
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}