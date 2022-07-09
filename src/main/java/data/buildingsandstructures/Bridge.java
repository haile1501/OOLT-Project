package data.buildingsandstructures;

import utils.Utils;

public class Bridge extends BuildingAndStructure {
    private final String dataSource;
    private final String river;

    public Bridge() {
        super();
        this.river = "?data dbp:crosses ?river.";
        this.dataSource =
                """
                { ?data dct:subject dbc:Bridges_in_Vietnam. }
                UNION
                { ?data dct:subject dbc:Road_bridges_in_Vietnam. }
                UNION
                { ?data dct:subject dbc:Bridges_in_Hanoi. }
                """;
    }

    public String getDataSource() {
        return dataSource;
    }

    public String getRiver() {
        return river;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getRiver();
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                this.getDataSource() +
                Utils.createOptionalStatement(this.getRiver());
    }
}
