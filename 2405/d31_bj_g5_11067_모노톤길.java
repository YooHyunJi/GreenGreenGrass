package a2405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class d31_bj_g5_11067_모노톤길 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            SortedMap<Integer, ArrayList<Integer>> cafes = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());
            int[][] result = new int[N][2];
            for(int n=0; n<N; n++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(!cafes.containsKey(x)){
                    cafes.put(x, new ArrayList<>());
                }
                cafes.get(x).add(y);
            }
            int idx = 0;
            int finalY = 0;
            for(int x: cafes.keySet()){
                cafes.get(x).sort((o1, o2)->o1-o2);
                int size = cafes.get(x).size();
                if(cafes.get(x).get(0) == finalY){
                    for(int i=0; i<size; i++){
                        result[idx++] = new int[] {x, cafes.get(x).get(i)};
                    }
                }
                else{
                    for(int i=size-1; i>=0; i--){
                        result[idx++] = new int[] {x, cafes.get(x).get(i)};
                    }
                }
                finalY = result[idx-1][1];
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for(int i=0; i<M; i++){
                int num = Integer.parseInt(st.nextToken()) - 1;
                sb.append(result[num][0]).append(" ").append(result[num][1]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
