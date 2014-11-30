
package gr.teicm.offersaroundws.services;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import gr.teicm.offersaroundws.model.pojos.Offerstemp;
import gr.teicm.offersaroundws.model.dao.OfferstempDAO;

@WebService(serviceName = "OfferstempWS")
public class OfferstempWS {

    /**
     * Web service Insert Offers
     */
    @WebMethod(operationName = "InsertOffer")
    public String InsertOffer(@WebParam(name = "BusinessId") int BusinessId, @WebParam(name = "BusinessName") String BusinessName, @WebParam(name = "latitude") float latitude, @WebParam(name = "longitude") float longitude, @WebParam(name = "offer") String offer) {
        Offerstemp o = new Offerstemp(BusinessId,BusinessName,latitude,longitude,offer);
        OfferstempDAO offerdao = new OfferstempDAO();
        offerdao.insertOffer(o);
        return "Done";
    }

    /**
     * Web service Search Offer
     */
    @WebMethod(operationName = "SearchOffer")
    public String SearchOffer(@WebParam(name = "BusinessId") int BusinessId) {
        OfferstempDAO offerdao = new OfferstempDAO();
        return offerdao.searchOffer(BusinessId);
    }

    /**
     * Web service Read All Offers
     */
    @WebMethod(operationName = "AllOffers")
    public List<Offerstemp> AllOffers() {
        OfferstempDAO offerdao = new OfferstempDAO();
        List<Offerstemp> listoffer = offerdao.listOfferstemp();
        return listoffer;
    }

    
}
