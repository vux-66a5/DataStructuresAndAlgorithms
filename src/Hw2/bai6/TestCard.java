package Hw2.bai6;

import java.util.Arrays;

public class TestCard {
    static <T extends Card> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int bigindex = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[bigindex]) > 0) {
                    bigindex = j;
                }
            }
            T temp = arr[bigindex];
            arr[bigindex] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;// Put it into place
        }
    }

    public static void main(String[] args) {
        Card[] myDeck = new Card[52];
        int[] suit = {Card.DIAMONDS, Card.HEARTS, Card.SPADES, Card.CLUBS};
        int idx = 0;
        for (int i = 0; i < suit.length; i++) {
            for (int j = 2; j <= 14; j++) {
                myDeck[idx] = new Card(j, suit[i]);
                idx++;
            }
        }

//        Arrays.sort(myDeck, new CompareCard());
        selectionSort(myDeck);

        for (int i = 0; i < myDeck.length; i++) {
            System.out.println(myDeck[i]);
        }

    }
}
