public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
     //recursive 
        Boolean cond = h > 0 && (bounce > 0 && bounce < 1) && window < h;
        if (cond) {
            return h < window ? -1 : 2 + bouncingBall((h * bounce), bounce, window);
        }
        return -1;
    }
//non-recursive 
    public static int bouncingBall2(double h, double bounce, double window) {
        if ((h <= 0) || (window >= h) || (bounce <= 0) || (bounce >= 1))
          return -1;
        int seen = -1;
        while (h > window) {
              seen += 2;
              h = h * bounce;
        }
          return seen;
        
      }
    public static void main(String[] args){
        int sum = 0;
        int sum2 = 0; 
        int n = 4; 
        for (int k = 0; k < n; k ++) {
            sum ++;
            if (k % 2 == 1)
                for (; k < (n * n * n); k++)
                    sum2 = sum2 + 1;
                    System.out.println(k);
        }
        System.out.println(sum2);
        System.out.println(sum);
    }
}
