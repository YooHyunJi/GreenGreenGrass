package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class d12_bj_s5_11866_요세푸스문제0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int n=1; n<=N; n++) list.add(n);
        int idx = 0;
        sb.append("<");
        while(!list.isEmpty()){
            idx = (idx+K-1)%list.size();
            sb.append(list.remove(idx));
            if(list.isEmpty()) break;
            sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}