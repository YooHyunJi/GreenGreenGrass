package a2408;

import java.io.*;
import java.util.*;

public class d05_bj_s3_20920_영단어_암기는_괴로워 {
    static class Word implements Comparable<Word>{
        String word;
        int len;
        int cnt;

        public Word(String word, int len, int cnt){
            this.word = word;
            this.len = len;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o){
            if(o.cnt < this.cnt){ return -1; }
            if(o.cnt > this.cnt){ return 1; }
            if(o.len < this.len){ return -1; }
            if(o.len > this.len){ return 1; }
            return this.word.compareTo(o.word);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, int[]> map = new HashMap<>();
        for(int n=0; n<N; n++){
            String word = br.readLine();
            int wordLen = word.length();
            if(wordLen < M){ continue; }
            if(!map.containsKey(word)){
                map.put(word, new int[] {wordLen, 0});
            }
            map.get(word)[1]++;
        }
        PriorityQueue<Word> pq = new PriorityQueue<>();
        for(String key: map.keySet()){
            pq.offer(new Word(key, map.get(key)[0], map.get(key)[1]));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll().word).append("\n");
        }
        System.out.println(sb);
    }
}
