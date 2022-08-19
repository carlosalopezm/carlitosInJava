/**
 * Author: Carlos López 
 * UNI: cal2266
 * Description: This is the java code for problem 4 in the p-set.
 * Both 
 * Date: 07/16/21
 */
import java.util.*;
public class PrintSinglyLinkedLists{

private  static Node head;
// add a static node class to implment the nodes 
    static class Node {

        int data;
        Node next;

        Node(int val)
        {
            data = val;
            next = null;
        }
    }


    public static Node reverseLinearMemory(Node head){
        // if head is null there is no need to reverse
        if(head == null || head.next == null){

            return head; 
        }
        // use a stack 
        Stack <Node > myStack = new Stack <Node> ();
        Node reversedL = head;
        while (reversedL != null)
        {
            myStack.push(reversedL);
            reversedL = reversedL.next;
        }
        while (!myStack.isEmpty())
        {
            Node currRev = myStack.peek();
            System.out.print(currRev.data+" ");
            myStack.pop();
        } // time is N + N, due to the while loops
        //Thus we get O(N^2) 
        
        return reversedL;
    }

    public static Node reverseConstantMemory(Node head){
        // if head is null there is no need to reverse
        if(head == null || head.next == null){
            return head; 
        }

        Node reversedL = null;
        while(reversedL !=head)
        { // time is O(n^2) but memory is O(1)
            Node temp = head;
            while(temp.next!=reversedL)
            {
                temp = temp.next;
            }
            System.out.print(temp.data+" ");
            reversedL=temp;
        }
        
        return reversedL;
    }

         

    

    public static void main(String[] args)
    { // clear
        PrintSinglyLinkedLists  list = new PrintSinglyLinkedLists();
        list.head = new Node(3);
        list.head.next = new Node(9);
        list.head.next.next = new Node(27);
        list.head.next.next.next = new Node(81);

        System.out.println("reverseLinearMemory");
        list.reverseLinearMemory(head);
        System.out.println("\n___________________________\n");
        System.out.println("reverseConstantMemory");
        list.reverseConstantMemory(head);
    }
}