package a2411;

import java.io.*;
import java.util.*;

public class d20_bj_b3_2506_점수계산 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isBeforeRight = false;
        int score = 1;
        int answer = 0;
        for(int n=0; n<N; n++){
            boolean isRight = st.nextToken().equals("1");
            if(isRight){
                if(!isBeforeRight){
                    isBeforeRight = true;
                }
                answer += score++;
            }
            else{
                isBeforeRight = false;
                score = 1;
            }
        }
        System.out.println(answer);
    }
}
