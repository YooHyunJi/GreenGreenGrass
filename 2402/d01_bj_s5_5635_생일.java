package a2402;

import java.io.*;
import java.util.*;

public class d01_bj_s5_5635_생일 {
    static class Student implements Comparable<Student>{
        String name;
        int d;
        int m;
        int y;

        public Student(String name, int d, int m, int y){
            this.name = name;
            this.d = d;
            this.m = m;
            this.y = y;
        }

        public int compareTo(Student o){
            if(y > o.y){ return -1; }
            if(y < o.y){ return 1; }
            if(m > o.m){ return -1; }
            if(m < o.m){ return 1; }
            if(d > o.d){ return -1; }
            else{ return 1; }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Student> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int n=0; n<N; n++){
            if(0<n && n<N-1) {
                pq.poll();
                continue;
            }
            System.out.println(pq.poll().name);
        }
    }
}
