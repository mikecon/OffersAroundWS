/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.offersaroundws.model.pojos;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StoresTest {

    private Stores s1;
    private Stores s2;
       
    @Before
    public void setUp() {
        s1 = new Stores("testName", "1.0", "1.0", "testAddress", 555555, 123, 
                "test@mail", "test.site", new HashSet<Offers>());
        s2 = new Stores();
    }
    
    
    /**
     * Test of getStoreId method, of class Stores.
     */
    @Test
    public void testGetStoreId() {
        
        assertNull(s1.getStoreId());
        s1.setStoreId(1);
        assertEquals(1, s1.getStoreId());
    }

    /**
     * Test of setStoreId method, of class Stores.
     */
    @Test
    public void testSetStoreId() {
        
        assertNull(s1.getStoreId());
        s1.setStoreId(1);
        assertEquals(1, s1.getStoreId());
        
        assertNull(s2.getStoreId());
        s2.setStoreId(2);
        assertEquals(2, s2.getStoreId());
    }

    /**
     * Test of getName method, of class Stores.
     */
    @Test
    public void testGetName() {
        
        assertNotNull(s1.getName());
        assertEquals("testName", s1.getName());
        assertNull(s2.getName());
    }

    /**
     * Test of setName method, of class Stores.
     */
    @Test
    public void testSetName() {
        
        assertNull(s2.getName());
        s2.setName("testName2");
        assertEquals("testName2", s2.getName());
    }

    /**
     * Test of getLatitude method, of class Stores.
     */
    @Test
    public void testGetLatitude() {
        
        assertNotNull(s1.getLatitude());
        assertEquals("1.0", s1.getLatitude());
        assertNull(s2.getLatitude());
    }

    /**
     * Test of setLatitude method, of class Stores.
     */
    @Test
    public void testSetLatitude() {
        
        assertNull(s2.getLatitude());
        s2.setLatitude("2.0");
        assertEquals("2.0", s2.getLatitude());
    }

    /**
     * Test of getLongitude method, of class Stores.
     */
    @Test
    public void testGetLongitude() {
       
        assertNotNull(s1.getLongitude());
        assertEquals("1.0", s1.getLongitude());
        assertNull(s2.getLongitude());
    }

    /**
     * Test of setLongitude method, of class Stores.
     */
    @Test
    public void testSetLongitude() {
        
        assertNull(s2.getLongitude());
        s2.setLongitude("2.0");
        assertEquals("2.0", s2.getLongitude());
    }

    /**
     * Test of getAddress method, of class Stores.
     */
    @Test
    public void testGetAddress() {
        
        assertNotNull(s1.getAddress());
        assertEquals("testAddress", s1.getAddress());
        assertNull(s2.getAddress());
    }

    /**
     * Test of setAddress method, of class Stores.
     */
    @Test
    public void testSetAddress() {
        
        assertNull(s2.getAddress());
        s2.setAddress("testAddress2");
        assertEquals("testAddress2", s2.getAddress());
    }

    /**
     * Test of getTelephone method, of class Stores.
     */
    @Test
    public void testGetTelephone() {
        
        assertNotNull(s1.getTelephone());
        assertEquals(555555, s1.getTelephone());
        
        assertNotNull(s2.getTelephone());
        assertEquals(0, s2.getTelephone());
    }

    /**
     * Test of setTelephone method, of class Stores.
     */
    @Test
    public void testSetTelephone() {
        
        assertNotNull(s2.getTelephone());
        assertEquals(0, s2.getTelephone());
        s2.setTelephone(444444);
        assertEquals(444444, s2.getTelephone());
    }

    /**
     * Test of getPostalCode method, of class Stores.
     */
    @Test
    public void testGetPostalCode() {
        
        assertNotNull(s1.getPostalCode());
        assertEquals(123, s1.getPostalCode());
        
        assertNotNull(s2.getPostalCode());
        assertEquals(0, s2.getPostalCode());
    }

    /**
     * Test of setPostalCode method, of class Stores.
     */
    @Test
    public void testSetPostalCode() {
        
        assertNotNull(s2.getPostalCode());
        assertEquals(0, s2.getPostalCode());
        s2.setPostalCode(456);
        assertEquals(456, s2.getPostalCode());
    }

    /**
     * Test of getEmail method, of class Stores.
     */
    @Test
    public void testGetEmail() {
        
        assertNotNull(s1.getEmail());
        assertEquals("test@mail", s1.getEmail());
        assertNull(s2.getEmail());
    }

    /**
     * Test of setEmail method, of class Stores.
     */
    @Test
    public void testSetEmail() {
        
        assertNull(s2.getEmail());
        s2.setEmail("test2@mail");
        assertEquals("test2@mail", s2.getEmail());
    }

    /**
     * Test of getSite method, of class Stores.
     */
    @Test
    public void testGetSite() {
        
        assertNotNull(s1.getSite());
        assertEquals("test.site", s1.getSite());
        assertNull(s2.getSite());
    }

    /**
     * Test of setSite method, of class Stores.
     */
    @Test
    public void testSetSite() {
     
        assertNull(s2.getSite());
        s2.setSite("test2.site");
        assertEquals("test2.site", s2.getSite());
    }

    /**
     * Test of getOfferses method, of class Stores.
     */
    @Test
    public void testGetOfferses() {
        
        assertNotNull(s1.getOfferses());
        assertTrue(s1.getOfferses().isEmpty());
    }

    /**
     * Test of setOfferses method, of class Stores.
     */
    @Test
    public void testSetOfferses() {
       
        assertTrue(s2.getOfferses().isEmpty());
        s2.setOfferses(new HashSet<Offers>(Arrays.asList(new Offers())));
        assertEquals(1, s2.getOfferses().size());
    }
    
}
