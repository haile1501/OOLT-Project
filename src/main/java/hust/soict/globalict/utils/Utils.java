package hust.soict.globalict.utils;

import java.io.File;
import java.io.IOException;

public class Utils {
    public static String createOptionalStatement(String statement) {
        return "OPTIONAL {" + statement + "}.";
    }

    public static Boolean validateFileName(String fileName) {
        final File aFile = new File(fileName);
        boolean isValid = true;
        try {
            if (aFile.createNewFile()) {
                aFile.delete();
            }
        } catch (IOException e) {
            isValid = false;
        }
        return isValid;
    }
}
