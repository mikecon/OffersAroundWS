/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.offersaroundws.services;

import gr.teicm.offersaroundws.model.dao.OfferstempDAO;
import gr.teicm.offersaroundws.model.pojos.Offerstemp;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Michalis Konstantinou
 */
@WebService(serviceName = "OfferstempWS")
public class OfferstempWS {

    /**
     * This is a List web service operation
     */
    @WebMethod(operationName = "AllOffers")
    public List<Offerstemp> AllOffers() {
        OfferstempDAO offerdao = new OfferstempDAO();
        List<Offerstemp> listoffer = offerdao.listOfferstemp();
        return listoffer;
    }
    
    /**
     * This is a Insert Offers web service operation
     */
    @WebMethod(operationName = "InsertOffer")
    public String InsertOffer(@WebParam(name = "BusinessId") int businessId, @WebParam(name = "BusinessName") String businessName, @WebParam(name = "latitude") float latitude, @WebParam(name = "longitude") float longitude, @WebParam(name = "offer") String offer) {
        Offerstemp o = new Offerstemp(businessId,businessName,latitude,longitude,offer);
        OfferstempDAO offerDAO = new OfferstempDAO();
        offerDAO.insertOffer(o);
        return "Offer Insert, it's entered to the database.";
    }

    /**
     * This is a Search Offer web service operation
     */
    @WebMethod(operationName = "SearchOffer")
    public String SearchOffer(@WebParam(name = "BusinessId") int businessId) {
        OfferstempDAO offerdao = new OfferstempDAO();
        return offerdao.searchOffer(businessId);
    }
}