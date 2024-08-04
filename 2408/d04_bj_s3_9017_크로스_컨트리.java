package a2408;

import java.io.*;
import java.util.*;

public class d04_bj_s3_9017_크로스_컨트리 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> count = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> teams = new HashMap<>();
            int[] rank = new int[N];
            int score = 1;
            for(int n=0; n<N; n++) {
                rank[n] = Integer.parseInt(st.nextToken());
                count.put(rank[n], count.getOrDefault(rank[n], 0)+1);
            }
            for(int n=0; n<N; n++){
                int team = rank[n];
                if(count.get(team) < 6){ continue; }
                if(!teams.containsKey(team)){
                    teams.put(team, new ArrayList<>());
                    teams.get(team).add(0);
                }
                teams.get(team).add(score);
                if(teams.get(team).size() < 6){
                    teams.get(team).set(0, teams.get(team).get(0) + score);
                }
                score++;
            }
            int firstTeam = 0;
            int bestScore = Integer.MAX_VALUE;
            int fifthScore = Integer.MAX_VALUE;
            for(int team: teams.keySet()){
                System.out.println(team+" | "+teams.get(team));
                if(teams.get(team).get(0) < bestScore){
                    bestScore = teams.get(team).get(0);
                    fifthScore = teams.get(team).get(5);
                    firstTeam = team;
                }
                else if(teams.get(team).get(0) == bestScore){
                    if(teams.get(team).get(5) <= fifthScore){
                        fifthScore = teams.get(team).get(5);
                        firstTeam = team;
                    }
                }
            }
            System.out.println();
            sb.append(firstTeam).append("\n");
        }
        System.out.println(sb);
    }
}
