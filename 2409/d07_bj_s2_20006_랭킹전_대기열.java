package a2409;

import java.io.*;
import java.util.*;

public class d07_bj_s2_20006_랭킹전_대기열 {

    static class Room{
        int min;
        int max;
        List<User> users;

        public Room(int min, int max) {
            this.min = min;
            this.max = max;
            this.users = new ArrayList<>();
        }
    }

    static class User implements Comparable<User>{
        int L;
        String N;

        public User(int l, String n) {
            L = l;
            N = n;
        }

        @Override
        public int compareTo(User o){
            return N.compareTo(o.N);
        }
    }

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Room> rooms = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        String N = st.nextToken();
        rooms.add(new Room(L - 10, L + 10));
        rooms.get(0).users.add(new User(L, N));

        for(int p=1; p<P; p++){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            N = st.nextToken();
            boolean isPossible = false;
            for(Room room: rooms){
                if(room.users.size() == M || L < room.min || room.max < L){
                    continue;
                }
                room.users.add(new User(L, N));
                isPossible = true;
                break;
            }
            if(!isPossible){
                rooms.add(new Room(L - 10, L + 10));
                int S = rooms.size();
                rooms.get(S - 1).users.add(new User(L, N));
            }
        }
        for(Room room: rooms){
            if(room.users.size() == M){
                sb.append("Started!\n");
            }
            else{
                sb.append("Waiting!\n");
            }
            Collections.sort(room.users);
            for(User user: room.users){
                sb.append(user.L).append(" ").append(user.N).append("\n");
            }
        }
        System.out.println(sb);
    }
}
