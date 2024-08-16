package a2408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class d16_bj_g4_1327_소트_게임 {
    static class Node{
        String str;
        int depth;

        public Node(String str, int depth){
            this.str = str;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr_origin = br.readLine().replace(" ", "").toCharArray();
        char[] arr_ordered = Arrays.copyOf(arr_origin, N);
        Arrays.sort(arr_ordered);
        String str_origin = new String(arr_origin);
        String str_ordered = new String(arr_ordered);

        ArrayDeque<Node> queue = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        queue.offerLast(new Node(str_origin, 0));
        set.add(str_origin);

        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            String str = now.str;
            int depth = now.depth;

            if(str_ordered.equals(str)){
                System.out.println(depth);
                return;
            }

            for(int i=0; i<=N-K; i++){
                String nStr = reverseStr(str, i, i+K, N);
                if(set.contains(nStr)){ continue; }
                set.add(nStr);
                queue.offerLast(new Node(nStr, depth + 1));
            }
        }
        System.out.println(-1);
    }

    static String reverseStr(String str, int from, int to, int N){
        StringBuilder result = new StringBuilder();
        for(int i=0; i<from; i++){
            result.append(str.charAt(i));
        }
        for(int i=to-1; i>=from; i--){
            result.append(str.charAt(i));
        }
        for(int i=to; i<N; i++){
            result.append(str.charAt(i));
        }
        return result.toString();
    }
}
