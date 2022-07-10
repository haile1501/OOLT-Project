package hust.soict.globalict.main.dataprocessing;

import org.apache.jena.rdf.model.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExporter {

    public void exportFile(Model model, String fileName) {
        try {
            File file = new File("src/main/resources/storage", fileName + ".ttl");
            model.write(new FileWriter(file), "TTL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
