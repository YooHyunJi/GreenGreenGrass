package a2407;

import java.io.*;
import java.util.*;

public class d25_bj_s3_16165_걸그룹_마스터_준석이 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int n=0; n<N; n++){
            String key = br.readLine();
            int people = Integer.parseInt(br.readLine());
            map.put(key, new ArrayList<>());
            for(int i=0; i<people; i++){
                map.get(key).add(br.readLine());
            }
            Collections.sort(map.get(key));
        }
        for(int m=0; m<M; m++){
            String name = br.readLine();
            int op = Integer.parseInt(br.readLine());
            if(op == 0){
                for(String n: map.get(name)){
                    sb.append(n).append("\n");
                }
            }
            else{
                for(String key: map.keySet()){
                    if(map.get(key).contains(name)){
                        sb.append(key).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
