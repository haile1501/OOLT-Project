package hust.soict.globalict.main.data.buildingsandstructures;

import hust.soict.globalict.utils.Utils;

public class Mausoleum extends BuildingAndStructure{
    private final String architectureStyle;

    public Mausoleum() {
        super();
        this.dataSource = "?data dct:subject dbc:Tombs_in_Vietnam.";
        this.architectureStyle = "?data dbp:architectureStyle ?architectureStyle.";
    }

    public String getArchitectureStyle() {
        return architectureStyle;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
               this.getArchitectureStyle();
    }

    public String createWhereBody() {
        return super.createWhereBody() +
               Utils.createOptionalStatement(this.getArchitectureStyle());
    }
}
