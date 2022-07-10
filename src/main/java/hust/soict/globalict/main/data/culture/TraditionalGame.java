package hust.soict.globalict.main.data.culture;

public class TraditionalGame extends Culture{

    public TraditionalGame() {
        super();
        this.dataSource = "?data dct:subject dbc:Vietnamese_games.";
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
