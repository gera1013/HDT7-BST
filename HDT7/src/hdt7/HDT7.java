//package hdt7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        Scanner scan = new Scanner(System.in);
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
            String [] b = a.split(" ");
            Association novo = new Association(b[0], b[1]);
            asso.add(novo);
        }
        
        BinaryTree root = bst.addElements(bst, asso);
        
        int x = 0;
        
        while(x != 3)
        {
            try{
                System.out.println("");
                System.out.println("A continuacion ingrese la opción que desea ");
                System.out.println("1. Desplegar contenido del diccionario");
                System.out.println("2. Traducir oración");
                System.out.println("3. Salir");
                x = scan.nextInt();
                
                while(x >= 4 || x <= 0)
                {
                    System.out.println("");
                    System.out.println("A continuacion ingrese la opción que desea ");
                    System.out.println("1. Desplegar contenido del diccionario");
                    System.out.println("2. Traducir oración");
                    System.out.println("3. Salir");
                    x = scan.nextInt();
                }
            } catch(InputMismatchException e)
            {
                System.out.println("Ingrese solamente numeros por favor");
                System.exit(0);
            }
            
            switch(x){
                case 1: 
                    bst.traverseInOrder(root);
                    break;
                case 2:
                    ArrayList<String> oracion = new ArrayList();
                    String palabra;
                    Scanner reader = new Scanner(new File("oracion.txt"));
                    reader.useDelimiter(" ");
                    while(reader.hasNext())
                    {
                        palabra = reader.next();
                        if(palabra.contains(".")) palabra = palabra.substring(0, palabra.length()-1);
                        oracion.add(palabra);
                    }
                    
                    for(String a : oracion) 
                    {
                        a = a.toLowerCase();
                        if(root.contains(root, a)) root.traduccion(root, a);
                        else System.out.print("*" + a + "* ");
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Cerrando el diccionario...");
                    System.exit(0);
                    break;
            }   
        }
    }
}
