public class WhoLikesThis {

    public static String whoLikesIt(String... names) {
     
        int counter = 0; 
        String[] temp = names; 
        if(temp.length == 1)
          return temp[0] + " likes this";
         if(temp.length == 2)
          return temp[0] + " and " + temp[1] + " like this";
        if(temp.length == 3)
          return temp[0] + ", " + temp[1] + " and " + temp[2] + " like this";
        if(temp.length > 3)
          return temp[0] + ", " + temp[1] + " and " + (temp.length -2) + " others like this";
        else
          return "no one likes this";
      }

      // example 

      public static String whoLikesIt2(String... nms) {
        switch (nms.length) {
          case 0: return "no one likes this";
          case 1: return String.format("%s likes this", nms[0]);
          case 2: return String.format("%s and %s like this", nms[0], nms[1]);
          case 3: return String.format("%s, %s and %s like this", nms[0], nms[1], nms[2]);
          default: return String.format("%s, %s and %d others like this", nms[0], nms[1], nms.length - 2);
        }
    }
    
}
