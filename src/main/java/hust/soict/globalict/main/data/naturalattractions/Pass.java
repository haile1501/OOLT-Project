package hust.soict.globalict.main.data.naturalattractions;

import hust.soict.globalict.utils.Utils;

public class Pass extends NaturalAttraction {
    private final String range;

    public Pass(){
        super();
        this.range = "?data dbp:range ?range";
        this.dataSource =  "?data dct:subject dbc:Mountain_passes_of_Vietnam.";
    }

    public String getRange() {
        return range;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    @Override
    public String createConstructBody() {
        return super.createConstructBody() +
                this.getRange() + "\n";
    }

    @Override
    public String createWhereBody(){
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getRange());
    }
}
