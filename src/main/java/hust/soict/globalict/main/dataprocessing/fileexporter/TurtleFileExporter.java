package hust.soict.globalict.main.dataprocessing.fileexporter;

import org.apache.jena.rdf.model.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TurtleFileExporter implements FileExportable{
    public void exportFile(Model model, String filePath, String fileName) {
        try {
            File file = new File(filePath, fileName + ".ttl");
            model.write(new FileWriter(file), "TTL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
