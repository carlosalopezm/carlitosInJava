import java.util.stream.IntStream;

public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) {
        if(numbers.length != 10){return "It has to be a ten digit number";}
        String result = "(";
        for(int i = 0; i < numbers.length; i++){
          if(i < 2)
            result += numbers[i]; 
          if(i == 2)
            result = result + numbers[i] + ") ";
          if(i < 5 && i > 2)
            result += numbers[i]; 
          if(i == 5)
            result = result + numbers[i] + "-"; 
          if(i > 5)
            result += numbers[i]; 
            
         }
        return result;
      }

      //examples to look at 

      //ex1 
      public static String createPhoneNumber1(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",numbers[0],numbers[1],numbers[2],
        numbers[3],numbers[4],numbers[5],numbers[6],numbers[7],numbers[8],numbers[9]);
      }


      //ex2 

      public static String createPhoneNumber2(int[] numbers) {
        String phoneNumber = new String("(xxx) xxx-xxxx");
        
        for (int i : numbers) {
          phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }
        
        return phoneNumber;
      }
// best 


      //ex3 

      public static String createPhoneNumber3(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
      }




    
}
