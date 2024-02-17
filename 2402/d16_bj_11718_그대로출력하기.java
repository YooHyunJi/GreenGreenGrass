package a2402;

import java.io.*;

public class d16_bj_11718_그대로출력하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while(((line=br.readLine())!=null)&&(line.length()>0)){
            sb.append(line).append("\n");
        }
        System.out.println(sb);
    }
}
