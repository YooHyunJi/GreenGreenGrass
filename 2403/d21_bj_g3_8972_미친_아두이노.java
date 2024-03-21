package a2403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class d21_bj_g3_8972_미친_아두이노 {
    static int R, C;
    static int[] jongsu,
            dr = {1, 1, 1, 0, 0, 0, -1, -1, -1},
            dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static char[][] board;
    static List<int[]> robots = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for(int r=0; r<R; r++){
            board[r] = br.readLine().toCharArray();
            for(int c=0; c<C; c++){
                if(board[r][c] == '.'){ continue; }
                if(board[r][c] == 'R'){ robots.add(new int[] {r, c}); }
                else{ jongsu = new int[] {r, c}; }
            }
        }
        String directions = br.readLine();
        for(int step=0; step<directions.length(); step++){
            if(!play(directions.charAt(step) - '1')){
                System.out.println("kraj "+(step+1));
                return;
            }
        }
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(board[r][c]);
            } sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean play(int direction){

        // 1. jongsu moves
        board[jongsu[0]][jongsu[1]] = '.';
        jongsu[0] += dr[direction];
        jongsu[1] += dc[direction];

        // 1-1. if jongsu moved to crazy robot
        if(board[jongsu[0]][jongsu[1]] == 'R'){ return false; }
        board[jongsu[0]][jongsu[1]] = 'I';

        // 2. crazy robots move
        boolean[][] v = new boolean[R][C];
        ArrayDeque<int[]> duplicated = new ArrayDeque<>();
        for(int[] robot: robots){
            board[robot[0]][robot[1]] = '.';

            robot[0] = robot[0] < jongsu[0]? robot[0]+1: robot[0] > jongsu[0]? robot[0]-1: robot[0];
            robot[1] = robot[1] < jongsu[1]? robot[1]+1: robot[1] > jongsu[1]? robot[1]-1: robot[1];

            if(board[robot[0]][robot[1]] == 'I'){ return false; }
            if(v[robot[0]][robot[1]]){ duplicated.offerLast(new int[] {robot[0], robot[1]}); }
            else{ v[robot[0]][robot[1]] = true; }
        }

        while(!duplicated.isEmpty()){
            int[] now = duplicated.pollFirst();
            for(int r=robots.size()-1; r>=0; r--){
                if(now[0] == robots.get(r)[0] && now[1] == robots.get(r)[1]){ robots.remove(r); }
            }
        }

        for(int[] robot: robots){ board[robot[0]][robot[1]] ='R'; }

        return true;
    }
}
