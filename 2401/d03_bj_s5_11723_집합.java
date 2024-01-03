package a2401;

import java.io.*;
import java.util.*;

public class d03_bj_s5_11723_집합 {
    static HashSet<Integer> set = new HashSet<>();

    static void add(int x){ set.add(x); }
    static void remove(int x){ set.remove(x); }
    static void check(int x){ System.out.println(set.contains(x)? 1: 0); }
    static void toggle(int x){
        if(set.contains(x)){ remove(x); }
        else { add(x); }
    }
    static void all(){
        empty();
        for(int i=1; i<=20; i++){ set.add(i); }
    }
    static void empty(){ set.clear(); }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        for(int m=0; m<M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "add":
                    add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    check(Integer.parseInt(st.nextToken()));
                    break;
                case "toggle":
                    toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
    }
}
