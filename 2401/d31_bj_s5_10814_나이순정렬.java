package a2401;

import java.io.*;
import java.util.*;

public class d31_bj_s5_10814_나이순정렬 {
    static class User implements Comparable<User>{
        int no;
        int age;
        String name;

        public User(int no, int age, String name){
            this.no = no;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o){
            if(age < o.age){ return -1; }
            if(age > o.age){ return 1; }
            if(no < o.no){ return -1; }
            else return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<User> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new User(n, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        for(int n=0; n<N; n++) {
            User now = pq.poll();
            sb.append(now.age).append(" ").append(now.name).append("\n");
        }
        System.out.println(sb);
    }
}
