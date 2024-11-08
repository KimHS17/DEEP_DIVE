package day07;

import java.util.*;

public class BinarySearch {
    static int binarySearch(int n, int m, int[] tree, int high) {
        int low = 0, mid = 0;

        while(low < high) {
            int sum = 0;
            mid = low + (high - low) / 2;

            for(int i = 0; i < n; i++) {
                sum += Math.max(tree[i] - mid, 0);
            }

            if(sum == m) {
                break;
            } else if(sum < m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] tree = new int[n];
        int max = 0, ans;

        for(int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
            max = Math.max(max, tree[i]);
        }

        ans = binarySearch(n, m, tree, max);
        System.out.println(ans);
    }
}
