package a2503;

import java.io.*;
import java.util.*;

public class d23_bj_s5_9733_꿀벌 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        String[] keys = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
        for(String key: keys){
            map.put(key, 0);
        }
        int whole = 0;
        String line = "";
        while((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()){
                whole++;
                String work = st.nextToken();
                if(!map.containsKey(work)){
                    continue;
                }
                map.put(work, map.get(work) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String key: keys){
            sb.append(key).append(" ").append(map.get(key)).append(" ").append(String.format("%.2f", (double)map.get(key)/whole)).append("\n");
        }
        sb.append("Total ").append(whole).append(" 1.00");
        System.out.println(sb);
    }
}
