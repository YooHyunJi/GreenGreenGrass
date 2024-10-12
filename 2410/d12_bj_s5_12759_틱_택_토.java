package a2410;

import java.io.*;
import java.util.*;

public class d12_bj_s5_12759_틱_택_토 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][][] arr = new boolean[2][3][3];
        int turn = Integer.parseInt(br.readLine()) - 1;
        for (int i = 0; i < 9; i++, turn = 1 - turn) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            arr[turn][r][c] = true;
            if(isPossible(arr[0]) || isPossible(arr[1])){
                System.out.println(turn + 1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean isPossible(boolean[][] arr) {
        for(int r=0; r<3; r++){
            if(arr[r][0]  && arr[r][1] && arr[r][2]){
                return true;
            }
        }

        for(int c=0; c<3; c++){
            if(arr[0][c]  && arr[1][c] && arr[2][c]){
                return true;
            }
        }

        if(arr[0][0] && arr[1][1] && arr[2][2]){
            return true;
        }

        if(arr[0][2] && arr[1][1] && arr[2][0]){
            return true;
        }

        return false;
    }
}