package etc;

import java.io.*;;
import java.util.*;

public class d14_bj_s4_10816_숫자카드2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            String key = st.nextToken();
            if(map.containsKey(key)) map.replace(key, map.get(key)+1);
            else map.put(key, 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            String key = st.nextToken();
            if(map.containsKey(key)) sb.append(map.get(key)).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}