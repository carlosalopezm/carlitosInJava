/**
 * Author: Carlos López 
 * UNI: cal2266
 * Description: This is the java-like pseudo code for the Java
 * TwoStack<AnyType> generic class that 
 *  implments two stacks in one array
 * Date: 07/16/21
 */
import java.lang.*;
import java.util.*; 
public class TwoStack<AnyType>{
    private AnyType array[]; 
    private int topA; 
    private int topB; 
    private int maxCap;
    //constructor  
    public TwoStack(int n){
        maxCap = n;
        array = (AnyType[]) new Object[maxCap]; 
        topA = -1; 
        topB = maxCap; 
    }
    //methods
    /**
     * Push A 
     */
      public void pushA(AnyType element){
        if(topA == topB -1){
          System.out.println("Stack A Overflow"); //declare overflow
        }
        else{
            array[++topA] = element; // add element
        }

    }
/**
 * Push B
 */
    public void pushB(AnyType element){
        if(topB == topA + 1){
            System.out.println("Stack B Overflow"); // declare overlfow
        }
        else{
            array[--topB] = element; // add element
        }

    }
/**
 * pop method for A 
 */
    public AnyType popA(){
        if(topA == -1){ // check if stack is not empty
            System.out.println("Stack A Underflow."); // declare underflow
            return null; 
        }
        else{
            AnyType element = array[topA--]; // pop element
            return element; // return the element

        }
    }
/**
 * pop method for B
 */
public AnyType popB(){
    if(topB == maxCap){
        System.out.println("Stack B Underflow."); // declare underflow
        return null; 
    }
    else{
        AnyType element = array[topB++]; // pop element
        return element; // return the element

    }

}
// isFull for A

public boolean isFullA(){ 
    if(topA == topB-1){
        return true; 
    }else{
        return false;
    }

}
//isFull for B 

public boolean isFullB(){
    if(topB == topA+1){
        return true; 
    }else{
        return false;
    }

}
//IsEmpty for A 
public boolean isEmptyA(){
    return (topA == -1);

}

//IsEmpty for B

public boolean isEmptyB(){
    return (topB == maxCap);


}
public AnyType peekA(){
    if(topA >=0){
        return array[topA];// return element added most recently
    }
    }
    else{
        return null; //
    }
}

public AnyType peekB(){
    if(topB < maxCap){
        return array[topB]; // return element added most recently
    }
    else{
        return null; // return null if no element is available
    }

}
    
    

}