package data.buildingsandstructures;

import utils.Utils;

public class Airport extends BuildingAndStructure {
    private final String dataSource;
    private final String startYear;
    private final String operator;
    private final String cityServed;

    public Airport() {
        super();
        this.dataSource = "?data dct:subject dbc:Airports_in_Vietnam.";
        this.startYear = "?data dbp:statYear ?startYear.";
        this.cityServed = "?data dbp:cityServed ?cityServed.";
        this.operator = "?data dbp:operator ?operator.";
    }

    public String getDataSource() {
        return dataSource;
    }

    public String getStartYear() {
        return startYear;
    }

    public String getOperator() {
        return operator;
    }

    public String getCityServed() {
        return cityServed;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getStartYear() + "\n" +
                this.getCityServed() + "\n" +
                this.getOperator() + "\n";
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                this.getDataSource() + "\n" +
                Utils.createOptionalStatement(this.getOperator()) +
                Utils.createOptionalStatement(this.getCityServed()) +
                Utils.createOptionalStatement(this.getStartYear());
    }
}
