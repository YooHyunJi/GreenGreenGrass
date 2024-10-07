package a2410;

import java.io.*;
import java.util.*;

public class d08_bj_b2_2399_거리의_합 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long answer = 0;
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int n=0; n<N; n++){
      arr[n] = Integer.parseInt(st.nextToken());
    }
    for(int i=0; i<N; i++){
      for(int j=i+1; j<N; j++){
        answer += Math.abs(arr[i] - arr[j]);
      }
    }
    System.out.println(2 * answer);
  }
}
