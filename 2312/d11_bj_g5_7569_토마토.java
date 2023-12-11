package etc;

import java.util.*;
import java.io.*;

public class d11_bj_g5_7569_토마토 {
    private static int M, N, H, tomatos=0;
    private static int[] dh = {0, 0, 0, 0, -1, 1}, dn = {-1, 0, 1, 0, 0, 0}, dm = {0, 1, 0, -1, 0, 0};
    private static int[][][] box;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++){
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if(box[h][n][m]==0) tomatos++;
                    else if(box[h][n][m]==1) queue.offerLast(new int[] {h, n, m, 0});
                }
            }
        }
        System.out.println(ripening(queue));
    }

    private static int ripening(ArrayDeque<int[]> queue){
        if(tomatos==0) return 0;
        int days = 0;
        while(!queue.isEmpty()){
            int[] tomato = queue.pollFirst();
            days = tomato[3];
            for(int d=0; d<6; d++){
                int newH = tomato[0]+dh[d];
                int newN = tomato[1]+dn[d];
                int newM = tomato[2]+dm[d];
                if(canRipening(newH, newN, newM)){
                    box[newH][newN][newM] = 1;
                    if(--tomatos == 0) return days+1;
                    queue.offerLast(new int[] {newH, newN, newM, days+1});
                }
            }
        }
        if(tomatos!=0) return -1;
        return days;
    }

    private static boolean canRipening(int h, int n, int m){
        if(h<0 || h>=H ||
           n<0 || n>=N ||
           m<0 || m>=M ||
           box[h][n][m] != 0) return false;
        return true;
    }
}