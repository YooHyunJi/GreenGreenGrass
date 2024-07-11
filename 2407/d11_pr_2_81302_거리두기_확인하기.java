package a2407;

class d11_pr_2_81302_거리두기_확인하기 {
    static boolean isFail;
    static boolean[][] visit;
    static char[][] room;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i=0; i<5; i++){
            isFail = false;
            room = new char[5][5];
            visit = new boolean[5][5];
            for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    room[r][c] = places[i][r].charAt(c);
                }
            }
            for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(room[r][c] == 'P'){
                        visit = new boolean[5][5];
                        DFS(r, c, 0, false);
                    }
                    if(isFail){ break; }
                }
                if(isFail){ break; }
            }
            answer[i] = isFail? 0: 1;
        }

        return answer;
    }

    static boolean isOut(int r, int c){
        return r<0 || 4<r || c<0 || 4<c;
    }

    static void DFS(int r, int c, int dist, boolean isBlocked){
        if(isFail){ return; }
        if(room[r][c] == 'P' && dist != 0){
            if(dist < 3 && !isBlocked){
                isFail = true;
            }
            return;
        }
        visit[r][c] = true;
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isOut(nr, nc) || visit[nr][nc]){ continue; }
            if(room[nr][nc] == 'X'){ DFS(nr, nc, dist+1, true); }
            else{ DFS(nr, nc, dist+1, isBlocked); }

        }
        visit[r][c] = false;
    }
}