package community.ilovejava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Never {

    static final Predicate<String> test = s->s.length()>5;
    
    static class Ever{
        
        static List<String> fruits = Arrays.asList("Apple","Banana","Pear", "Orange", "Cucumber", "Tomato", "Tomato");
        static long longFruit =fruits.parallelStream().filter(test).distinct().count();
    }
    public static void main(String[] args) {
        System.out.println(Ever.fruits);
        System.out.println(Ever.longFruit);
        System.out.println(Ever.fruits.parallelStream().filter(test).distinct().collect(Collectors.toList()));
    }

}
