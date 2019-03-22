package hdt7;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gerardo
 */
public class BinaryTreeTest {
    
    public BinaryTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test del metodo addElements
     * Agrega un nuevo Association al BinaryTree que se crea
     */
    @Test
    public void testAddElements() {
        System.out.println("addElements");
        BinaryTree root = new BinaryTree(null);
        ArrayList<Association> commands = new ArrayList();
        commands.add(new Association("Prueba", "Superada"));
        BinaryTree instance = new BinaryTree();
        BinaryTree expResult = new BinaryTree(new Association("Prueba", "Superada"));
        BinaryTree result = instance.addElements(root, commands);
        assertEquals(String.valueOf(expResult.val.getKey()), String.valueOf(result.val.getKey()));
    }

    /**
     * Test del metodo contains
     * Crea un BinaryTree con un valor definido
     * El resultado esperado es 'true'
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        BinaryTree current = new BinaryTree(new Association("Prueba", "Superada"));
        String value = "Prueba";
        boolean expResult = true;
        boolean result = current.contains(current, value);
        assertEquals(expResult, result);
    }
    
}
