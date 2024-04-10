package a2404;

import java.io.*;

public class d10_bj_b1_16130_벌점_DemeritPoints {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            char[] weeks = br.readLine().toCharArray();
            int scoreSum = 0;
            int limit = 0;
            int cnt = 0;
            boolean isOut = false;
            for(char scoreNew: weeks){
                if(scoreNew <= 57){ scoreSum += scoreNew - 48; }
                else{ scoreSum += scoreNew - 55; }

                if(scoreSum / 10 > limit){
                    limit = scoreSum / 10;
                    if(limit == 4){
                        sb.append(cnt).append("(weapon)").append("\n");
                        isOut = true;
                        break;
                    }
                    else if(limit > 4){
                        sb.append(cnt).append("(09)").append("\n");
                        isOut = true;
                        break;
                    }
                    else{
                        cnt += limit;
                    }
                }
            }
            if(!isOut){
                sb.append(cnt).append("\n");
            }
        }
        System.out.println(sb);
    }
}
