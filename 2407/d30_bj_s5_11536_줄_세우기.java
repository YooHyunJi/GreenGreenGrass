package a2407;

import java.io.*;

public class d30_bj_s5_11536_줄_세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[2];
        arr[0] = br.readLine();
        arr[1] = br.readLine();
        if(arr[0].compareTo(arr[1]) < 0){
            for(int i=0; i<N-2; i++){
                int now = i%2;
                int other = (i+1)%2;
                arr[now] = br.readLine();
                if(arr[other].compareTo(arr[now]) > 0){
                    System.out.println("NEITHER");
                    return;
                }
            }
            System.out.println("INCREASING");
        }
        else{
            for(int i=0; i<N-2; i++){
                int now = i%2;
                int other = (i+1)%2;
                arr[now] = br.readLine();
                if(arr[other].compareTo(arr[now]) < 0){
                    System.out.println("NEITHER");
                    return;
                }
            }
            System.out.println("DECREASING");
        }
    }
}
