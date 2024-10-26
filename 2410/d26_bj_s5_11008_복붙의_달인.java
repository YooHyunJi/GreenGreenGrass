package a2410;

import java.io.*;
import java.util.*;

public class d26_bj_s5_11008_복붙의_달인 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String P = st.nextToken();
            String afterP = S.replaceAll(P, "");
            int countP = (S.length() - afterP.length()) / P.length();
            sb.append(afterP.length() + countP).append("\n");
        }
        System.out.println(sb);
    }
}
