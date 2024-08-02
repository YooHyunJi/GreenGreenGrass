package a2408;

import java.util.PriorityQueue;

public class d02_pr_2_86052_빛의_경로_사이클 {
    static class Node{
        char direction;
        boolean[] visit;

        public Node(char direction){
            this.direction = direction;
            this.visit = new boolean[4];
        }
    }

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Node[][] map;
    static int R, C;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        R = grid.length;
        C = grid[0].length();
        map = new Node[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                map[r][c] = new Node(grid[r].charAt(c));
            }
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                for(int d=0; d<4; d++){
                    if(map[r][c].visit[d]){ continue; }
                    travel(r, c, d);
                }
            }
        }

        int S = pq.size();
        int[] answer = new int[S];
        for(int s=0; s<S; s++){
            answer[s] = pq.poll();
        }
        return answer;
    }

    static void travel(int rr, int cc, int D){
        int length = 0, r = rr, c = cc, d = D;
        while(!map[r][c].visit[d]){
            map[r][c].visit[d] = true;
            length++;
            switch(map[r][c].direction){
                case 'L':
                    d = (4 + d - 1) % 4;
                    break;
                case 'R':
                    d = (4 + d + 1) % 4;
                    break;
            }
            r = (R + r + dr[d]) % R;
            c = (C + c + dc[d]) % C;
        }
        pq.offer(length);
    }
}
