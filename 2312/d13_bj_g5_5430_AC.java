package etc;

import java.io.*;
import java.util.*;

public class d13_bj_g5_5430_AC {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            char[] func = br.readLine().toCharArray();
            int front = 0;
            int back = Integer.parseInt(br.readLine())-1;
            boolean direction = true;
            String elem = br.readLine();
            StringTokenizer st = new StringTokenizer(elem.substring(1, elem.length()-1), ",");
            int[] arr = new int[back+1];
            for(int i=0; i<=back; i++) arr[i] = Integer.parseInt(st.nextToken());
            sb.append(doFunc(arr, func, front, back, direction)).append("\n");
        }
        System.out.println(sb);
    }
    private static void swap(int a, int b){
        int tmp = a;
        a = b;
        b = tmp;
    }
    private static String doFunc(int[] arr, char[] func, int front, int back, boolean direction){
        for(char f: func){
            switch (f){
                case 'R':
                    swap(front, back);
                    direction = !direction;
                    break;
                case 'D':
                    if(back-front<0) return "error";
                    if(direction) front++;
                    else back--;
                    break;
            }
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        if(direction) for(int i=front; i<=back; i++) result.append(arr[i]).append(",");
        else for(int i=back; i>=front; i--) result.append(arr[i]).append(",");
        if(back-front>=0) result.deleteCharAt(result.length()-1);
        result.append("]");
        return result.toString();
    }
}