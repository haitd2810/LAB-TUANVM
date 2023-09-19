/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

public class SouthEastAsiaCountries extends Country{
    private String countryTerrain;

    public SouthEastAsiaCountries() {
    }

    public SouthEastAsiaCountries(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public SouthEastAsiaCountries(String countryCode, String countryName, float totalArea,String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain.substring(0, 1).toUpperCase()+countryTerrain.substring(1).toLowerCase();
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public String toString() {
        return super.toString() +String.format("\t\t %-10s", countryTerrain); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
