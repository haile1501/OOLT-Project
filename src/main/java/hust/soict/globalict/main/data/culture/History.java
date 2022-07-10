package hust.soict.globalict.main.data.culture;

import hust.soict.globalict.utils.Utils;

public class History extends Culture{

    private final String date;
    private final String place;
    private final String result;
    public History() {
        super();
        this.date = "?data dbo:date ?date.";
        this.place = "?data dbo:place ?place.";
        this.result = "?data dbo:result ?result.";
        this.dataSource = """
                 OPTIONAL { ?data dbo:abstract ?abstract }.
                { ?data dct:subject dbc:Military_history_of_Vietnam}
                UNION
                { ?data dct:subject dbc:Economic_history_of_Vietnam}
                UNION
                { ?data dct:subject dbc:Social_history_of_Vietnam}
                """;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getDate() + "\n" +
                this.getPlace() + "\n" +
                this.getResult() + "\n";
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getDate()) + "\n" +
                Utils.createOptionalStatement(this.getPlace()) + "\n" +
                Utils.createOptionalStatement(this.getResult());
    }
}
