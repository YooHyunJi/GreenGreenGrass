package a2409;

import java.io.*;

public class d10_bj_b4_23795_사장님_도박은_재미로_하셔야_합니다 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int num = 0;
        while(true){
            num = Integer.parseInt(br.readLine());
            if(num == -1){
                System.out.println(answer);
                return;
            }
            answer += num;
        }
    }
}
