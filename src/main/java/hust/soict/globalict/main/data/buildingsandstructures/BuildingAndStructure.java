package hust.soict.globalict.main.data.buildingsandstructures;

import hust.soict.globalict.main.data.Tourism;
import hust.soict.globalict.utils.Utils;

public class BuildingAndStructure extends Tourism {
    private final String point;
    private final String location;

    public BuildingAndStructure() {
        super();
        this.point = "?data georss:point ?point.";
        this.location = "?data dbp:location ?location.";
    }

    public String getPoint() {
        return point;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES() +
                """
                PREFIX georss: <http://www.georss.org/georss/>
                PREFIX dbp: <http://dbpedia.org/property/>
                """;
    }

    public String createConstructBody() {
        return super.createConstructBody() +
               this.getPoint() +
               this.getLocation();
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getPoint()) +
                Utils.createOptionalStatement(this.getLocation());
    }
}
