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
        ArrayList<Association> asso = new ArrayList<>();
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
        
        for(String a : array)
        {
            a = a.replaceFirst("[(]", "");
            a = a.replaceFirst(",", "");
            a = a.replaceFirst("[)]", "");
            System.out.println(a);
            String [] b = a.split(" ");
            Association novo = new Association(b[0], b[1]);
            asso.add(novo);
        }
        
        BinaryTree root = bst.addElements(bst, asso);
        
        System.out.println("");
        
        bst.traverseInOrder(root);
    }
}
