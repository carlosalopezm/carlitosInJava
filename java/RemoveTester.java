import java.util.*;
public class RemoveTester{

    public static void main(String[] args){

        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0; i < 10; i++){
            a.add(i);  
        }

        //int theSize = a.size( ) / 2;
        //System.out.print(a);
        for( int i = 0; i < a.size()/2; i++ ){
            System.out.println(a);
            a.remove( 0 );

        }
    }

}