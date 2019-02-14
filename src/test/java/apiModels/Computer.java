package apiModels;

import lombok.Data;
import org.junit.Test;

import java.util.*;

@Data
public class Computer {

    String model;
    int year;

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("James");
        names.add("John");
        names.add("Emily");
        names.add("Josh");

        System.out.println(names);
        System.out.println(names.get(3));

        Queue<String> candidates = new PriorityQueue<>();
        candidates.add("Person 1");
        candidates.add("Person 2");
        candidates.add("Person 3");
        candidates.add("Person 4");
        System.out.println(candidates);
        // peek
        System.out.println(candidates.peek());
        candidates.size();

        List<String> students = new LinkedList<>();
        students.add("Student1");
        students.add("Student2");
        students.add("Student3");
        System.out.println(students);

        Set<String> handles = new TreeSet<>();
        handles.add("34ydndn");
        handles.add("dhsjh3h");
        handles.add("kh89hdjs");
        handles.add("aab89hdjs");
        List<String> listHandles = new ArrayList<>(handles);
        System.out.println(listHandles);

        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            if(iterator.next().equals("34ydndn")){
                iterator.remove();
            }
        }
        System.out.println(handles);
    }

    @Test
    public void mapping(){
        Map<String,String> configs = new HashMap<>();
        configs.put("url", "google.com");
        configs.put("username", "jbond");
        configs.put("password", "jb123");
        configs.put("abc", "some vlaue");
        System.out.println(configs);
        System.out.println(configs.get("password"));
        Set<String> keys = configs.keySet();
        for(String key: keys){
            System.out.println(configs.get(key));
        }

    }



}












