package Hw2.bai7;

import Hw2.bai6.Card;

import java.util.*;

public class ShuffleCardTest {
    static <T extends Card> void sortDeck(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int bigIndex = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[bigIndex]) > 0) {
                    bigIndex = j;
                }
            }
            T temp = arr[bigIndex];
            arr[bigIndex] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;// Put it into place
        }
    }

    static <T extends Card> void shuffleDeck(T[] card) {

        Random rand = new Random();

        for (int i = 0; i < card.length; i++) {
            // Random for remaining positions.
            int r = i + rand.nextInt(52 - i);

            //swapping the elements
            T temp = card[r];
            card[r] = card[i];
            card[i] = temp;

        }
    }

    public static int[] randomArray(int N, int M) {
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < N; i++) {
            int num = random.nextInt(M) + 2;
            while (set.contains(num)) {
                num = random.nextInt(M) + 2;
            }
            set.add(num);
            arr[i] = num;
        }
        return arr;
    }

    static void createDeck(Card[] deck, int[] arr) {
        int[] suit = {Card.DIAMONDS, Card.HEARTS, Card.SPADES, Card.CLUBS};
        int idx = 0;
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                deck[idx] = new Card(arr[j], suit[i]);
                idx++;
            }
        }
    }

    static void listDeck(Card[] myDeck) {
        for (int i = 0; i < myDeck.length; i++) {
            System.out.println(myDeck[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = randomArray(13, 13);
        System.out.println("Random array: " + Arrays.toString(arr));

        Card[] myDeck = new Card[52];
        createDeck(myDeck, arr);


        System.out.println("\nOriginal Deck: ");
        listDeck(myDeck);

        System.out.println("\nSorted Deck: ");
        sortDeck(myDeck);
        listDeck(myDeck);

        System.out.println("\nShuffled Deck: ");
        shuffleDeck(myDeck);
        listDeck(myDeck);


    }

}
