package a2402.study.week4;

import java.io.*;
import java.util.*;

public class d26_bj_g4_1253_좋다 {
    static int N;
    static int[] arr;
    static boolean isFound;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N<3){
            System.out.println(0);
            return;
        }
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ arr[n] = Integer.parseInt(st.nextToken()); }
        Arrays.sort(arr);
        int answer = 0;
        for(int n=0; n<N; n++){
            isFound = false;
            for(int m=0; m<N; m++){
                if(n==m){ continue; }
                if(findOther(0, N-1, arr[n]-arr[m], n, m)){
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean findOther(int from, int to, int num, int idxN, int idxM) {
        if(isFound){ return true; }
        if(from>to){ return false; }
        if(from == to){
            if(from != idxN && from != idxM && arr[from] == num){
                isFound = true;
                return true;
            }
            return false;
        }
        int mid = (from+to)/2;
        if(num < arr[mid]){ return findOther(from, mid-1, num, idxN, idxM); }
        if(mid != idxN && mid != idxM && arr[mid] == num){
            isFound = true;
            return true;
        }
        return findOther(mid+1, to, num, idxN, idxM);
    }
}
