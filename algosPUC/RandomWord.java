import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args){
        Double count = 0.0;
        String printWord = "";
        while (!(StdIn.isEmpty())) {
          count++; 
          Double prob = 1.0/count;
          String tmp = StdIn.readString();
          if (StdRandom.bernoulli(prob))
                printWord = tmp;
        }
        StdOut.println(printWord);
    }
}
