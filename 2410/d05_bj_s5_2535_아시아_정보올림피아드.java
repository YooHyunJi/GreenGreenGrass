package a2410;

import java.io.*;
import java.util.*;

public class d05_bj_s5_2535_아시아_정보올림피아드 {

    static class Person implements Comparable<Person>{
        int country;
        int id;
        int score;

        public Person(int country, int id, int score){
            this.country = country;
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Person o){
            return o.score - score;
        }
    }

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Person> pq = new PriorityQueue<>();
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            Person newPerson = new Person(country, id, score);
            pq.offer(newPerson);
            if(!map.containsKey(country)){
                map.put(country, 0);
            }
        }
        int cnt = 0;
        while(!pq.isEmpty() && cnt < 3){
            Person now = pq.poll();
            if(2 <= map.get(now.country)){
                continue;
            }
            sb.append(now.country).append(" ").append(now.id).append("\n");
            map.replace(now.country, map.get(now.country) + 1);
            cnt++;
        }
        System.out.println(sb);
    }
}
