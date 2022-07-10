package data.culture;

import utils.Utils;

public class EthnicGroup extends Culture{
    private final String language;
    private final String religion;
    private final String population;

    public EthnicGroup() {
        super();
        this.dataSource = "?data dct:subject dbc:Ethnic_groups_in_Vietnam.";
        this.language = "?data dbo:language ?language.";
        this.religion = "?data dbo:religion ?religion.";
        this.population = "?data dbp:population ?population.";
    }

    public String getLanguage() {
        return language;
    }

    public String getReligion() {
        return religion;
    }

    public String getPopulation() {
        return population;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getLanguage() + "\n" +
                this.getPopulation() + "\n" +
                this.getReligion() + "\n";
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getLanguage()) + "\n" +
                Utils.createOptionalStatement(this.getReligion()) + "\n" +
                Utils.createOptionalStatement(this.getPopulation());
    }
}
