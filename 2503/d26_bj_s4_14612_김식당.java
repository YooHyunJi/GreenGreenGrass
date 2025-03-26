package a2503;

import java.io.*;
import java.util.*;

public class d26_bj_s4_14612_김식당 {

    static class Order implements Comparable<Order>{
        int table;
        int time;

        public Order(int table, int time){
            this.table = table;
            this.time = time;
        }

        @Override
        public int compareTo(Order o){
            if(time == o.time){
                return table - o.table;
            }
            return time - o.time;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Order> orders = new ArrayList<>();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String ask = st.nextToken();
            if(ask.equals("sort")){
                if(orders.isEmpty()){
                    sb.append("sleep\n");
                }
                else{
                    Collections.sort(orders);
                    for(Order order: orders){
                        sb.append(order.table).append(" ");
                    }
                    sb.append("\n");
                }
            }
            else if(ask.equals("order")){
                int table = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                Order newOrder = new Order(table, time);
                orders.add(newOrder);
                for(Order order: orders){
                    sb.append(order.table).append(" ");
                }
                sb.append("\n");
            }
            else{
                int table = Integer.parseInt(st.nextToken());
                int size = orders.size();
                for(int i=0; i<size; i++){
                    if(orders.get(i).table == table){
                        orders.remove(i);
                        break;
                    }
                }
                if(orders.isEmpty()){
                    sb.append("sleep\n");
                }
                else{
                    for(Order order: orders){
                        sb.append(order.table).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
