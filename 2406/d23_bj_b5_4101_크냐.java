package a2406;

import java.io.*;
import java.util.*;

public class d23_bj_b5_4101_크냐 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==0 && b==0){ break; }
            sb.append(a>b? "Yes":"No").append("\n");
        }
        System.out.println(sb);
    }
}
