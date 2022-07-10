package hust.soict.globalict.main.data.naturalattractions;

import hust.soict.globalict.utils.Utils;

public class Cave extends NaturalAttraction {
    private final String length;
    private final String depth;
    private final String geology;

    public Cave(){
        super();
        this.length = "?data dbp:length ?length.";
        this.depth = "?data dbp:depth ?depth.";
        this.geology = "?data dbp:geology ?geology.";
        this.dataSource = "?data dct:subject dbc:Caves_of_Vietnam.";
    }

    public String getLength() {
        return length;
    }

    public String getDepth() {
        return depth;
    }

    public String getGeology() {
        return geology;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    @Override
    public String createConstructBody(){
        return super.createConstructBody() + "\n" +
                this.getLength() + "\n" +
                this.getDepth() + "\n" +
                this.getGeology() + "\n";
    }

    @Override
    public String createWhereBody() {
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getDepth()) + "\n" +
                Utils.createOptionalStatement(this.getLength()) + "\n" +
                Utils.createOptionalStatement(this.getGeology());
    }
}
