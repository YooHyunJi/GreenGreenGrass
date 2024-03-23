package a2403;

import java.io.*;

public class d23_bj_s5_1343_폴리노미오 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] board = br.readLine().toCharArray();
        String A = "AAAA";
        String B = "BB";
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for(int i=0; i<board.length; i++){
            if(board[i] == '.'){
                if (appendString(A, B, sb, len)) return;
                sb.append('.');
                len = 0;
                continue;
            }
            len++;
        }
        if (appendString(A, B, sb, len)) return;
        System.out.println(sb);
    }

    private static boolean appendString(String a, String b, StringBuilder sb, int len) {
        if(len % 2 == 1){
            System.out.println(-1);
            return true;
        }
        while(len > 2){
            sb.append(a);
            len -= 4;
        }
        if(len == 2){ sb.append(b); }
        return false;
    }
}
