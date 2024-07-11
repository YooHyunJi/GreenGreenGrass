package a2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d11_bj_g3_22057_마법사_상어와_토네이도 {
    static int N, answer = 0;
    static int[] dr = {0, 1, 0, -1}, dc = {-1, 0, 1, 0};
    static int[][] map;
    static int[][][] percentage = {
        {{-1, 1, 1}, {1, 1, 1}, {-2, 0, 2}, {2, 0, 2}, {-1, 0, 7}, {1, 0, 7}, {-1, -1, 10}, {1, -1, 10}, {0, -2, 5}},
        {{-1, -1, 1}, {-1, 1, 1}, {0, -2, 2}, {0, 2, 2}, {0, -1, 7}, {0, 1, 7}, {1, -1, 10}, {1, 1, 10}, {2, 0, 5}},
        {{-1, -1, 1}, {1, -1, 1}, {-2, 0, 2}, {2, 0, 2}, {-1, 0, 7}, {1, 0, 7}, {-1, 1, 10}, {1, 1, 10}, {0, 2, 5}},
        {{1, -1, 1}, {1, 1, 1}, {0, -2, 2}, {0, 2, 2}, {0, -1, 7}, {0, 1, 7}, {-1, -1, 10}, {-1, 1, 10}, {-2, 0, 5}},
    };

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        tornado(N/2, N/2);
        System.out.println(answer);
    }

    static boolean isOut(int r, int c){
        return r<0 || N<=r || c<0 || N<=c;
    }

    static void tornado(int r, int c){
        int cnt = 0;
        int d = 0;
        int length = 1;
        while(r!=0 || c!=0){
            if(cnt++ == length){
                d = (d+1) % 4;
                cnt = 1;
                if(d%2 == 0){
                    length++;
                }
            }
            r += dr[d];
            c += dc[d];

            int sum = 0;
            for(int i=0; i<9; i++){
                int nr = r + percentage[d][i][0];
                int nc = c + percentage[d][i][1];
                int ns = (map[r][c] * percentage[d][i][2]) / 100;
                sum += ns;
                if(isOut(nr, nc)){
                    answer += ns;
                    continue;
                }
                map[nr][nc] += ns;
            }
            int nr = r + dr[d];
            int nc = c + dc[d];
            int ns = map[r][c] - sum;
            sum += ns;
            map[r][c] -= sum;
            if(isOut(nr, nc)){
                answer += ns;
                continue;
            }
            map[nr][nc] += ns;
        }
    }
}
