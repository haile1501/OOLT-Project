package hust.soict.globalict.main.data.naturalattractions;


import hust.soict.globalict.utils.Utils;

public class Island extends NaturalAttraction {
    private final String areaTotalKm;

    public Island(){
        super();
        this.areaTotalKm = "?data dbp:areaTotalKm ?areaTotalKm";
        this.dataSource = """
                { ?data dct:subject dbc:Islands_of_Vietnam. }
                UNION
                { ?data dct:subject dbc:Archipelagoes_of_Vietnam. }
                """;
    }

    public String getAreaTotalKm() {
        return areaTotalKm;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    @Override
    public String createConstructBody() {
        return super.createConstructBody() +
                this.getAreaTotalKm() + "\n";
    }

    @Override
    public String createWhereBody(){
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getAreaTotalKm());
    }
}
