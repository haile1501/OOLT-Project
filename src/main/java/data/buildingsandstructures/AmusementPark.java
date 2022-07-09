package data.buildingsandstructures;

import utils.Utils;

public class AmusementPark extends BuildingAndStructure {
    private final String dataSource;
    private final String openingDate;

    public AmusementPark() {
        super();
        this.dataSource = "?data dct:subject dbc:Amusement_parks_in_Vietnam.";
        this.openingDate = "?data dbp:openingDate ?openingDate.";
    }

    public String getDataSource() {
        return dataSource;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getOpeningDate();
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                this.getDataSource() + "\n" +
                Utils.createOptionalStatement(this.getOpeningDate());
    }
}
