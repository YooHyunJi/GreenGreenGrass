package a2507;

import java.io.*;
import java.util.*;

public class d29_bj_b2_2484_주사위_네개 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int n=0; n<N; n++){
            int score = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<4; i++){
                int num = Integer.parseInt(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            switch (map.keySet().size()){
                case 1:
                    for(int key: map.keySet()){
                        score = 50_000 + key * 5_000;
                    }
                    break;
                case 2:
                    boolean isTriple = false;
                    int triple_key = 0;
                    for(int key: map.keySet()){
                        if(map.get(key) == 3){
                            isTriple =  true;
                            triple_key = key;
                        }
                    }
                    if(isTriple){
                        score = 10_000 + triple_key * 1_000;
                    }
                    else{
                        score = 2_000;
                        for(int key: map.keySet()){
                            score += key * 500;
                        }
                    }
                    break;
                case 3:
                    int double_key = 0;
                    for(int key: map.keySet()){
                        if(map.get(key) == 2){
                            double_key = key;
                            break;
                        }
                    }
                    score = 1_000 + double_key * 100;
                    break;
                case 4:
                    int max_key = 0;
                    for(int key: map.keySet()){
                        max_key = Math.max(max_key, key);
                    }
                    score = max_key * 100;
                    break;
            }
            answer = Math.max(answer, score);
        }
        System.out.println(answer);
    }
}
