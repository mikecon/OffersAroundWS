/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.offersaroundws.controller;

import gr.teicm.offersaroundws.model.dao.OfferstempDAO;
import gr.teicm.offersaroundws.model.pojos.Offerstemp;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class OfferstempControllerTest {
    
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
    private static Offerstemp model;
    private static OfferstempDAO view;
    private OfferstempController o;
       
    @BeforeClass
    public static void setUpClass() {
               
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @AfterClass
    public static void cleanUpClass() {
        System.setOut(null);
        System.setErr(null);
    }
    
    @Before 
    public void setUp() {
        model = new Offerstemp("testName", 1.0f, 1.0f, "testOffer");
        view = new OfferstempDAO();
        o = new OfferstempController(model, view);
    }

    /**
     * Test of getBusinessId method, of class OfferstempController.
     */
    @Test(expected=NullPointerException.class)
    public void testGetBusinessId() {
        o.getBusinessId();
        model.setBusinessId(1);
        assertEquals(1, o.getBusinessId());
    }

    /**
     * Test of getBusinessName method, of class OfferstempController.
     */
    @Test
    public void testGetBusinessName() {
        assertNotNull(o.getBusinessName());
        assertEquals("testName", o.getBusinessName());
    }

    /**
     * Test of getLatitude method, of class OfferstempController.
     */
    @Test
    public void testGetLatitude() {
        assertNotNull(o.getLatitude());
        assertEquals(1.0f, o.getLatitude(), 0.0);
    }

    /**
     * Test of getLongitude method, of class OfferstempController.
     */
    @Test
    public void testGetLongitude() {
        assertNotNull(o.getLongitude());
        assertEquals(1.0f, o.getLongitude(), 0.0);
    }

    /**
     * Test of getOffer method, of class OfferstempController.
     */
    @Test
    public void testGetOffer() {
        assertNotNull(o.getOffer());
        assertEquals("testOffer", o.getOffer());
    }

    /**
     * Test of updateView method, of class OfferstempController.
     */
    @Test
    public void testUpdateView() {
        model.setBusinessId(1);
        o.updateView();
        
        String result = "Offers: \nID: 1\nName: testName\nLatitude: 1.0\nLongitude: 1.0\nOffer: testOffer\n";
        assertEquals(result, outContent.toString());
        
    }
    
}
