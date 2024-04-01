package a2404;

import java.io.*;
import java.util.*;

public class d01_bj_s4_1764_듣보잡 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Boolean> map = new HashMap<>();
        for(int n=0; n<N; n++){
            map.put(br.readLine(), false);
        }
        List<String> list = new ArrayList<>();
        for(int m=0; m<M; m++){
            String line = br.readLine();
            map.put(line, !map.getOrDefault(line, true));
            if(map.get(line)){ list.add(line); }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
