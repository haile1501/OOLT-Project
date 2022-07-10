package hust.soict.globalict.main.data.buildingsandstructures;

import hust.soict.globalict.utils.Utils;

public class Bridge extends BuildingAndStructure {
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
                Utils.createOptionalStatement(this.getRiver());
    }
}
