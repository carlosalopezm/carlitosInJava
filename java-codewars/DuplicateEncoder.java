import java.util.stream.*; 
public class DuplicateEncoder {
// my answer 
    static String encode(String word){
        String test = word.toLowerCase(); 
        String once = ""; 
        String twicePlus = ""; 
        String ans = "";
        for(int i = 0; i < test.length(); i++){
          String x = test.substring(i, i+1); 
          if(test.indexOf(x) != test.lastIndexOf(x) && twicePlus.contains(x) != true) 
            twicePlus += x;
          if(test.indexOf(x) == test.lastIndexOf(x))
             once+=x; 
        }
        for(int i = 0; i < test.length(); i++){
          String x = test.substring(i, i+1); 
          if(twicePlus.contains(x) == true)
            ans+=")"; 
          if(once.contains(x) == true)
             ans+="(";
        }
        return ans; 
    }    

    //Examples of other code 
//ex1 
    static String encode1(String word){
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
          char c = word.charAt(i);
          result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
      }
//ex2 

static String encode2(String word){    
    return word.toLowerCase()
               .chars()
               .mapToObj(i -> String.valueOf((char)i))
               .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
               .collect(Collectors.joining());
}
    
}
