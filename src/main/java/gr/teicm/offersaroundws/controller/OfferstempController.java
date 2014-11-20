
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

   public String getbusinessName(){
      return model.getBusinessName();		
   }

   public void updateView(){				
      view.printOfferstempDetails(model.getBusinessId());
   }	
}
