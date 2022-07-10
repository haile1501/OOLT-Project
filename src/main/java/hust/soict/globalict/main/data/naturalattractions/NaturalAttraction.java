package hust.soict.globalict.main.data.naturalattractions;

import hust.soict.globalict.main.data.Tourism;
import hust.soict.globalict.utils.Utils;

public class NaturalAttraction extends Tourism {

    private final String point;
    private final String location;
    private final String province;

    public NaturalAttraction(){
        super();
        this.point = "?data georss:point ?point.";
        this.location = "?data dbp:location ?location.";
        this.province = "?data dbp:province ?province.";
    }

    public String getPoint() {
        return point;
    }

    public String getLocation() {
        return location;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES() +
                """                
                PREFIX georss: <http://www.georss.org/georss/>
                PREFIX dbp: <http://dbpedia.org/property/>
                """;
    }

    @Override
    public String createConstructBody(){
        return super.createConstructBody() +
                this.getPoint() + "\n" +
                this.getLocation() + "\n" +
                this.getProvince() + "\n";
    }

    @Override
    public String createWhereBody(){
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getPoint()) + "\n" +
                Utils.createOptionalStatement(this.getLocation()) + "\n" +
                Utils.createOptionalStatement(this.getProvince());
    }

}
