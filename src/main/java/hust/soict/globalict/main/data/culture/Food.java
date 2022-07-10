package hust.soict.globalict.main.data.culture;

import hust.soict.globalict.utils.Utils;

public class Food extends Culture {
    private final String type;
    private final String ingredient;
    private final String region;

    public Food() {
        super();
        this.type = "?data dbo:type ?type.";
        this.ingredient = "?data dbo:ingredient ?ingredient.";
        this.region = "?data dbo:region ?region.";
        this.dataSource = """
                { ?data dct:subject dbc:Vietnamese_pork_dishes}
                UNION
                { ?data dct:subject dbc:Vietnamese_seafood_dishes }
                UNION
                { ?data dct:subject dbc:Street_food_in_Vietnam }
                UNION
                { ?data dct:subject dbc:Vietnamese_cuisine}
                """;
    }

    public String getType() {
        return type;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String getPREFIXES() {
        return super.getPREFIXES();
    }

    public String createConstructBody() {
        return super.createConstructBody() +
                this.getIngredient() + "\n" +
                this.getRegion() + "\n" +
                this.getType() + "\n";
    }

    public String createWhereBody() {
        return super.createWhereBody() +
                Utils.createOptionalStatement(this.getIngredient()) + "\n" +
                Utils.createOptionalStatement(this.getRegion()) + "\n" +
                Utils.createOptionalStatement(this.getType()) + "\n";
    }

}
