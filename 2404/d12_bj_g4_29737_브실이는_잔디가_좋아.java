package a2404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d12_bj_g4_29737_브실이는_잔디가_좋아 {
    private static class Streak implements Comparable<Streak>{
        String name;
        int length;
        int freeze;
        int start;
        int fail;

        public Streak(String name, int length, int freeze, int start){
            this.name = name;
            this.length = length;
            this.freeze = freeze;
            this.start = start;
            this.fail = -1;
        }

        @Override
        public int compareTo(Streak o){
        if(length > o.length){ return -1; }
        if(length < o.length){ return 1; }
        if(freeze < o.freeze){ return -1; }
        if(freeze > o.freeze){ return 1; }
        if(start < o.start){ return -1; }
        if(start > o.start){ return 1; }
        return Integer.compare(fail, o.fail);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        Streak[] bestArr = new Streak[N];
        for(int n=0; n<N; n++){
            char[][] historyArr = new char[7][W];
            StringBuilder sb = new StringBuilder();
            String history;
            String name = br.readLine();

            for(int d=0; d<7; d++){ historyArr[d] = br.readLine().toCharArray(); }
            for(int w=0; w<W; w++){ for(int d=0; d<7; d++){ sb.append(historyArr[d][w]); } }
            history = sb.toString();

            StringTokenizer withX = new StringTokenizer(history, "X", true);
            StringTokenizer withoutX = new StringTokenizer(history, "X");
            int fail = withX.countTokens() - withoutX.countTokens();

            int nowIdx = 0;
            PriorityQueue<Streak> pq = new PriorityQueue<>();

            while(withX.hasMoreTokens()) {
                String token = withX.nextToken();

                if (token.equals("X")) {
                    nowIdx++;
                    continue;
                }

                int length = token.length();
                int startIdx = 0;
                int endIdx = length;

                for (int i = 0; i < length; i++) {
                    if (token.charAt(i) != 'F') { break; }
                    startIdx++;
                }
                if (startIdx != length) {
                    for (int i = length - 1; i >= 0; i--) {
                        if (token.charAt(i) != 'F') { break; }
                        endIdx--;
                    }
                }
                String trimmedToken = token.substring(startIdx, endIdx);

                int freeze = 0;
                for (int i = 0; i < trimmedToken.length(); i++) {
                    if (trimmedToken.charAt(i) == 'F') { freeze++; }
                }

                pq.offer(new Streak(trimmedToken, endIdx - startIdx - freeze, freeze, nowIdx + startIdx));
                nowIdx += length;
            }
            pq.offer(new Streak(name, 0, 0, 0));
            bestArr[n] = pq.poll();
            bestArr[n].name = name;
            bestArr[n].fail = fail;
        }
        Arrays.sort(bestArr, (o1, o2) -> o1.name.compareTo(o2.name));
        Arrays.sort(bestArr);

        StringBuilder answer = new StringBuilder();
        int rank = 1;
        answer.append(rank).append(". ").append(bestArr[0].name).append("\n");
        for(int n=1; n<N; n++){
            if(bestArr[n-1].compareTo(bestArr[n]) < 0){ rank++; }
            answer.append(rank).append(". ").append(bestArr[n].name).append("\n");
        }
        System.out.println(answer);
    }
}