package data.buildingsandstructures;

public class Monument extends BuildingAndStructure {
    private final String dataSource;
    public Monument() {
        super();
        this.dataSource =
                """                            
                { ?data dct:subject dbc:Monuments_and_memorials_in_Vietnam. }
                UNION
                { ?data dct:subject dbc:Cemeteries_in_Vietnam. }
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
