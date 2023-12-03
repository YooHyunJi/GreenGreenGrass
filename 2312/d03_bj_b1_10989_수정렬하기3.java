package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class d03_bj_b1_10989_수정렬하기3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[Integer.parseInt(br.readLine())];
        for(int n=0; n<arr.length; n++) arr[n] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for(int n=0; n<arr.length; n++) sb.append(arr[n]).append("\n");
        System.out.println(sb.toString());
    }
}
