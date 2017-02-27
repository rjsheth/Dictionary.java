//Ruchi Sheth
//rjsheth
//pa3
//Dictionary.java
//the implementation file for DictionaryInterface.java

public class Dictionary implements DictionaryInterface {

// private inner Node class
   private class Node {
      String key;
      String value;
      Node next;

      Node(String k, String v){
         key = k;
         value = v;
         next = null;
      }
   }

   // Fields for the IntegerList class
   private Node head;     // reference to first Node in List
   private int numberOfPairs;  // number of pairs in this Dictionary

   // find()
   // returns a reference to the Node at position index in this IntegerList
   private Node findKey(String key){
      Node N = head;
      while(N != null) {
        if (N.key.equals(key)) {
            return N;
        } else {
            N = N.next;
        }
      }
      return null;
   }

   // IntegerList()
   // constructor for the IntegerList class
   public Dictionary(){
      head = null;
      numberOfPairs = 0;
   }

   // Implementation of ADT operations //////////////////////////////////////

   // isEmpty()
   // pre: none
   // post: returns true if this IntgerList is empty, false otherwise
   public boolean isEmpty(){
      return(numberOfPairs == 0);
   }

   // size()
   // pre: none
   // post: returns the number of elements in this IntegerList
   public int size() {
      return numberOfPairs;
   }

   // lookup()
   // pre: 1 <= index <= size()
   // post: returns item at position index in this IntegerList
   public String lookup(String key) {
      if(findKey(key) == null) {
         return null;
      } else {
         Node N = findKey(key);
         return N.value;
      }
   }

   // insert()
   // inserts newItem into this IntegerList at position index
   // pre: 1 <= index <= size()+1
   // post: !isEmpty(), items to the right of newItem are renumbered
   public void insert(String key, String value) throws DuplicateKeyException{
      Node N = findKey(key);
      if( N != null ){
         throw new DuplicateKeyException(
            "cannot insert duplicate keys");
      }
 
      Node P = new Node(key,value);
      if (head==null){
         head = P;
         numberOfPairs++;
      } else {
         Node A = head;
         while(A.next!=null){
           A = A.next;
         }
         A.next = P;
         numberOfPairs++;
      }
   }

   // delete()
   // deletes item at position index from this IntegerList
   // pre: 1 <= index <= size()
   // post: items to the right of deleted item are renumbered
   public void delete(String key) throws KeyNotFoundException {
      Node N = findKey(key);
      if( N==null ) {
         throw new KeyNotFoundException(
            "cannot delete non-existent key");
      }
      Node P = head;
    
      if(size() == 1){
        head = head.next;
        P = head;
      } else if (head.key.equals(key)){
        head = null;
        head = P.next;
      } else {
        while(!(P.next.key.equals(key))){
           P = P.next;
        }
      P.next = P.next.next;
      } 
      numberOfPairs--;
   }

   // removeAll()
   // pre: none
   // post: isEmpty()
   public void makeEmpty(){
      head = null;
      numberOfPairs = 0;
   }

   // toString
   // pre: none
   // post:  prints current state to stdout
   // Overrides Object's toString() method
   public String toString(){
      StringBuffer sb = new StringBuffer();
      Node N = head;      

      for( ; N!=null; N=N.next){
         sb.append(N.key).append(" ");
         sb.append(N.value).append("\n");
      }
      return new String(sb);
   }
}
