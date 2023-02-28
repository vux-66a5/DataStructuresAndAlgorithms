package Hw1.bai7;

public class WordCount {

    private Node<String> topNode;
    private int numWords;

    public WordCount() {
        topNode = null;
        numWords = 0;
    }
    public void input() {
        String str = "lua nep la lua nep lang, lua len lop lop long nang lang lang";
        String[] splittedWords = str.split("\\W+");
        for (int i = 0; i < splittedWords.length; i++) {
            insertToLinkedList(splittedWords[i]);
        }
    }

    public void insertToLinkedList(String word) {
        if (topNode == null) {
            Node<String> newNode = new Node<>(word, null);
            topNode = newNode;
            numWords++;
        } else {
            for (Node<String> current = topNode; current != null; current = current.getNext()) {
                String data = current.getWord();
                if (word.equals(data)) {
                    current.increaseCount();
                    break;
                } else if (current.getNext() == null) {
                    Node<String> newNode = new Node<String>(word, null);
                    current.setNext(newNode);
                    numWords++;
                    break;
                }
            }
        }
    }
    public void print() {
        System.out.println("Unique words: " + numWords);
        System.out.printf("%5s %s %s %n", "word", "|||", "count");
        for (Node<String> cursor = topNode; cursor != null; cursor = cursor.getNext()) {
            System.out.printf("%5s %2s %3s %n", cursor.getWord(), ":", cursor.getCount());
        }
    }

    public static void main(String[] args) {
        WordCount wc = new WordCount();
        wc.input();
        wc.print();
    }
}