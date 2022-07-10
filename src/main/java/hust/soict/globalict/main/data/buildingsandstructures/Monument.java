package hust.soict.globalict.main.data.buildingsandstructures;

public class Monument extends BuildingAndStructure {
    public Monument() {
        super();
        this.dataSource =
                """                            
                { ?data dct:subject dbc:Monuments_and_memorials_in_Vietnam. }
                UNION
                { ?data dct:subject dbc:Cemeteries_in_Vietnam. }
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
