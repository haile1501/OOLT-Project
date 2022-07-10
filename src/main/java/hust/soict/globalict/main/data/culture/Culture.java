package hust.soict.globalict.main.data.culture;

import hust.soict.globalict.main.data.Tourism;

public class Culture extends Tourism{

    private final String abstractProp;

    public Culture() {
        super();
        this.abstractProp = "?data dbo:abstract ?abstract.";
    }

    public String getAbstractProp() {
        return abstractProp;
    }



    @Override
    public String getPREFIXES() {
        return super.getPREFIXES() +
                """                
                PREFIX dbp: <http://dbpedia.org/property/>
                PREFIX dbo: <http://dbpedia.org/ontology/>
                """;
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getAbstractProp();
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                this.getAbstractProp();
    }
}

