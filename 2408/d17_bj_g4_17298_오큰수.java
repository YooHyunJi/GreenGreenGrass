package a2408;

import java.io.*;
import java.util.*;

public class d17_bj_g4_17298_오큰수 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Arrays.fill(arr, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peekFirst()[0] < num){
                arr[stack.pollFirst()[1]] = num;
            }
            stack.offerFirst(new int[] {num, n});
        }
        for(int n=0; n<N; n++){
            sb.append(arr[n]).append(" ");
        }
        System.out.println(sb);
    }
}

/*
5
3 5 1 2 7
*/