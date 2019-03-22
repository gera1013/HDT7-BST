package hdt7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gerardo
 */
public class HDT7 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        BinaryTree bst = new BinaryTree(null);
        ArrayList<String> array = new ArrayList<>();
        Scanner read = new Scanner(new File("doc.txt"));
        read.useDelimiter("\\r\\n");
        String data;
        
        while(read.hasNext())
        {
            if(read.hasNextLine()){
                data = read.next();
                if(!data.equals(" ")) array.add(data);
            }
        }
        
        BinaryTree root = bst.addElements(bst, array);
        
        //System.out.println("");
        
        //bst.traverseInOrder(root);
    }
}
