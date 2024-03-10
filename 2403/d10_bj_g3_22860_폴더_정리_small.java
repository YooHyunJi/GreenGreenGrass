package a2403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class d10_bj_g3_22860_폴더_정리_small {
    static class Folder{
        String parent;
        String name;
        ArrayList<String> files;
        HashSet<String> unique;

        public Folder(String parent, String name){
            this.parent = parent;
            this.name = name;
            this.files = new ArrayList<>();
            this.unique = new HashSet<>();
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        ArrayDeque<String[]> files = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Folder[] folders = new Folder[N + 1];
        folders[0] = new Folder(null, "main");
        map.put("main", 0);

        int folderIdx = 1;
        for(int n=0; n<N+M; n++){
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String name = st.nextToken();
            if(st.nextToken().equals("1")){
                folders[folderIdx] = new Folder(parent, name);
                map.put(name, folderIdx++);
                continue;
            }
            files.offerLast(new String[] {parent, name});
        }

        while(!files.isEmpty()){
            String[] file = files.pollFirst();
            String parent = file[0];
            String name = file[1];
            while(parent != null){
                int parentIdx = map.get(parent);
                folders[parentIdx].files.add(name);
                folders[parentIdx].unique.add(name);
                parent = folders[parentIdx].parent;
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine(), "/");
            String target = "";
            while(st.hasMoreTokens()){ target = st.nextToken(); }
            sb.append(folders[map.get(target)].unique.size()).append(" ")
                    .append(folders[map.get(target)].files.size()).append("\n");
        }
        System.out.println(sb);
    }
}
