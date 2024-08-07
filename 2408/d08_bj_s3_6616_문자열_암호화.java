package a2408;

import java.io.*;

public class d08_bj_s3_6616_문자열_암호화 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        while(0 < N){
            str = str.replaceAll(" ", "").toUpperCase();
            int S = str.length();
            char[] arr = str.toCharArray();
            char[] tmp = new char[S];
            int cnt = 0;

            for(int i=0; i<S; i++){
                for(int j=i; j<S; j+=N){
                    tmp[j] = arr[cnt++];
                }
                if(cnt == S){ break; }
            }
            StringBuilder s = new StringBuilder();
            for(int i=0; i<S; i++){
                s.append(tmp[i]);
            }
            sb.append(s).append("\n");

            N = Integer.parseInt(br.readLine());
            str = br.readLine();
        }
        System.out.println(sb);
    }
}
