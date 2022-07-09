package data.buildings;

public class Church extends Building{

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String getConstructPart() {
        return super.getConstructPart() +
                """                        
                }
                """;
    }

    public String getWherePart() {
        return super.getWherePart() +
                """               
                { ?data dct:subject dbc:Roman_Catholic_cathedrals_in_Vietnam }
                UNION
                { ?data dct:subject dbc:20th-century_Roman_Catholic_church_buildings_in_Vietnam }
                UNION
                { ?data dct:subject dbc:19th-century_Roman_Catholic_church_buildings_in_Vietnam }
                }
                """;
    }
}
