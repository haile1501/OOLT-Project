package data.buildingsandstructures;

import utils.Utils;

public class Mausoleum extends BuildingAndStructure{
    private final String dataSource;
    private final String architectureStyle;

    public Mausoleum() {
        super();
        this.dataSource = "?data dct:subject dbc:Tombs_in_Vietnam.";
        this.architectureStyle = "?data dbp:architectureStyle ?architectureStyle.";
    }

    public String getDataSource() {
        return dataSource;
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
               this.getDataSource() + "\n" +
               Utils.createOptionalStatement(this.getArchitectureStyle());
    }
}
