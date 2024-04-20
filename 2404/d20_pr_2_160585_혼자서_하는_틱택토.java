package a2404;

public class d20_pr_2_160585_혼자서_하는_틱택토 {
    public int solution(String[] board) {
        int answer = 1;

        char[][] arr = new char[3][3];
        int totalCntO = 0, totalCntX = 0;
        int cnt1O = 0, cnt1X = 0;
        int cnt2O = 0, cnt2X = 0;

        // count O, X
        for(int r=0; r<3; r++){
            arr[r] = board[r].toCharArray();
            for(int c=0; c<3; c++){
                if(arr[r][c] == 'O'){ totalCntO++; }
                else if(arr[r][c] == 'X'){ totalCntX++; }
            }
        }
        if(totalCntO < totalCntX || totalCntO - totalCntX > 1){ return 0; }

        // horizontal, vertical
        for(int r=0; r<3; r++){
            cnt1O = 0; cnt1X = 0;
            cnt2O = 0; cnt2X = 0;
            for(int c=0; c<3; c++){
                if(arr[r][c] == 'O'){ cnt1O++; }
                else if(arr[r][c] == 'X'){ cnt1X++; }
                if(arr[c][r] == 'O'){ cnt2O++; }
                else if(arr[c][r] == 'X'){ cnt2X++; }
            }
            if((cnt1O==3 && totalCntO!=totalCntX+1) ||
                    (cnt1X==3 && totalCntO!=totalCntX) ||
                    (cnt2O==3 && totalCntO!=totalCntX+1) ||
                    (cnt2X==3 && totalCntO!=totalCntX)){ return 0; }
        }

        // diagonal
        cnt1O = 0; cnt1X = 0;
        cnt2O = 0; cnt2X = 0;
        for(int r=0; r<3; r++){
            if(arr[r][r] == 'O'){ cnt1O++; }
            else if(arr[r][r] == 'X'){ cnt1X++; }
            if(arr[r][2-r] == 'O'){ cnt2O++; }
            else if(arr[r][2-r] == 'X'){ cnt2X++; }
        }
        if((cnt1O==3 && totalCntO!=totalCntX+1) ||
                (cnt1X==3 && totalCntO!=totalCntX) ||
                (cnt2O==3 && totalCntO!=totalCntX+1) ||
                (cnt2X==3 && totalCntO!=totalCntX)){ return 0; }

        return answer;
    }
}
