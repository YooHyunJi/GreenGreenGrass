package a2312;

import java.io.*;
import java.util.*;

public class d24_bj_g5_20055_컨베이어벨트위의로봇 {
    static class block{
        int id;
        boolean isUsing;

        public block(int id, boolean isUsing){
            this.id = id;
            this.isUsing = isUsing;
        }
    }

    static int N, K, disable=0;
    static int[] durability;
    static block[] conveyor;

    private static void rotateBelt() {
        for(int n=N-1; n>0; n--){
            conveyor[n].id = (2*N+conveyor[n].id-1)%(2*N);
            conveyor[n].isUsing = conveyor[n-1].isUsing;
        }
        conveyor[0].id = (2*N+conveyor[0].id-1)%(2*N);
        conveyor[0].isUsing = false;
        conveyor[N-1].isUsing = false;
    }

    private static void moveRobots() {
        for(int n=N-2; n>=0; n--){
            if(conveyor[n].isUsing && !conveyor[n+1].isUsing && durability[conveyor[n+1].id]>0) {
                conveyor[n+1].isUsing = true;
                conveyor[n].isUsing = false;
                if(--durability[conveyor[n+1].id]==0) { disable++; }
            }
        }
    }

    private static void putRobot() {
        if(durability[conveyor[0].id]==0) { return; }
        conveyor[0].isUsing = true;
        if(--durability[conveyor[0].id]==0) { disable++; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        conveyor = new block[N];
        durability = new int[2*N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<2*N; n++) { durability[n] = Integer.parseInt(st.nextToken()); }
        for(int n=0; n<N; n++) { conveyor[n] = new block(n, false); }

        int answer = 0;
        while(disable<K){
            answer++;
            rotateBelt();
            moveRobots();
            putRobot();
        }
        System.out.println(answer);
    }
}
