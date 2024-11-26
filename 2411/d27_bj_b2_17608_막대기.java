package a2411;

import java.io.*;

public class d27_bj_b2_17608_막대기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }
        int max = arr[N-1];
        int answer = 1;
        for(int n=N-2; n>=0; n--){
            if(max < arr[n]){
                max = arr[n];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
