package Hw2.bai6;

import java.util.Arrays;
import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
//        return card1.compareTo(card2);
        if (card1.getSuit() == card2.getSuit()) {
            if (card1.getRank() == card2.getRank()) {
                return 0;
            } else if (card1.getRank() > card2.getRank()) {
                return 1;
            } else {
                return -1;
            }
        } else if (card1.getSuit() > card2.getSuit()) {
            return 1;
        } else {
            return -1;
        }
    }

}
