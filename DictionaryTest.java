//Ruchi Sheth
//rjsheth
//pa3
//DictionaryTest.java
//a test file that checks the dictionary client file

public class DictionaryTest{

   public static void main(String[] args){
      Dictionary A = new Dictionary();
      String v;

     // A.delete("1"); causes key not found exception

      A.insert("1","R");
      A.insert("2","U");
      A.insert("3","C");
      A.insert("4","H");
      A.insert("5","I");
      A.insert("6"," ");
      A.insert("7","C");
      A.insert("8","H");
      A.insert("9","E");
      A.insert("10","S");
      A.insert("11","S");

      System.out.println(A);

      v = A.lookup("1");
      System.out.println("key=1 "+(v==null?"not found":("value="+v)));
      v = A.lookup("6");
      System.out.println("key=3 "+(v==null?"not found":("value="+v)));
      v = A.lookup("9");
      System.out.println("key=9 "+(v==null?"not found":("value="+v)));
      v = A.lookup("10");
      System.out.println("key=10 "+(v==null?"not found":("value="+v)));
      System.out.println();

      A.insert("2","f");  // causes DuplicateKeyException

      A.delete("1");
      A.delete("3");
      A.delete("7");
      System.out.println(A);

      A.delete("12");  // causes KeyNotFoundException

      System.out.println(A.isEmpty());
      System.out.println(A.size());
      A.makeEmpty();
      System.out.println(A.isEmpty());
      System.out.println(A);

   }
}
