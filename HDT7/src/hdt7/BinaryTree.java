package hdt7;

import java.util.ArrayList;

/**
 *
 * @author Gerardo
 * @param <E>
 */
public class BinaryTree<E>
{

    protected Association val; // value associated with node
    protected BinaryTree<E> parent; // parent of node
    protected BinaryTree<E> left, right; // children of node
	
    public BinaryTree()
    // post: constructor that generates an empty node
    {
	val = null;
	parent = null; left = right = this;
    }
	
    /**
     *
     * @param value
     */
    public BinaryTree(Association value)
    // post: returns a tree referencing value and two empty subtrees
    {
	val = value;
        right = left = new BinaryTree<>();
	setLeft(left);
	setRight(right);
    }
	
    /**
     *
     * @param value
     * @param left
     * @param right
     */
    public BinaryTree(Association value, BinaryTree<E> left, BinaryTree<E> right)
    // post: returns a tree referencing value and two subtrees
    {
	val = value;
	if (left == null) { left = new BinaryTree<>(); }
	setLeft(left);
	if (right == null) { right = new BinaryTree<>(); }
	setRight(right);
    }
	
    /**
     *
     * @return
     */
    public BinaryTree<E> left()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
        return left;
    }
    
    /**
     *
     * @return
     */
    public BinaryTree<E> right()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
        return right;
    }
	
    /**
     *
     * @return
     */
    public BinaryTree<E> parent()
    {
        return null;
    }
    // post: returns reference to parent node, or null
	
    /**
     *
     * @param newLeft
     */
    private void setLeft(BinaryTree<E> newLeft)
    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
    {
	//if (isEmpty()) return;
	if (left != null && left.parent() == this) left.setParent(null);
	left = newLeft;
	left.setParent(this);
    }
        
    /**
     *
     * @param newRight
     */
    private void setRight(BinaryTree<E> newRight)
    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
    {
	//if (isEmpty()) return;
	if (right != null && right.parent() == this) right.setParent(null);
	right = newRight;
	right.setParent(this);
    }
	
    /**
     *
     * @param newParent
     */
    protected void setParent(BinaryTree<E> newParent)
    // post: re-parents this node to parent reference, or null
    {
	/*if (!isEmpty()) 
        {
	parent = newParent;
	}*/
    }
        
    /**
     *
     * @return
     */
    public Association value()
    // post: returns value associated with this node
    {
	return val;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty()
    {
        return this == null;
    }
    
    /**
     *
     * @param root
     * @param commands
     * @return
     */
    public BinaryTree addElements(BinaryTree root, ArrayList<Association> commands)
    {
        BinaryTree root2;
        for(Association a : commands)
        {
            if(root.val == null)
            {
                root = new BinaryTree(a);
            }
            else
            {
                root2 = root;
                boolean next = false;
                while(!next)
                {
                    BinaryTree temp = new BinaryTree(a);
                
                    if(String.valueOf(root2.val.getKey()).substring(0,1).charAt(0) > String.valueOf(a.getKey()).substring(0,1).charAt(0))
                    {
                        if(root2.left.val == null) 
                        {
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
                        if(root2.right.val == null)
                        {
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
    
    /**
     *
     * @param bst
     */
    public void traverseInOrder(BinaryTree bst) {
        if (bst.val != null) 
        {
            traverseInOrder(bst.left);
            System.out.println("(" + bst.val.getKey() + ", " + bst.val.getValue() + ")");
            traverseInOrder(bst.right);
        }
    }
    
    /**
     *
     * @param current
     * @param value
     */
    public void traduccion(BinaryTree current, String value) 
    {
        if (current.val != null)
        {
            if(value.equals(String.valueOf(current.val.getKey())))
            {
                System.out.print(String.valueOf(current.val.getValue()) + " ");
            }
            else
            {
                traduccion(current.left(), value);
                traduccion(current.right(), value);
            }
        }
    }
    
    /**
     *
     * @param current
     * @param value
     * @return
     */
    public boolean contains(BinaryTree current, String value) 
    {
        if(current.val == null) return false;
        if(value.equals(String.valueOf(current.val.getKey()))) return true;
        return value.charAt(0) < String.valueOf(current.val.getKey()).charAt(0) ? contains(current.left, value) : contains(current.right, value);
    }
}