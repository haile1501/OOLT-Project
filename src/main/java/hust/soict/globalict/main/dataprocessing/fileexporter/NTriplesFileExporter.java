package hust.soict.globalict.main.dataprocessing.fileexporter;

import org.apache.jena.rdf.model.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NTriplesFileExporter implements FileExportable{
    public void exportFile(Model model, String filePath, String fileName) {
        try {
            File file = new File(filePath, fileName + ".nt");
            model.write(new FileWriter(file), "N-TRIPLES");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
