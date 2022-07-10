package hust.soict.globalict.main.data.buildingsandstructures;

public class Church extends BuildingAndStructure {
    public Church() {
        super();
        this.dataSource =
                """               
                { ?data dct:subject dbc:Roman_Catholic_cathedrals_in_Vietnam }
                UNION
                { ?data dct:subject dbc:Basilica_churches_in_Vietnam }
                UNION
                { ?data dct:subject dbc:19th-century_Roman_Catholic_church_buildings_in_Vietnam }
                UNION
                { ?data dct:subject dbc:20th-century_Roman_Catholic_church_buildings_in_Vietnam }
                """;
    }

    public String createConstructBody() {
        return super.createConstructBody();
    }

    public String createWhereBody() {
        return super.createWhereBody();
    }
}
