package gr.teicm.offersaroundws.model.pojos;
// Generated Nov 25, 2014 10:11:27 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Stores generated by hbm2java
 */
public class Stores  implements java.io.Serializable {


     private int storeId;
     private String name;
     private String latitude;
     private String longitude;
     private String address;
     private int telephone;
     private int postalCode;
     private String email;
     private String site;
     private Set<Offers> offerses = new HashSet<Offers>(0);

    public Stores() {
    }

	
    public Stores(String name, String latitude, String longitude, String address, int telephone, int postalCode, String email, String site) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.telephone = telephone;
        this.postalCode = postalCode;
        this.email = email;
        this.site = site;
    }
    public Stores(String name, String latitude, String longitude, String address, int telephone, int postalCode, String email, String site, Set<Offers> offerses) {
       this.name = name;
       this.latitude = latitude;
       this.longitude = longitude;
       this.address = address;
       this.telephone = telephone;
       this.postalCode = postalCode;
       this.email = email;
       this.site = site;
       this.offerses = offerses;
    }
   
    public int getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public int getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public int getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSite() {
        return this.site;
    }
    
    public void setSite(String site) {
        this.site = site;
    }
    public Set<Offers> getOfferses() {
        return this.offerses;
    }
    
    public void setOfferses(Set<Offers> offerses) {
        this.offerses = offerses;
    }




}