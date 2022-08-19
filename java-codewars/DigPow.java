import java.lang.Math.*;
import java.util.stream.IntStream;

public class DigPow {
	// my solution 
	public static long digPow(int n, int p) {
    String x = Integer.toString(n); 
    StringBuilder y = new StringBuilder(x).reverse();
    x = y.toString();
    long result = -1; 
    int temp = Integer.parseInt(x);  
    int test = 0; 
    for(int i = 0; i < x.length(); i++){
      int add = (int)(Math.pow((temp%10), (p+i)));
      test = test + add; 
      temp = temp/10; 
    }
    if(test%n == 0 ){
      result = test/n; 
    } 
    return result;
	}

    // example 1 
    public static long digPow2(int n, int p) {
        String intString = String.valueOf(n);
        long sum = 0;
        for (int i = 0; i < intString.length(); ++i, ++p)
          sum += Math.pow(Character.getNumericValue(intString.charAt(i)), p);
        return (sum % n == 0) ? sum / n : -1;
      }

    //example 2 

    public static long digPow3(int n, int p) {
        int[] digits = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
        int sum = IntStream.range(0, digits.length).map(i -> (int) Math.pow(digits[i], i + p)).sum();
        return sum % n == 0 ? sum / n : -1;
      }
	
}