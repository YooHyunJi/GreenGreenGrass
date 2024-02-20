package a2402;

import java.io.*;
import java.util.*;

public class d20_bj_g5_2174_로봇시뮬레이션 {
    static class Robot{
        int x;
        int y;
        int d;

        public Robot(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int A, B;
    static int[][] map, dArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static String answer = "";
    static Robot[] robots;
    static HashMap<String, Integer> directions = new HashMap<String, Integer>()
    {{ put("N", 0); put("E", 1); put("S", 2); put("W", 3); }};

    static boolean moveRobot(int rNo, int repeat, int d){
        int dx = dArr[d][0];
        int dy = dArr[d][1];
        
        for(int r=1; r<=repeat; r++){
            if(robots[rNo].x+r*dx<1 || robots[rNo].x+r*dx>B || robots[rNo].y+r*dy<1 || robots[rNo].y+r*dy>A){
                answer = "Robot "+rNo+" crashes into the wall";
                return false;
            }
            if(map[robots[rNo].x+r*dx][robots[rNo].y+r*dy]>0){
                answer = "Robot "+rNo+" crashes into robot "+map[robots[rNo].x+r*dx][robots[rNo].y+r*dy];
                return false;
            }
        }
        map[robots[rNo].x][robots[rNo].y] = 0;
        robots[rNo].x += dx * repeat;
        robots[rNo].y += dy * repeat;
        map[robots[rNo].x][robots[rNo].y] = rNo;
        return true;
    }

    static boolean doOperation(int rNo, String op, int repeat){
        if(op.equals("L")){
            robots[rNo].d = (4+robots[rNo].d-repeat%4)%4;
            return true;
        } else if(op.equals("R")){
            robots[rNo].d = (robots[rNo].d+repeat)%4;
            return true;
        }
        return moveRobot(rNo, repeat, robots[rNo].d);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[B+1][A+1];
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        robots = new Robot[N+1];
        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = B-Integer.parseInt(st.nextToken())+1;
            int d = directions.get(st.nextToken());
            robots[n] = new Robot(y, x, d);
            map[y][x] = n;
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int rNo = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int repeat = Integer.parseInt(st.nextToken());
            if(!doOperation(rNo, op, repeat)){
                System.out.println(answer);
                return;
            }
        }
        System.out.println("OK");
    }
}