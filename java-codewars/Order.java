import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Order {

    
        public static String order(String words) {
             String[] arr = words.split(" ");
             if(arr.length > 9){
                 return "The string can't have more than 9 words"; 
             }
             StringBuilder result = new StringBuilder("");
             for (int i = 0; i < arr.length; i++) {
                 for (String s : arr) {
                     if (s.contains(String.valueOf(i))) {
                         result.append(s + " ");
                     }
                 }
             }
             return result.toString().trim();
         }

        //examples to follow 

        //example 1 

        public static String order2(String words) {
            return Arrays.stream(words.split(" "))
                         .sorted((a, b) -> {
                            return a.replaceAll("\\D+", "").compareTo(b.replaceAll("\\D+", ""));
                         }).collect(Collectors.joining(" "));
          }

        // example 2 

        public static String order3(String words) {
            return Arrays.stream(words.split(" "))
              .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
              .reduce((a, b) -> a + " " + b).get();
          }
     


    
}
