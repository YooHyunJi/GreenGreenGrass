package a2507;

import java.io.*;

public class d07_bj_b3_4892_숫자_맞추기_게임 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; ; i++){
            int n0 = Integer.parseInt(br.readLine());
            if(n0 == 0){
                System.out.println(sb);
                return;
            }
            int n1, n2, n3, n4;
            n1 = n0 * 3;
            if(n1 % 2 == 0){
                n2 = n1 / 2;
            }
            else{
                n2 = (n1 + 1) / 2;
            }

            n3 = n2 * 3;
            n4 = n3 / 9;
            sb.append(i).append(". ").append(n1 % 2 == 0? "even ": "odd ").append(n4).append("\n");
        }
    }
}
