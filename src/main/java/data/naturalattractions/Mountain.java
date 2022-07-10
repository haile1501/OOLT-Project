package data.naturalattractions;

import utils.Utils;

public class Mountain extends NaturalAttraction {
    private final String easiestRoute;
    private final String elevationM;

    public Mountain(){
        super();
        this.easiestRoute = "?data dbp:easiestRoute ?easiestRoute.";
        this.elevationM = "?data dbp:elevationM ?elevationM.";
        this.dataSource = "?data dct:subject dbc:Mountains_of_Vietnam.";
    }

    public String getEasiestRoute() {
        return easiestRoute;
    }

    public String getElevationM() {
        return elevationM;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    @Override
    public String createConstructBody() {
        return super.createConstructBody() +
                this.getEasiestRoute() + "\n" +
                this.getElevationM() + "\n";
    }

    @Override
    public String createWhereBody(){
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getEasiestRoute()) + "\n" +
                Utils.createOptionalStatement(this.getElevationM());
    }
}
