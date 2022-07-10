package data.buildings;

import data.Tourism;

public class Building extends Tourism {

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES() +
                """                
                PREFIX georss: <http://www.georss.org/georss/>
                PREFIX dbp: <http://dbpedia.org/property/>
                """;
    }

//    public String getConstructPart() {
//        return super.getConstructPart() +
//                """
//                ?data georss:point ?point.
//                ?data dbp:location ?location.
//                ?data dbp:province ?province.
//                """;
//    }
//
//    public String getWherePart() {
//        return super.getWherePart() +
//                """
//                OPTIONAL { ?data georss:point ?point }.
//                OPTIONAL { ?data dbp:location ?location }.
//                OPTIONAL { ?data dbp:province ?province }.
//                """;
//    }
}
