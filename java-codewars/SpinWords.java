import java.util.stream.*;
import java.util.Arrays;

public class SpinWords {

    // my code 

    public String spinWords(String sentence) {
        //TODO: Code stuff here
        String[] tempArr = sentence.split(" "); 
        String result = "";
        for(String e : tempArr){
          if(e.length() < 5){
            result += e;
            result += " ";
            
          }
          else{
            String temp = "";
            for(int i = e.length()-1; i >= 0; i--){
              temp += e.charAt(i);
            }
            result += temp; 
            result += " ";
          }
        }
        return result.trim(); 
      }



    //Example 1

        public String spinWords2(String sentence) {
          String[] words = sentence.split(" ");
          for (int i=0; i<words.length; i++) {
            if (words[i].length() >= 5) {
              words[i] = new StringBuilder(words[i]).reverse().toString();
            }
          }
          return String.join(" ",words);
        }

    // Example 2
    public String spinWords3(String sentence) {
        return Arrays.stream(sentence.split(" "))
                     .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                     .collect(Collectors.joining(" "));
    }
    
    //Example 3 
    public String spinWords4(String sentence) {
    
        
        for (String a : sentence.split(" "))
        {
            if (a.length()> 4)
            {
               sentence = sentence.replace(a, new  StringBuffer(a).reverse());
            }
           
            
        }
        return sentence;
     
   }

   //Example 4 
   public static final String WORD_DELIMITER = " ";
   public String spinWords5(String sentence) {
    return Arrays.stream(sentence.split(WORD_DELIMITER, -1)).map(SpinWords::spinIfNecessary).collect(Collectors.joining(WORD_DELIMITER));
  }

  private static String spinIfNecessary(String word) {
    return spinnable(word) ? spin(word) : word;
  }

  private static boolean spinnable(String word) {
    return word.length() >= 5;
  }

  private static String spin(String word) {
    return new StringBuilder(word).reverse().toString();
  }




    
}
