package a2404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class d16_bj_g5_20055_컨베이어_벨트_위의_로봇 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belts = new int[2*N];
        boolean[] isRobot = new boolean[2*N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<2*N; n++){ belts[n] = Integer.parseInt(st.nextToken()); }

        int idxOn = 0;
        int cntZero = 0;
        int answer = 0;
        List<Integer> robots = new ArrayList<>();

        while(cntZero < K){
            answer++;

            // rotate belt
            idxOn = (2*N + idxOn - 1) % (2*N);
            int idxOff = (idxOn + N - 1) % (2*N);
            if(isRobot[idxOff]){
                robots.remove(new Integer(idxOff));
                isRobot[idxOff] = false;
            }

            // move robots
            for(int i=0; i<robots.size(); i++){
                int idxNow = robots.get(i);
                int idxNxt = (idxNow + 1) % (2*N);
                if(belts[idxNxt] > 0 && !isRobot[idxNxt]) {
                    isRobot[idxNow] = false;
                    if(--belts[idxNxt] == 0){ cntZero++; }

                    if(idxNxt == idxOff){
                        robots.remove(new Integer(idxNow));
                        i--;
                    }
                    else{
                        robots.set(i, idxNxt);
                        isRobot[idxNxt] = true;
                    }
                }
            }

            // put robot
            if(belts[idxOn] > 0 && !isRobot[idxOn]) {
                robots.add(idxOn);
                isRobot[idxOn] = true;
                if(--belts[idxOn] == 0){ cntZero++; }
            }
        }
        System.out.println(answer);
    }
}
