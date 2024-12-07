import java.io.*;
import java.util.*;

public class d07_bj_b4_10039_평균_점수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for(int i=0; i<5; i++){
          int score = Integer.parseInt(br.readLine());
          answer += score < 40? 40: score;
        }
        System.out.println(answer/5);
    }
}
