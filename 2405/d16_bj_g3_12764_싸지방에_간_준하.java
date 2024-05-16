package a2405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d16_bj_g3_12764_싸지방에_간_준하 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[0]-o2[0]);
        ArrayList<int[]> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {start, end});
        }
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int start = now[0];
            int end = now[1];
            boolean isReplaceable = false;
            for(int i=0; i<list.size(); i++){
                if(list.get(i)[0] <= start){
                    list.get(i)[0] = end;
                    list.get(i)[1]++;
                    isReplaceable = true;
                    break;
                }
            }
            if(!isReplaceable){
                list.add(new int[] {end, 1});
                answer++;
            }
        }
        sb.append(answer).append("\n");
        for(int[] seat: list){
            sb.append(seat[1]).append(" ");
        }
        System.out.println(sb);
    }
}