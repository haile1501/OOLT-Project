package hust.soict.globalict.main.data.buildingsandstructures;

public class Museum extends BuildingAndStructure {
    public Museum() {
        super();
        this.dataSource =
                """
                { ?data dct:subject dbc:Art_museums_and_galleries_in_Vietnam }
                UNION
                { ?data dct:subject dbc:History_museums_in_Vietnam }
                UNION
                { ?data dct:subject dbc:Society_museums_in_Vietnam }
                UNION
                { ?data dct:subject dbc:Military_and_war_museums_in_Vietnam }
                UNION
                { ?data dct:subject dbc:Museums_in_Vietnam }
                """;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody();
    }

    public String createWhereBody() {
        return super.createWhereBody();
    }
}
