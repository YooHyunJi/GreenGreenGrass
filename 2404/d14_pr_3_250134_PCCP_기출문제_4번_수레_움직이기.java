package a2404;

class d14_pr_3_250134_PCCP_기출문제_4번_수레_움직이기 {
    static int N, M, answer;
    private int[] endR, endB, dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    private boolean[][] vRed, vBlue;

    public int solution(int[][] maze) {
        answer = Integer.MAX_VALUE;

        N = maze.length;
        M = maze[0].length;

        vRed = new boolean[N][M];
        vBlue = new boolean[N][M];

        int[] startR = new int[2];
        int[] startB = new int[2];
        endR = new int[2];
        endB = new int[2];

        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                switch(maze[n][m]){
                    case 1:
                        startR[0] = n;
                        startR[1] = m;
                        break;
                    case 2:
                        startB[0] = n;
                        startB[1] = m;
                        break;
                    case 3:
                        endR[0] = n;
                        endR[1] = m;
                        break;
                    case 4:
                        endB[0] = n;
                        endB[1] = m;
                        break;
                }
            }
        }
        vRed[startR[0]][startR[1]] = true;
        vBlue[startB[0]][startB[1]] = true;
        travel(maze, 0, false, false, startR[0], startR[1], startB[0], startB[1]);
        if(answer == Integer.MAX_VALUE){ answer = 0; }

        return answer;
    }

    private void travel(int[][] maze, int step, boolean isEndR, boolean isEndB, int redR, int redC, int blueR, int blueC){
        if(answer <= step){ return; }

        // 빨강, 파랑 모두 종료
        if(isEndR && isEndB){
            answer = step;
            return;
        }

        // 파랑은 끝, 빨강만 이동
        if(isEndB){
            for(int d=0; d<4; d++){
                int nrR = redR + dr[d];
                int ncR = redC + dc[d];
                if(isOut(nrR, ncR) || maze[nrR][ncR] == 5 || (nrR == blueR && ncR == blueC) || vRed[nrR][ncR]){ continue; }
                vRed[nrR][ncR] = true;
                if(nrR == endR[0] && ncR == endR[1]){ travel(maze, step+1, true, isEndB, nrR, ncR, blueR, blueC); }
                else{ travel(maze, step+1, false, isEndB, nrR, ncR, blueR, blueC); }
                vRed[nrR][ncR] = false;
            }
        }

        // 빨강은 끝, 파랑만 이동
        else if(isEndR){
            for(int dd=0; dd<4; dd++){
                int nrB = blueR + dr[dd];
                int ncB = blueC + dc[dd];
                if(isOut(nrB, ncB) || maze[nrB][ncB] == 5 || (nrB == redR && ncB == redC) || vBlue[nrB][ncB]){ continue; }
                vBlue[nrB][ncB] = true;
                if(nrB == endB[0] && ncB == endB[1]){ travel(maze, step+1, isEndR, true, redR, redC, nrB, ncB); }
                else{ travel(maze, step+1, isEndR, false, redR, redC, nrB, ncB); }
                vBlue[nrB][ncB] = false;
            }
        }

        // 둘 다 이동
        else{
            // 빨강 먼저 이동
            for(int d=0; d<4; d++){
                int nrR = redR + dr[d];
                int ncR = redC + dc[d];
                if(isOut(nrR, ncR) || maze[nrR][ncR] == 5 || (nrR == blueR && ncR == blueC) || vRed[nrR][ncR]){ continue; }

                for(int dd=0; dd<4; dd++){
                    int nrB = blueR + dr[dd];
                    int ncB = blueC + dc[dd];
                    if(isOut(nrB, ncB) || maze[nrB][ncB] == 5 || (nrB == nrR && ncB == ncR) || vBlue[nrB][ncB]){ continue; }

                    boolean nextRed = nrR == endR[0] && ncR == endR[1];
                    boolean nextBlue = nrB == endB[0] && ncB == endB[1];
                    vRed[nrR][ncR] = true;
                    vBlue[nrB][ncB] = true;
                    travel(maze, step+1, nextRed, nextBlue, nrR, ncR, nrB, ncB);
                    vRed[nrR][ncR] = false;
                    vBlue[nrB][ncB] = false;
                }
            }

            // 파랑 먼저 이동
            for(int dd=0; dd<4; dd++){
                int nrB = blueR + dr[dd];
                int ncB = blueC + dc[dd];
                if(isOut(nrB, ncB) || maze[nrB][ncB] == 5 || (nrB == redR && ncB == redC) || vBlue[nrB][ncB]){ continue; }

                for(int d=0; d<4; d++){
                    int nrR = redR + dr[d];
                    int ncR = redC + dc[d];
                    if(isOut(nrR, ncR) || maze[nrR][ncR] == 5 || (nrR == nrB && ncR == ncB) || vRed[nrR][ncR]){ continue; }

                    boolean nextRed = nrR == endR[0] && ncR == endR[1];
                    boolean nextBlue = nrB == endB[0] && ncB == endB[1];
                    vRed[nrR][ncR] = true;
                    vBlue[nrB][ncB] = true;
                    travel(maze, step+1, nextRed, nextBlue, nrR, ncR, nrB, ncB);
                    vRed[nrR][ncR] = false;
                    vBlue[nrB][ncB] = false;
                }
            }
        }
    }

    private boolean isOut(int r, int c){
        return r<0 || N<=r || c<0 || M<=c;
    }
}