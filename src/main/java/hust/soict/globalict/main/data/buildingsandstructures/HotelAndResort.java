package hust.soict.globalict.main.data.buildingsandstructures;

import hust.soict.globalict.utils.Utils;

public class HotelAndResort extends BuildingAndStructure {
    private final String numberOfRooms;

    public HotelAndResort() {
        super();
        this.numberOfRooms = "?data dbo:numberOfRooms ?numberOfRooms.";
        this.dataSource =
                """
                { ?data dct:subject dbc:Hotels_in_Vietnam. }
                UNION
                { ?data dct:subject dbc:Hotels_in_Hanoi. }
                UNION
                { ?data dct:subject dbc:Hotels_in_Ho_Chi_Minh_City. }
                """;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES() +
                "PREFIX dbo: <http://dbpedia.org/ontology/>";
    }

    public String createConstructBody() {
        return super.createConstructBody() +
               this.getNumberOfRooms();
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getNumberOfRooms());
    }
}
