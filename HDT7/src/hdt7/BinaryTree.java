package hdt7;

import java.util.ArrayList;

/**
 *
 * @author Gerardo
 * @param <E>
 */
public class BinaryTree<E>
{

    protected E val; // value associated with node
    protected BinaryTree<E> parent; // parent of node
    protected BinaryTree<E> left, right; // children of node
	
    public BinaryTree()
    // post: constructor that generates an empty node
    {
	val = null;
	parent = null; left = right = this;
    }
	
    public BinaryTree(E value)
    // post: returns a tree referencing value and two empty subtrees
    {
	val = value;
        right = left = new BinaryTree<>();
	setLeft(left);
	setRight(right);
    }
	
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
    // post: returns a tree referencing value and two subtrees
    {
	val = value;
	if (left == null) { left = new BinaryTree<>(); }
	setLeft(left);
	if (right == null) { right = new BinaryTree<>(); }
	setRight(right);
    }
	
    public BinaryTree<E> left()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
        return left;
    }
    
    public BinaryTree<E> right()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
        return right;
    }
	
    public BinaryTree<E> parent()
    {
        return null;
    }
    // post: returns reference to parent node, or null
	
    public void setLeft(BinaryTree<E> newLeft)
    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
    {
	//if (isEmpty()) return;
	if (left != null && left.parent() == this) left.setParent(null);
	left = newLeft;
	left.setParent(this);
    }
        
    public void setRight(BinaryTree<E> newRight)
    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
    {
	//if (isEmpty()) return;
	if (right != null && right.parent() == this) right.setParent(null);
	right = newRight;
	right.setParent(this);
    }
	
    protected void setParent(BinaryTree<E> newParent)
    // post: re-parents this node to parent reference, or null
    {
	/*if (!isEmpty()) 
        {
	parent = newParent;
	}*/
    }
        
    public E value()
    // post: returns value associated with this node
    {
	return val;
    }
	
    public void setValue(E value)
    // post: sets the value associated with this node
    {
        val = value;
    }
    
    public boolean isEmpty()
    {
        return this == null;
    }
    
    public BinaryTree addElements(BinaryTree root, ArrayList<String> commands)
    {
        BinaryTree root2;
        for(String a : commands)
        {
            System.out.println("Val: " + root.val);
            if(root.val == null)
            {
                System.out.println("Yo soy la raiz" + a);
                root = new BinaryTree(a);
            }
            else
            {
                root2 = root;
                boolean next = false;
                while(!next)
                {
                    BinaryTree temp = new BinaryTree(a);
                    //temp.setParent(root);
                
                    if(String.valueOf(root2.val).substring(1,2).charAt(0) > a.substring(1,2).charAt(0))
                    {
                        System.out.println(root2.left.val);
                        if(root2.left.val == null) 
                        {
                            System.out.println("Yo soy hijo a la izquierda: " + a);
                            root2.setLeft(temp);
                            next = true;
                        }
                        else
                        {
                            root2 = root2.left();
                        }
                    }
                    else
                    {
                        System.out.println(root2.right.val);
                        if(root2.right.val == null)
                        {
                            System.out.println("Yo soy hijo a la derecha: " + a);
                            root2.setRight(temp);
                            next = true;
                        }
                        else
                        {
                            root2 = root2.right();
                        }
                    }
                }                
            }
        }
        return root;
    }
    
    public void traverseInOrder(BinaryTree bst) {
        if (bst.val != null) 
        {
            traverseInOrder(bst.left);
            System.out.print(" " + bst.val);
            traverseInOrder(bst.right);
        }
}
}