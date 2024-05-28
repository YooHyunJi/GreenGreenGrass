package a2405;

import java.io.*;
import java.util.*;

public class d28_s4_1620_나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> nameByIdx = new HashMap<>();
        HashMap<String, Integer> idxByName = new HashMap<>();
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            nameByIdx.put(i, name);
            idxByName.put(name, i);
        }
        for(int i=1; i<=M; i++){
            String keyword = br.readLine();
            if(0<=keyword.toCharArray()[0]-'0' && keyword.toCharArray()[0]-'0'<=9){
                sb.append(nameByIdx.get(Integer.parseInt(keyword))).append("\n");
            }
            else{
                sb.append(idxByName.get(keyword)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
