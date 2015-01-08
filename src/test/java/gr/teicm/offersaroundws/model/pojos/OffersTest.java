/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.offersaroundws.model.pojos;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OffersTest {
    
    private Offers o1;
    private Offers o2;
    
    @Before
    public void setUp() {
        o1 = new Offers(new Stores(), "testProduct", 1.0f,
                new Date(), new Date(System.currentTimeMillis() + 604800000));
        o2 = new Offers();
    }
    
    
    /**
     * Test of getOfferId method, of class Offers.
     */
    @Test
    public void testGetOfferId() {
        
        assertNull(o1.getOfferId());
        o1.setOfferId(1);
        assertEquals(1, o1.getOfferId());
    }

    /**
     * Test of setOfferId method, of class Offers.
     */
    @Test
    public void testSetOfferId() {
        
        assertNull(o1.getOfferId());
        o1.setOfferId(1);
        assertEquals(1, o1.getOfferId());
        
        assertNull(o2.getOfferId());
        o2.setOfferId(2);
        assertEquals(2, o2.getOfferId());
    }

    /**
     * Test of getStores method, of class Offers.
     */
    @Test
    public void testGetStores() {
        
        assertNotNull(o1.getStores());
        assertNull(o2.getStores());
    }

    /**
     * Test of setStores method, of class Offers.
     */
    @Test
    public void testSetStores() {
        

        assertNull(o2.getStores());
        o2.setStores(new Stores());
        assertNotNull(o2.getStores());
    }

    /**
     * Test of getProduct method, of class Offers.
     */
    @Test
    public void testGetProduct() {
        
        assertNotNull(o1.getProduct());
        assertEquals("testProduct", o1.getProduct());
        assertNull(o2.getProduct());
    }

    /**
     * Test of setProduct method, of class Offers.
     */
    @Test
    public void testSetProduct() {
        
        assertNull(o2.getProduct());
        o2.setProduct("testProduct2");
        assertEquals("testProduct2", o2.getProduct());
    }

    /**
     * Test of getPrice method, of class Offers.
     */
    @Test
    public void testGetPrice() {
        
        assertNotNull(o1.getPrice());
        assertEquals(1.0f, o1.getPrice(), 0.0);
        
        assertNotNull(o2.getPrice());
        assertEquals(0.0f, o2.getPrice(), 0.0);
    }

    /**
     * Test of setPrice method, of class Offers.
     */
    @Test
    public void testSetPrice() {
        
        assertNotNull(o2.getPrice());
        assertEquals(0.0f, o2.getPrice(), 0.0);
        o2.setPrice(2.0f);
        assertEquals(2.0f, o2.getPrice(), 0.0);
    }

    /**
     * Test of getBeginDate method, of class Offers.
     */
    @Test
    public void testGetBeginDate() {
        
        assertNotNull(o1.getBeginDate());
        // 1 second delay threshold
        assertEquals(System.currentTimeMillis(), o1.getBeginDate().getTime(), 1000);
        
        assertNull(o2.getBeginDate());
    }

    /**
     * Test of setBeginDate method, of class Offers.
     */
    @Test
    public void testSetBeginDate() {
        
        assertNull(o2.getBeginDate());
        o2.setBeginDate(new Date());
        
        // 1 second delay threshold
        assertEquals(System.currentTimeMillis(), o2.getBeginDate().getTime(), 1000);
    }

    /**
     * Test of getEndDate method, of class Offers.
     */
    @Test
    public void testGetEndDate() {
        
        assertNotNull(o1.getBeginDate());
        // 1 second delay threshold
        assertEquals(System.currentTimeMillis() + 604800000, o1.getEndDate().getTime(), 1000);
        
        assertNull(o2.getEndDate());
    }

    /**
     * Test of setEndDate method, of class Offers.
     */
    @Test
    public void testSetEndDate() {
        
        assertNull(o2.getBeginDate());
        o2.setEndDate(new Date(System.currentTimeMillis() + 604800000));
        
        // 1 second delay threshold
        assertEquals(System.currentTimeMillis() + 604800000, o2.getEndDate().getTime(), 1000);
    }
    
}
