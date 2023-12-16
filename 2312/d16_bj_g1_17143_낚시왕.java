package etc;

import java.io.*;
import java.util.*;

public class d16_bj_g1_17143_낚시왕 {
    static int R, C, M;
    static int[] dr = {0, -1, 1, 0, 0}, dc = {0, 0, 0, 1, -1};
    static int[][] pool;
    static HashMap<Integer, int[]> sharks = new HashMap<>();
    static List<Integer> deadSharks = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        R = Integer.parseInt(st.nextToken())+1;
        C = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        pool = new int[R][C];
        for(int r=1; r<R; r++) Arrays.fill(pool[r], -1);
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int[] shark = new int[4];
            for(int s=0; s<4; s++) shark[s] = Integer.parseInt(st.nextToken());
            shark[2] = zip(shark[2], shark[3]);
            int size = Integer.parseInt(st.nextToken());
            sharks.put(size, shark);
            pool[shark[0]][shark[1]] = size;
        }
        for(int king=1; king<C; king++){
            answer += fishing(king);
            sharks.forEach((size, shark) -> { sharkMoves(size, shark); });
            deadSharks.clear();
            sharks.forEach((size, shark) -> { setShark(size, shark); });
            for(int shark: deadSharks) sharks.remove(shark);
        }
        System.out.println(answer);
    }

    private static int zip(int s, int z){
        if(z<3) return s%(2*(R-2));
        else return s%(2*(C-2));
    }

    private static int fishing(int king){
        for(int r=1; r<R; r++){
            if(pool[r][king] != -1){
                int size = pool[r][king];
                pool[r][king] = -1;
                sharks.remove(size);
                return size;
            }
        }
        return 0;
    }

    private static void sharkMoves(int size, int[] shark){
        pool[shark[0]][shark[1]] = -1;
        for(int s=0; s<shark[2]; s++){
            int nr = shark[0] + dr[shark[3]];
            int nc = shark[1] + dc[shark[3]];
            if(isOver(nr, nc)){
                shark[3] = changeDirection(shark[3]);
                nr = shark[0] + dr[shark[3]];
                nc = shark[1] + dc[shark[3]];
            }
            shark[0] = nr;
            shark[1] = nc;
        }
        sharks.replace(size, shark);
    }

    private static boolean isOver(int r, int c){
        return r < 1 || r >=R || c < 1 || c >= C;
    }

    private static int changeDirection(int d){
        if(d%2==1) return d+1;
        else return d-1;
    }

    private static void setShark(int size, int[] shark){
        int newSize = size;
        if(pool[shark[0]][shark[1]] != -1) newSize = oneShark(pool[shark[0]][shark[1]], size);
        pool[shark[0]][shark[1]] = newSize;
    }

    private static int oneShark(int size1, int size2) {
        if (size1 > size2) {
            deadSharks.add(size2);
            return size1;
        } else {
            deadSharks.add(size1);
            return size2;
        }
    }
}