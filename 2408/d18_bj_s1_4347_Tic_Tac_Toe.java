package a2408;

import java.io.*;

public class d18_bj_s1_4347_Tic_Tac_Toe {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            char[][] board = new char[3][3];
            boolean isEnd = false;
            int cntX = 0, cntO = 0;
            for(int r=0; r<3; r++){
                board[r] = br.readLine().toCharArray();
                for(int c=0; c<3; c++){
                    if(board[r][c] == 'X'){ cntX++; }
                    else if(board[r][c] == 'O'){ cntO++; }
                }
            }
            br.readLine();
            if(cntX < cntO || 1 < cntX - cntO){
                sb.append("no\n");
                continue;
            }
            int cnt1O, cnt1X, cnt2O, cnt2X;
            for(int r=0; r<3; r++){
                cnt1O = 0; cnt1X = 0;
                cnt2O = 0; cnt2X = 0;
                for(int c=0; c<3; c++){
                    if(board[r][c] == 'O'){ cnt1O++; }
                    else if(board[r][c] == 'X'){ cnt1X++; }
                    if(board[c][r] == 'O'){ cnt2O++; }
                    else if(board[c][r] == 'X'){ cnt2X++; }
                }
                if( (cnt1X==3 && cntX!=cntO+1) ||
                    (cnt1O==3 && cntX!=cntO) ||
                    (cnt2X==3 && cntX!=cntO+1) ||
                    (cnt2O==3 && cntX!=cntO)){
                    sb.append("no\n");
                    isEnd = true;
                    break;
                }
                if(isEnd){ break; }
            }
            if(isEnd){ continue; }
            cnt1O = 0; cnt1X = 0;
            cnt2O = 0; cnt2X = 0;
            for(int r=0; r<3; r++){
                if(board[r][r] == 'O'){ cnt1O++; }
                else if(board[r][r] == 'X'){ cnt1X++; }
                if(board[r][2-r] == 'O'){ cnt2O++; }
                else if(board[r][2-r] == 'X'){ cnt2X++; }
            }
            if( (cnt1X==3 && cntX!=cntO+1) ||
                (cnt1O==3 && cntX!=cntO) ||
                (cnt2X==3 && cntX!=cntO+1) ||
                (cnt2O==3 && cntX!=cntO)){
                sb.append("no\n");
                continue;
            }
            sb.append("yes\n");
        }
        System.out.println(sb);
    }
}
