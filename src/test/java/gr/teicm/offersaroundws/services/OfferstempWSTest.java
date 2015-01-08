/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.offersaroundws.services;

import gr.teicm.offersaroundws.model.dao.HibernateUtil;
import gr.teicm.offersaroundws.model.pojos.Offerstemp;
import java.util.Collections;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OfferstempWSTest {
    
    private static String businessName;
    private static float latitude;
    private static float longitude;
    private static String offer;
    
    private static SessionFactory sf;
    private static Session session;
    private Transaction tx;
    
    @BeforeClass
    public static void setUpClass() {
        businessName = "testName";
        latitude = 1.0f;
        longitude = 1.0f;
        offer = "testOffer";
    }
    
     /**
     * Test of InsertOffer method, of class OfferstempWS.
     */
    @Test
    public void testInsertOffer() {
      
        
        OfferstempWS instance = new OfferstempWS();
        List<Offerstemp> offers = instance.AllOffers();
        
        int recordsNumber = offers.size();
        instance.InsertOffer(recordsNumber + 1, businessName, latitude, longitude, offer);
        List<Offerstemp> newOffers = instance.AllOffers();
        int newRecordsNumber = newOffers.size();
        
        assertEquals(1, newRecordsNumber - recordsNumber);
        
        // Using SQL queries to delete the test record after the check and to fix
        // the broken auto increment sequence after the deletion.
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        SQLQuery sql1 = session.createSQLQuery("DELETE FROM offersaround.offerstemp"
                + " WHERE businessID = " + newRecordsNumber);
        sql1.executeUpdate();
        SQLQuery sql2 = session.createSQLQuery("ALTER TABLE offersaround.offerstemp"
                + " AUTO_INCREMENT = " + newRecordsNumber);
        sql2.executeUpdate();
        session.close();
        // ---------------------------------------------------------------------
        List<Offerstemp> afterTestOffers = instance.AllOffers();
        int afterTestRecordsNumber = afterTestOffers.size();
        assertEquals(recordsNumber, afterTestRecordsNumber);
        assertEquals(new Integer(recordsNumber), 
                afterTestOffers.get(afterTestRecordsNumber - 1).getBusinessId());
    }

    /**
     * Test of SearchOffer method, of class OfferstempWS.
     */
    @Test
    public void testSearchOffer() {
        
        OfferstempWS instance = new OfferstempWS();
        List<Offerstemp> records = instance.AllOffers();

        int recordsNumber = records.size();
        int i;
        String expResult;
        
        for( i = 0; i < recordsNumber; i++ ) {
            expResult = "The business name is "+records.get(i).getBusinessName()+ 
                    " ,offer is "+records.get(i).getOffer()+ " ,Latitude is "
                    +records.get(i).getLatitude()
                    + " and Longitude is "+records.get(i).getLongitude();
            assertEquals(expResult, instance.SearchOffer(i+1));
        }
        
        expResult = "The business id " + ++i + " does not exist";
        assertEquals(expResult, instance.SearchOffer(i));
    }

    /**
     * Test of AllOffers method, of class OfferstempWS.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testAllOffers() {
        OfferstempWS instance = new OfferstempWS();
        List<Offerstemp> result = instance.AllOffers();
        

        int recordsNumber = result.size();
        int i;
        for( i = 0; i < recordsNumber; i++ ) {
            assertNotNull(result.get(i));
            assertEquals(new Integer(i + 1), result.get(i).getBusinessId());
        }
        
        // must trhow IndexOutOfBoundsException
        result.get(i);
        
    }
    
}
