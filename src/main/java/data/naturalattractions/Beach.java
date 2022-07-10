package data.naturalattractions;

public class Beach extends NaturalAttraction {

    public Beach(){
        super();
        this.dataSource= "?data dct:subject dbc:Beaches_of_Vietnam.";
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    @Override
    public String createConstructBody() {
        return super.createConstructBody();
    }

    @Override
    public String createWhereBody(){
        return super.createWhereBody();
    }
}
