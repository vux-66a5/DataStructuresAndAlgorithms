package Hw1.bai7;
public class Node<T> {
   private T word;
   private int count;
   private Node<T> next;
   public Node(T word, Node<T> link) {
      this.word = word;
      this.next = link;
      count = 1;
   }
   public T getWord( ) {
      return word;
   }
   public void setWord(T newData){
      word = newData;
   }
   public Node<T> getNext( ) {
      return next;
   }
   public void setNext(Node<T> newLink) {
      next = newLink;
   }
   public void increaseCount() {
	   count++;
   }
   public int getCount() {
	   return count;
   }
}
    