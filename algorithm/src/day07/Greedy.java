package day07;

import java.util.*;

public class Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] w = new int[t];
        int ans = 0;

        for(int i = 0; i < t; i++) {
            w[i] = sc.nextInt();
        }

        Arrays.sort(w);
        t--;
        while(true) {
            ans += w[t];
            t -= n;
            if(t < 0) {
                ans += w[t + n - 1];
                break;
            }
        }

        System.out.println(ans);
    }
}
