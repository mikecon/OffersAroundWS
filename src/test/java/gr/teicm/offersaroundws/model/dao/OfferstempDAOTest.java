/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.offersaroundws.model.dao;

import gr.teicm.offersaroundws.model.pojos.Offerstemp;
import java.util.Collections;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import static org.junit.Assert.*;


public class OfferstempDAOTest {
    
    private static SessionFactory sf;
    private static Session session;
    private Transaction tx;
    
    public OfferstempDAOTest() {
    }
    
    /**
     * Test of listOfferstemp method, of class OfferstempDAO.
     * Assuming that businessId field is an auto increment field,
     * i.e. the business id of a new offer will be the same as the one of the
     * last record's id, in the db table, plus one.
     * This method ensures that all data in the db table are retrieved
     * according to their sorted (by the business id) appearance and no 
     * invalid data are retrieved throwing an IndexOutOfBoundsException.
     */
//    @Ignore
    @Test(expected=IndexOutOfBoundsException.class)
    public void testListOfferstemp() {
        
        OfferstempDAO instance = new OfferstempDAO();
        List<Offerstemp> result = instance.listOfferstemp();
        

        int recordsNumber = result.size();
        int i;
        for( i = 0; i < recordsNumber; i++ ) {
            assertNotNull(result.get(i));
            assertEquals(new Integer(i + 1), result.get(i).getBusinessId());
        }
        
        // must trhow IndexOutOfBoundsException
        result.get(i);
    }

    /**
     * Test of insertOffer method, of class OfferstempDAO.
     * This method initially inserts a test record in the db table and checks
     * the success of the insertion by comparing the records list's size before
     * and after it took place. Then the method deletes the test record from 
     * the db table using SQL query (as deletion of records in the DOA is out
     * of the project's scope) and fixes the auto increment issue that arises from
     * the deletion. Finally the method checks that the db table has come back on
     * its original form.
     */
//    @Ignore
    @Test
    public void testInsertOffer() {
        
        
        Offerstemp o = new Offerstemp("testName", 0.1f, 0.1f, "testOffer");
        OfferstempDAO instance = new OfferstempDAO();
        List<Offerstemp> offers = instance.listOfferstemp();
        
        int recordsNumber = offers.size();
        instance.insertOffer(o);
        List<Offerstemp> newOffers = instance.listOfferstemp();
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
        List<Offerstemp> afterTestOffers = instance.listOfferstemp();
        int afterTestRecordsNumber = afterTestOffers.size();
        assertEquals(recordsNumber, afterTestRecordsNumber);
        assertEquals(new Integer(recordsNumber), 
                afterTestOffers.get(afterTestRecordsNumber - 1).getBusinessId());
    }

    /**
     * Test of searchOffer method, of class OfferstempDAO.
     */
//    @Ignore
    @Test
    public void testSearchOffer() {
        
        OfferstempDAO instance = new OfferstempDAO();
        List<Offerstemp> records = instance.listOfferstemp();
        int recordsNumber = records.size();
        int i;
        String expResult;
        
        for( i = 0; i < recordsNumber; i++ ) {
            expResult = "The business name is "+records.get(i).getBusinessName()+ 
                    " ,offer is "+records.get(i).getOffer()+ " ,Latitude is "
                    +records.get(i).getLatitude()
                    + " and Longitude is "+records.get(i).getLongitude();
            assertEquals(expResult, instance.searchOffer(i+1));
        }
        
        expResult = "The business id " + ++i + " does not exist";
        assertEquals(expResult, instance.searchOffer(i));
    }    
}
