package utils;

public class Utils {
    public static String createOptionalStatement(String statement) {
        return "OPTIONAL {" + statement + "}.";
    }
}
