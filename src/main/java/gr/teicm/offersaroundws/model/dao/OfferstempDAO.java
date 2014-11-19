/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.offersaroundws.model.dao;

import gr.teicm.offersaroundws.model.pojos.Offerstemp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;


/**
 *
 * @author Public
 */
public class OfferstempDAO {
    public void insertOffer(Offerstemp o){
        SessionFactory sf=null;
        Session session=null;
        Transaction tx=null;
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            session.close();
        }catch(Exception ex){
            tx.rollback();
            throw new RuntimeException("Could not save the offer");
        }
    }
    
    public String readOffer(int businessId){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Offerstemp o = (Offerstemp)session.get(Offerstemp.class, businessId);
        session.close();
        if (o!=null){
            return "The business name is "+o.getBusinessName()+ " ,offer is "+o.getOffer()+ " ,Latitude is "+o.getLatitude()+ " and Longitude is "+o.getLongitude();
        }else{
            return "The business id " +businessId+ " does not exist";
        }
    }
    
    public List<Offerstemp> listOfferstemp(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Offers");
        List<Offerstemp> list = query.list();
        session.close();
        return list;
    }
}
