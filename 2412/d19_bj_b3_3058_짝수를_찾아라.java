import java.io.*;
import java.util.*;

public class d19_bj_b3_3058_짝수를_찾아라 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = 101;
            int sum = 0;
            for(int i=0; i<7; i++){
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 1){ continue; }
                min = Math.min(min, num);
                sum += num;
            }
            sb.append(sum).append(" ").append(min).append("\n");
        }
        
        System.out.println(sb);
    }
}
