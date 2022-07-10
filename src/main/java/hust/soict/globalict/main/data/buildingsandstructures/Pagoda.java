package hust.soict.globalict.main.data.buildingsandstructures;



public class Pagoda extends BuildingAndStructure {
    public Pagoda() {
        super();
        this.dataSource =
                """
                { ?data dct:subject dbc:Pagodas_in_Vietnam }
                UNION
                { ?data dct:subject dbc:Buddhist_temples_in_Vietnam }
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