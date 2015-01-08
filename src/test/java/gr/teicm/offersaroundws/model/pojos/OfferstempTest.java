/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.offersaroundws.model.pojos;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OfferstempTest {
    
    private Offerstemp o1;
    private Offerstemp o2;
    
    @Before
    public void setUp() {
        o1 = new Offerstemp("testName", 0.1f, 0.1f, "testOffer");
        o2 = new Offerstemp();
    }
    
    /**
     * Test of getBusinessId method, of class Offerstemp.
     */
    @Test
    public void testGetBusinessId() {
        
        
        assertNull(o1.getBusinessId());
        o1.setBusinessId(Integer.MIN_VALUE);
        assertNotNull(o1.getBusinessId());
        assertEquals(new Integer(Integer.MIN_VALUE), o1.getBusinessId());
    }

    /**
     * Test of setBusinessId method, of class Offerstemp.
     */
    @Test
    public void testSetBusinessId() {
        
        assertNull(o1.getBusinessId());
        o1.setBusinessId(Integer.MIN_VALUE);
        assertNotNull(o1.getBusinessId());
        assertEquals(new Integer(Integer.MIN_VALUE), o1.getBusinessId());
    }

    /**
     * Test of getBusinessName method, of class Offerstemp.
     */
    @Test
    public void testGetBusinessName() {
        
        assertNotNull(o1.getBusinessName());
        assertEquals("testName", o1.getBusinessName());
        
        assertNull(o2.getBusinessName());
    }

    /**
     * Test of setBusinessName method, of class Offerstemp.
     */
    @Test
    public void testSetBusinessName() {
        
        assertNull(o2.getBusinessName());
        o2.setBusinessName("testName2");
        assertNotNull(o2.getBusinessName());
        assertEquals("testName2", o2.getBusinessName());
    }

    /**
     * Test of getLatitude method, of class Offerstemp.
     */
    @Test
    public void testGetLatitude() {
        
        assertNotNull(o1.getLatitude());
        assertEquals(0.1f, o1.getLatitude(), 0.0);
        assertEquals(0.0f, o2.getLatitude(), 0.0);
    }

    /**
     * Test of setLatitude method, of class Offerstemp.
     */
    @Test
    public void testSetLatitude() {
        
        assertEquals(0.0f, o2.getLatitude(), 0.0);
        o2.setLatitude(0.2f);
        assertEquals(0.2f, o2.getLatitude(), 0.0);
    }

    /**
     * Test of getLongitude method, of class Offerstemp.
     */
    @Test
    public void testGetLongitude() {
        
        assertNotNull(o1.getLongitude());
        assertEquals(0.1f, o1.getLongitude(), 0.0);
        assertEquals(0.0f, o2.getLatitude(), 0.0);
    }

    /**
     * Test of setLongitude method, of class Offerstemp.
     */
    @Test
    public void testSetLongitude() {
        
        assertEquals(0.0f, o2.getLatitude(), 0.0);
        o2.setLongitude(0.2f);
        assertEquals(0.2f, o2.getLongitude(), 0.0);
    }

    /**
     * Test of getOffer method, of class Offerstemp.
     */
    @Test
    public void testGetOffer() {
       
        assertNotNull(o1.getOffer());
        assertEquals("testOffer", o1.getOffer());
        
        assertNull(o2.getOffer());
    }

    /**
     * Test of setOffer method, of class Offerstemp.
     */
    @Test
    public void testSetOffer() {
       
        assertNull(o2.getOffer());
        o2.setOffer("testOffer2");
        assertNotNull(o2.getOffer());
        assertEquals("testOffer2", o2.getOffer());
    }

   

    
}
