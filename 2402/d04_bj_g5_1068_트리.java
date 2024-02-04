package a2402;

import  java.io.*;
import java.util.*;

public class d04_bj_g5_1068_트리 {
    static class Node{
        int parent;
        int num;
        ArrayList<Integer> children;

        public Node(int parent, int num, ArrayList<Integer> children){
            this.parent = parent;
            this.num = num;
            this.children = children;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] tree = new Node[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            tree[n] = new Node(Integer.parseInt(st.nextToken()), n, new ArrayList<>());
        }
        for(int n=0; n<N; n++){
            if(tree[n].parent==-1){ continue; }
            tree[tree[n].parent].children.add(tree[n].num);
        }
        int D = Integer.parseInt(br.readLine());
        if(tree[D].parent!=-1){ tree[tree[D].parent].children.remove(Integer.valueOf(D));}
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(D);
        while(!queue.isEmpty()){
            int num = queue.pollFirst();
            for(int child: tree[num].children){ queue.offerLast(child); }
            tree[num].children.clear();
            tree[num].children.add(-10);
        }
        int answer = 0;
        for(int n=0; n<N; n++){ if(tree[n].children.isEmpty()){ answer++; } }
        System.out.println(answer);
    }
}