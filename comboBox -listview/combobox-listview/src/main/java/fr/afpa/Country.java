package fr.afpa;

import java.util.ArrayList;
import java.util.Locale;



public class Country {

    //Déclaration des attributs
    private String name;
    private String isoCode;
    
    //Constructeurs
    public Country(String name, String isoCode) {
        this.name = name;
        this.isoCode = isoCode;
    }
    
    //Getters et setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    //Méthode "toString"
  
    @Override
    public String toString() {
        return name + " " + isoCode ;
    }

     // //Méthode pour lister tous les pays avec le code ISO
     public static ArrayList<Country> getCountriesList() {
        ArrayList<Country> countries = new ArrayList<Country>();

        String[] countryCodes = Locale.getISOCountries();

        for (String countryCode : countryCodes){
            Locale obj = Locale.of("", countryCode);
            countries.add(new Country(obj.getDisplayCountry(), obj.getISO3Country()));
        }

        return countries;

            

    }


    
    
    
    
}
