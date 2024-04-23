package a2404;

import java.io.*;
import java.util.*;

public class d23_bj_s4_26596_황금_칵테일 {
    public static void main(String[] args) throws Exception{
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if(map.containsKey(key)){ map.replace(key, map.get(key), map.get(key) + value); }
            else{ map.put(key, value); }
        }
        Integer[] arr = map.values().toArray(new Integer[0]);
        Arrays.sort(arr);
        int L = arr.length;
        for(int i=0; i<L-1; i++){
            int gold = (int) (arr[i] * 1.618);
            for(int j=i+1; j<L; j++){
                if(gold < arr[j]){ break; }
                if(gold == arr[j]){
                    System.out.println("Delicious!");
                    return;
                }
            }
        }
        System.out.println("Not Delicious...");
    }
}
