package hust.soict.globalict.main.data.culture;

public class Costume extends Culture{

    public Costume() {
        super();
        this.dataSource = """
                { ?data dct:subject dbc:Vietnamese_clothing}
                UNION
                { ?data dct:subject dbc:Vietnamese_headgear }
                """;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody();
    }

    public String createWhereBody() {
        return super.createWhereBody();
    }
}
