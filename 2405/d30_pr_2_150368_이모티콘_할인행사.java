package a2405;

public class d30_pr_2_150368_이모티콘_할인행사 {
    static int lenUser, lenEmoticons, answerUser = 0, answerPrice = 0;
    static int[] perm, percentages = { 10, 20, 30, 40 };

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        lenUser = users.length;
        lenEmoticons = emoticons.length;
        perm = new int[lenEmoticons];
        makePerm(users, emoticons, 0);
        answer = new int[] {answerUser, answerPrice};

        return answer;
    }

    static void makePerm(int[][] users, int[] emoticons, int cnt){
        if(cnt == lenEmoticons){
            int totalUser = 0;
            int totalPrice = 0;
            int personalTotalPrice = 0;
            for(int[] user: users){
                boolean isPlus = false;
                personalTotalPrice = 0;
                for(int i=0; i<lenEmoticons; i++){
                    int percentage = perm[i];
                    if(user[0] <= percentage){
                        personalTotalPrice += ((emoticons[i] * (100-percentage))/100);
                        if(user[1] <= personalTotalPrice){
                            isPlus = true;
                            totalUser++;
                            break;
                        }
                    }
                }
                if(!isPlus){
                    totalPrice += personalTotalPrice;
                }
                if(answerUser < totalUser){
                    answerUser = totalUser;
                    answerPrice = totalPrice;
                }
                else if(answerUser == totalUser){
                    answerPrice = Math.max(answerPrice, totalPrice);
                }
            }
            return;
        }
        for(int i=0; i<4; i++){
            perm[cnt] = percentages[i];
            makePerm(users, emoticons, cnt+1);
        }
    }
}
