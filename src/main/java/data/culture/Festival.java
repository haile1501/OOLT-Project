package data.culture;

import utils.Utils;

public class Festival extends Culture {
    private final String date;
    private final String frequency;
    private final String meaning;
    private final String significance;

    public Festival() {
        super();
        this.date = "?data dbp:date ?date.";
        this.meaning = "?data dbo:meaning ?meaning.";
        this.frequency = "?data dbp:frequency ?frequency.";
        this.significance = "?data dbp:significance ?significance";
        this.dataSource = """
                { ?data dct:subject dbc:Public_holidays_in_Vietnam}
                UNION
                { ?data dct:subject dbc:Events_in_Vietnam }
                """;
    }

    public String getDate() {
        return date;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getSignificance() {
        return significance;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getDate() + "\n" +
                this.getFrequency() + "\n" +
                this.getMeaning() + "\n" +
                this.getSignificance() + "\n";
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getDate()) + "\n" +
                Utils.createOptionalStatement(this.getFrequency()) + "\n" +
                Utils.createOptionalStatement(this.getMeaning()) + "\n" +
                Utils.createOptionalStatement(this.getSignificance());
    }

}
