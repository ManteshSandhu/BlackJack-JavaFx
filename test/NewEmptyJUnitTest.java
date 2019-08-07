/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.control.TextField;
import javafxapplication1.BlackJack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mantesh
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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
    @Test
    public void testNewDeal() {
        System.out.println("CheckDeal good");
        boolean expResult= true;
        boolean result = BlackJack.newDeal("200");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    
}@Test
    public void testNewDealBad() {
        System.out.println("CheckDeal bad");
        boolean expResult= false;
        boolean result = BlackJack.newDeal("600");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    
}@Test
    public void testNewDealBoundart() {
        System.out.println("CheckDeal boundary");
        boolean expResult= true;
        boolean result = BlackJack.newDeal("500");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    
}
}
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

