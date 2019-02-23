package test;

import java.util.*;

class JavaReview extends JR{

     public static void main(String[] args) {
         Map<Integer, String> chairs = new HashMap<>();
         chairs.put(3, "Blue chair");
         chairs.put(2, "Study room chair");
         chairs.put(45, "Office chair");
         Set<Integer> keys = chairs.keySet();
         for(Integer i: keys){
             System.out.print(i + " ");
             System.out.println(chairs.get(i));

         }
     }

}
