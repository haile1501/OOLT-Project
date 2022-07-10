package hust.soict.globalict.main.data.culture;

import hust.soict.globalict.utils.Utils;

public class Art extends Culture {
    private final String styles;
    private final String genre;

    public Art() {
        super();
        this.styles = "?data dbp:styles ?styles.";
        this.genre = "?data dbo:genre ?genre.";
        this.dataSource = """
                { ?data dct:subject dbc:Dance_in_Vietnam}
                UNION
                { ?data dct:subject dbc:Vietnamese_styles_of_music }
                UNION
                { ?data dct:subject dbc:Vietnamese_music }
                """;
    }

    public String getStyles() {
        return styles;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getStyles() + "\n" +
                this.getGenre() + "\n";
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getStyles()) + "\n" +
                Utils.createOptionalStatement(this.getGenre()) ;
    }
}
