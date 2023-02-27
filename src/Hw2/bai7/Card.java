package Hw2.bai7;

public class Card implements Comparable<Card> {
    public static final int SPADES = 0;
    public static final int CLUBS = 1;
    public static final int DIAMONDS = 2;
    public static final int HEARTS = 3;
    private int rank;
    private int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    @Override
    public int compareTo(Card another) {
        if (this.suit == another.suit) {
            if (this.rank == another.rank) {
                return 0;
            } else if (this.rank > another.rank) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.suit > another.suit) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {

        String rank = "" + this.rank;
        String suit = "";

        if (this.rank > 10) {
            if (this.rank == 11) {
                rank = "J";
            }
            if (this.rank == 12) {
                rank = "Q";
            }
            if (this.rank == 13) {
                rank = "K";
            }
            if (this.rank == 14) {
                rank = "A";
            }
        }

        if (this.suit == 0) {
            suit = "Spades";
        }

        if (this.suit == 1) {
            suit = "Clubs";
        }

        if (this.suit == 2) {
            suit = "Diamonds";
        }

        if (this.suit == 3) {
            suit = "Hearts";
        }

        return rank + " of " + suit;

    }
}
