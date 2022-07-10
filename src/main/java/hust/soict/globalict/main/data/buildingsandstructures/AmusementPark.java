package hust.soict.globalict.main.data.buildingsandstructures;

import hust.soict.globalict.utils.Utils;

public class AmusementPark extends BuildingAndStructure {
    private final String openingDate;

    public AmusementPark() {
        super();
        this.dataSource = "?data dct:subject dbc:Amusement_parks_in_Vietnam.";
        this.openingDate = "?data dbp:openingDate ?openingDate.";
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
                Utils.createOptionalStatement(this.getOpeningDate());
    }
}
