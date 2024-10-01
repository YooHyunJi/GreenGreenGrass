package a2410;

import java.io.*;

public class d01_bj_s4_9507_Generations_of_Tribbles {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] fibonacci = new long[68];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        fibonacci[3] = 4;
        for(int n=4; n<=67; n++){
            fibonacci[n] = fibonacci[n - 1] + fibonacci[n - 2] + fibonacci[n - 3]+ fibonacci[n - 4];
        }
        for(int t=0; t<T; t++){
            sb.append(fibonacci[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}
