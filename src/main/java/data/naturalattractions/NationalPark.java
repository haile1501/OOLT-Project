package data.naturalattractions;

import utils.Utils;

public class NationalPark extends NaturalAttraction {
    private final String nearestCity;
    private final String areaTotal;
    private final String established;

    public NationalPark() {
        super();
        this.areaTotal = "?data dbp:areaTotal ?areaTotal.";
        this.nearestCity = "?data dbp:nearestCity ?nearestCity.";
        this.established = "?data dbp:established ?established.";
        this.dataSource = "?data dct:subject dbc:National_parks_of_Vietnam.";
    }

    public String getAreaTotal() {
        return this.areaTotal;
    } 
    
    public String getNearestCity() {
        return this.nearestCity;
    }

    public String getEstablished() {
        return this.established;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    @Override
    public String createConstructBody() {
        return super.createConstructBody() +
                this.getAreaTotal() + "\n" +
                this.getEstablished() + "\n" +
                this.getNearestCity() + "\n";
    }

    @Override
    public String createWhereBody(){
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getAreaTotal()) + "\n" +
                Utils.createOptionalStatement(this.getNearestCity()) + "\n" +
                Utils.createOptionalStatement(this.getEstablished());
    }
}
