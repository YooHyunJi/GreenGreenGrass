package a2407;

import java.util.ArrayDeque;

class d19_pr_3_258707_n_1_카드게임 {
    static int N;

    public int solution(int coin, int[] cards) {
        N = cards.length;
        int answer = 1;
        ArrayDeque<Integer> hand = new ArrayDeque<>();
        ArrayDeque<Integer> card = new ArrayDeque<>();

        for (int n = 0; n < N / 3; n++) {
            hand.add(cards[n]);
        }

        for (int i = N / 3; i < N; i += 2) {
            card.add(cards[i]);
            card.add(cards[i + 1]);

            if (havePair(hand, hand)) {
            } else if (0 < coin && havePair(hand, card)) {
                coin -= 1;
            } else if (1 < coin && havePair(card, card)) {
                coin -= 2;
            } else {
                break;
            }
            answer++;
        }
        return answer;
    }

    static boolean havePair(ArrayDeque<Integer> A, ArrayDeque<Integer> B) {
        for (int num : A) {
            int other = N + 1 - num;
            if (B.contains(other)) {
                A.remove(num);
                B.remove(other);
                return true;
            }
        }
        return false;
    }
}