package a2410;

import java.io.*;
import java.util.*;

public class d07_bj_s5_11004_K번째_수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      arr[n] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    System.out.println(arr[K-1]);
  }
}
