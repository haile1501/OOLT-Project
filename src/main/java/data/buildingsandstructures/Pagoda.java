package data.buildingsandstructures;



public class Pagoda extends BuildingAndStructure {
    private final String dataSource;
    public Pagoda() {
        super();
        this.dataSource =
                """
                { ?data dct:subject dbc:Pagodas_in_Vietnam }
                UNION
                { ?data dct:subject dbc:Buddhist_temples_in_Vietnam }
                """;
    }

    public String getDataSource() {
        return dataSource;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody();
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                this.getDataSource();
    }
}