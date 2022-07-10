package data.culture;

import utils.Utils;

public class Religion extends Culture{

    private final String religion;

    public Religion() {
        super();
        this.religion = "?data dbp:religion ?religion.";
        this.dataSource = """
                { ?data dct:subject dbc:Vietnamese_folk_religion}
                UNION
                { ?data dct:subject dbc:Vietnamese_mythology }
                UNION
                { ?data dct:subject dbc:Religion_in_Vietnam. }
                """;
    }

    public String getReligion() {
        return religion;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getReligion() + "\n";
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getReligion());
    }
}
