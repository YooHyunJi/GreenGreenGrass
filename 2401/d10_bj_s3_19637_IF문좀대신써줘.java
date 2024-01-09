package a2401;

import java.io.*;
import java.util.*;

public class d10_bj_s3_19637_IF문좀대신써줘 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] max = new int[N];
        String[] label = new String[N];

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            label[n] = st.nextToken();
            max[n] = Integer.parseInt(st.nextToken());
        }
        for(int m=0; m<M; m++) {
            int power = Integer.parseInt(br.readLine());
            int from = 0;
            int toto = N-1;
            while(from <= toto) {
                int mid = (from + toto) / 2;
                if(power<=max[mid]) { toto = mid - 1; }
                else { from = mid + 1; }
            }
            sb.append(label[from]).append("\n");
        }
        System.out.println(sb);
    }
}