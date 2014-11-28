
package gr.teicm.offersaroundws.controller;

import gr.teicm.offersaroundws.model.dao.OfferstempDAO;
import gr.teicm.offersaroundws.model.pojos.Offerstemp;

public class OfferstempController {
   private Offerstemp model;
   private OfferstempDAO view;

    public OfferstempController(Offerstemp model, OfferstempDAO view){
      this.model = model;
      this.view = view;
   }
    
    public Short getBusinessId(){
       return model.getBusinessId();
   }
  
    public String getBusinessName(){
      return model.getBusinessName();		
   }
   
   public Float getLatitude(){
       return model.getLatitude();
   }
   
   public Float getLongitude(){
       return model.getLongitude();
   }
   
    public String getOffer(){
      return model.getOffer();		
   }

    public void updateView(){				
      view.printOfferstempDetails(model.getBusinessId(), model.getBusinessName(), model.getLatitude(), model.getLongitude(), model.getOffer());
   }	
}
