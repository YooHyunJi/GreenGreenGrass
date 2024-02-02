package a2402;

import java.io.*;
import java.util.*;

public class d02_bj_b5_3003_킹퀸룩비숍나이트폰 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = {1, 1, 2, 2, 2, 8};
        for(int n=0; n<6; n++){
            System.out.print(arr[n]-Integer.parseInt(st.nextToken())+" ");
        }
    }
}
