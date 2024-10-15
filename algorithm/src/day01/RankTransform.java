package day01;

import java.util.*;
import java.util.stream.Collectors;

public class RankTransform {
    public static int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));

        list = list.stream().distinct().sorted().collect(Collectors.toCollection(LinkedList::new));

        for(int i = 0; i < arr.length; i++) {
            res[i] = list.indexOf(arr[i]) + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {40, 10, 20, 30};
        int[] arr2 = {100, 100, 100};
        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};

        System.out.println("입력1 : " + Arrays.toString(arr1));
        System.out.println("출력1 : " + Arrays.toString(arrayRankTransform(arr1)));
        System.out.println();

        System.out.println("입력2 : " + Arrays.toString(arr2));
        System.out.println("출력2 : " + Arrays.toString(arrayRankTransform(arr2)));
        System.out.println();

        System.out.println("입력3 : " + Arrays.toString(arr3));
        System.out.println("출력3 : " + Arrays.toString(arrayRankTransform(arr3)));
        System.out.println();
    }
}