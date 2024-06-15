package a2406;

import java.io.*;
import java.util.*;

public class d15_bj_s3_2108_통계학 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
            if(!map.containsKey(arr[n])){ map.put(arr[n], 0); }
            map.replace(arr[n], map.get(arr[n])+1);
        }
        Arrays.sort(arr);
        double sum = 0;
        int min = 4001;
        int max = -4001;
        for(int n=0; n<N; n++){
            sum += arr[n];
            min = Math.min(min, arr[n]);
            max = Math.max(max, arr[n]);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int freqNum = list.get(0).getKey();
        if(1<N && Objects.equals(list.get(0).getValue(), list.get(1).getValue())){
            freqNum = list.get(1).getKey();
        }

        System.out.println(Math.round(sum/N));
        System.out.println(arr[N/2]);
        System.out.println(freqNum);
        System.out.println(max-min);
    }
}
