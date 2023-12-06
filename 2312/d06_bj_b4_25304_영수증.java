import java.util.*;
import java.io.*;

public class d06_bj_b4_25304_영수증 {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int quan = Integer.parseInt(br.readLine());
        int real = 0;
        for(int q=0; q<quan; q++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            real += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        }
        if(total == real) System.out.println("Yes");
        else System.out.println("No");
    }
}
