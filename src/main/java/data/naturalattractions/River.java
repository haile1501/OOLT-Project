package data.naturalattractions;

import utils.Utils;

public class River extends NaturalAttraction {
    private final String subdivisionName;
    private final String length;

    public River(){
        super();
        this.subdivisionName = "?data dbp:subdivisionName ?subdivisionName.";
        this.length = "?data dbo:length ?length.";
        this.dataSource = "?data dct:subject dbc:Rivers_of_Vietnam.";
    }

    public String getSubdivisionName() {
        return subdivisionName;
    }

    public String getLength() {
        return length;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES() +
                "PREFIX dbo: <http://dbpedia.org/ontology/>";
    }

    @Override
    public String createConstructBody() {
        return super.createConstructBody() +
                this.getSubdivisionName() + "\n" +
                this.getLength() + "\n";
    }

    @Override
    public String createWhereBody(){
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getSubdivisionName()) + "\n" +
                Utils.createOptionalStatement(this.getLength());
    }
}
