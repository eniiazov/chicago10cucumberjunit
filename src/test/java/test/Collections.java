package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collections {

    public static void main(String[] args){
        // List -> interface
        List<Map<String, Object>> list = new ArrayList();

        // ArrayList
        // LinkedList

        // Map -> interface
        // Map<K, V>
        Map<String, Object> map = new HashMap();
        map.put("student_id", 27);
        map.put("first_name", "John");
        //map.put("last_name", "Wick");

//        for(String key: map.keySet()){
//            System.out.println(key +" -> "+ map.get(key));
//        }
        Map<String, Object> map1 = new HashMap();
        map1.put("student_id", 28);
        map1.put("first_name", "Kim");

        Map<String, Object> map2 = new HashMap();
        map2.put("student_id", 29);
        map2.put("first_name", "Lee");

        list.add(map);
        list.add(map1);
        list.add(map2);
        //System.out.println("Student_id  and");
        for(Map<String, Object> printMap: list){
            System.out.println(printMap.get("student_id")+ " and "+ printMap.get("first_name"));
        }


        /*
        *
        * | student_id | first_name | last_name |
        * | 27         | John       | Wick      |
        * | 28         | Kim        |
        * | 29         | Lee        |
        *
        *
        * */





        // student_id = 27
        // HashMap
        //TreeMap

    }

}
