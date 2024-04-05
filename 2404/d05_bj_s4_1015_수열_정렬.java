package a2404;

import java.io.*;
import java.util.*;

public interface d05_bj_s4_1015_수열_정렬 {
    import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//    public class Main
//    {
//        /**
//         * 메인 함수
//         *
//         * @param args: [String[]] 매개변수
//         *
//         * @throws IOException 데이터 입출력 예외
//         */
//        public static void main(String[] args) throws IOException
//        {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//            // 배열의 크기
//            int N = Integer.parseInt(reader.readLine());
//
//            // 원본 배열
//            int[][] A = new int[N][2];
//
//            // 정렬 배열
//            int[] B = new int[N];
//
//            String[] temp = reader.readLine().split(" ");
//
//            StringBuilder builder = new StringBuilder();
//
//            for (int i = 0; i < N; i++)
//            {
//                A[i][0] = Integer.parseInt(temp[i]);
//                A[i][1] = i;
//            }
//
//            // 정렬 수행
//            sort(A);
//
//            for (int i = 0; i < N; i++)
//            {
//                int index = A[i][1];
//
//                B[index] = i;
//            }
//
//            for (int b : B)
//            {
//                builder.append(b).append(" ");
//            }
//
//            System.out.println(builder.toString().trim());
//
//            writer.close();
//            reader.close();
//        }
//
//        /**
//         * 정렬 함수
//         *
//         * @param A: [int[][]] 대상 배열
//         */
//        private static void sort(int[][] A)
//        {
//            Arrays.sort(A, (next, current) ->
//            {
//                // 현재값이 더 클 경우
//                if (next[0] < current[0])
//                {
//                    return -1;
//                }
//
//                // 다음값이 더 클 경우
//                else if (next[0] > current[0])
//                {
//                    return 1;
//                }
//
//                // 현재값과 다음값이 같을 경우, 사전순 정렬
//                else
//                {
//                    return Integer.compare(next[1], current[1]);
//                }
//            });
//        }
//    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = new int[] {Integer.parseInt(st.nextToken()), n};
        }
        Arrays.sort(arr, (o1, o2)->{return o1[0] - o2[0];});
        for(int n=0; n<N; n++){
            System.out.println(Arrays.toString(arr[n]));
        }
        for(int n=0; n<N; n++){ sb.append(arr[n][1]).append(" "); }
        System.out.println(sb);
    }
}
