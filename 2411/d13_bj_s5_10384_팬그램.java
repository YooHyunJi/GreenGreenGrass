package a2411;

import java.io.*;

public class d13_bj_s5_10384_팬그램 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int[] arr = new int[26];
            char[] line = br.readLine().toLowerCase().toCharArray();
            int result = Integer.MAX_VALUE;
            for(char c: line){
                int num = c - 97;
                if(num < 0){ continue; }
                arr[num]++;
            }
            for(int n=0; n<26; n++){
                result = Math.min(result, arr[n]);
            }
            sb.append("Case ").append(t+1).append(": ");
            switch (result){
                case 0:
                    sb.append("Not a pangram\n");
                    break;
                case 1:
                    sb.append("Pangram!\n");
                    break;
                case 2:
                    sb.append("Double pangram!!\n");
                    break;
                case 3:
                    sb.append("Triple pangram!!!\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
