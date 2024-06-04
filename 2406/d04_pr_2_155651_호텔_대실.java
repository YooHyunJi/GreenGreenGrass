package a2406;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d04_pr_2_155651_호텔_대실 {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<int[][]> pqBook = new PriorityQueue<>(
                (o1, o2)->{
                    if(o1[0][0] == o2[0][0]){ return Integer.compare(o1[0][1], o2[0][1]); }
                    else{ return o1[0][0]-o2[0][0]; }
                }
        );
        PriorityQueue<int[]> pqEnd = new PriorityQueue<>(
                (o1, o2)->{
                    if(o1[0] == o2[0]){ return Integer.compare(o1[1], o2[1]); }
                    else{ return o1[0]-o2[0]; }
                }
        );

        for(String[] book: book_time){
            int[][] bookInt = new int[2][2];
            StringTokenizer st = new StringTokenizer(book[0], ":");
            bookInt[0][0] = Integer.parseInt(st.nextToken());
            bookInt[0][1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(book[1], ":");
            bookInt[1][0] = Integer.parseInt(st.nextToken());
            bookInt[1][1] = Integer.parseInt(st.nextToken())+10;
            if(60 <= bookInt[1][1]){
                bookInt[1][1] -= 60;
                bookInt[1][0] += 1;
            }
            pqBook.offer(bookInt);
        }

        while(!pqBook.isEmpty()){
            int[][] book = pqBook.poll();
            int[] start = book[0];
            int[] end = book[1];

            if(pqEnd.isEmpty() || !canEnter(start, pqEnd.peek())){
                pqEnd.offer(end);
                answer++;
            }
            else{
                pqEnd.poll();
                pqEnd.offer(end);
            }
        }
        return answer;
    }

    static boolean canEnter(int[] start, int[] end){
        if(start[0] == end[0]){
            return end[1] <= start[1];
        }
        return end[0] < start[0];
    }
}