/**
 * Author: Carlos López
 * UNI: cal2266
 * Description: This the Binary Search Tree class with lazy deletion
 */
import java.io.*; 
public class BinarySearchTreeProblemSix<AnyType extends Comparable<? super AnyType>>{
// nested binary node class 
    public static class BinaryNode<AnyType>{
        // variables 
        AnyType element; 
        BinaryNode<AnyType> left; 
        BinaryNode<AnyType> right; 
        boolean deleted; 
        BinaryNode( AnyType E){
            this(E, null, null);
            deleted = false; 

        } 

        BinaryNode( AnyType E, BinaryNode<AnyType> leftE, BinaryNode<AnyType> rightE){
            element = E; 
            left = leftE; 
            right = rightE; 
            deleted = false; 
        } 
    }
    private BinaryNode<AnyType> root; 

    public BinarySearchTreeProblemSix(){
        root = null; 
    }

    public void empty(){
        root = null; 
    }

    public boolean isEmpty(){
        return (root == null);
    }

    public boolean contains(AnyType e){
        return contains(e, root);
    }
    // new recursive contains 
    private boolean contains(AnyType e, BinaryNode<AnyType> t){
        if(t == null){
            return false; 
        }

        int comparison = e.compareTo(t.element); 
        if(comparison < 0){ // check lefft if e is less than t
            return contains(e, t.left);
        }
        else if(comparison > 0){ // check right if e is more than t
            return contains( e, t.right);
        }

        else{
            if(t.deleted){
                return false;
            }
            else{
                return true; 
            }
        }
    }
// public find min that calls the recursive helper method 
    public AnyType findMin( ){
        if( isEmpty( ) ){throw new RuntimeException("UnderflowException" );}
        //assume it works like the Underflow class provided by Weiss
        return findMin(root).element;
    }
// new helper findMin method 
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t){
        if( t == null ){
            return null;
        }
//if the root is !null check left subtree for values that are not lazily deleted
// call method to check left tree to find min 
         // if min is less than t
         if(hasLTree(t)) {
            return findMin(t.left);
         }
//Otherwise if the root has not been deleted, return the root cnode.
         if(!t.deleted){
            return t;
         }
         //if there are undeleted nodes in the right subtree recursively call find min

         if(hasRTree(t)){
            return findMin(t.right);
         }
         else{
             return null;
         }
    }

    
// public findMax that calls the recursive helper method 
     public AnyType findMax( ){
       if( isEmpty( ) ){throw new RuntimeException( "UnderflowException");}
       // assume it works like Weiss' UnderflowException 

          return findMax(root).element;

     }
// recursive findMax

    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t ){
          //check if root is null 

            if( t == null )

             return null;

         //If it has a right sub-tree recursively call findMax on it

         if(hasRTree(t))

             return findMax(t.right);

         //Lastly if the root has not been deleted, return the root node.

         if(!t.deleted)

             return t;

         //Lastly, if it has  a left subtree recursively call findMax

         if(hasLTree(t)){
            return findMax(t.left);
         }
         else{
            return null;
         }

    }

// public insert method that calls the recursive helper method 

     public void insert( AnyType x )

     {

          root = insert( x, root );

     }
// new recursive helper insert method 
private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t ){
         if( t == null ){return new BinaryNode<AnyType>( x, null, null );}

         int comparison = x.compareTo( t.element );

         if( comparison < 0 ){
             t.left = insert( x, t.left );
         }

         else if(comparison > 0 ){
             t.right = insert( x, t.right );
         }
        
         /**The main difference is that if the value exists in the tree but in a delted node

         then mark deleted as false. */

         else

         {

             if(t.deleted){
                t.deleted=false;
             }

         }

         return t;

    }


// public remove method that calls the recursive helper method 
     public void remove( AnyType x )

     {

          root = remove( x, root );

     }
// this is the new recursive remove 
     private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t ){
         if( t == null )

             return t;

         int comparison = x.compareTo( t.element );

         if( comparison < 0 )

             t.left = remove( x, t.left );

         else if( comparison > 0 )

             t.right = remove( x, t.right );

         else{ // now the difference is that it check if the item is not deleted

             if(!t.deleted)// it changes deleted to true if item is not lazily deletd 

                  t.deleted=true;
         }
         return t;
    }



     public void printTree( ){
         if( isEmpty( ) ){
             System.out.println( "The tree is empty" );
        } else{
            printTree( root );
        }

     }
    
    //prints the nodes of the tree

    private void printTree( BinaryNode<AnyType> t ){
         if( t != null ){
             printTree( t.left );
             System.out.println( t.element );
             printTree( t.right );
         }

    }
    
    //returns the height of the tree
    private int height( BinaryNode<AnyType> t ){
        if( t == null ){
            return -1;
        }else{
            return 1 + Math.max( height( t.left ), height( t.right ) );   

        }
    }

    // recursive helper that finds delted items in left subtree 
    private boolean hasLTree(BinaryNode<AnyType> t){

        if( t == null ){
            return false;
        }
//Returns true only ifthe node and the left child are not null,and
// the left node is not deleted

        if( t.left == null ){
            return false;
        }

        if( !t.left.deleted){
            return true;
        }
// if the leftSubtree or rightSubtree exists for the left child return true
//Otherwise,  return false because all values in the left subtree are deleted

        if(hasLTree(t.left)||hasRTree(t.left)){
            return true;
        }else{
            return false;
        }

   }


   // recursive helper that finds delted items in right subtree 

   private boolean hasRTree(BinaryNode<AnyType> t){
        //if the root is null then return null value
        if( t == null ){
            return false;
        } 
        if( t.right == null ){
            return false;
        }

        if( !t.right.deleted){
            return true;
        }
        
//retrun true if the leftSubtree or rightSubtree exists for the right child,
//then the boolean returns true. return falseand all nodes in right subtree have been deleted.

        if(hasRTree(t.right)||hasLTree(t.right)){
            return true;
        }
        else{
            return false;
        }
   }


 


}