import java.io.*;
import java.util.*;

public class d14_bj_b3_2953_나는_요리사다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max_p = 0;
        int max_s = 0;
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j=0; j<4; j++){
                sum += Integer.parseInt(st.nextToken());
            }
            if(max_s < sum){
                max_s = sum;
                max_p = i + 1;
            }
        }
        System.out.println(max_p + " " + max_s);
    }
}
