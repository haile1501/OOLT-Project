package hust.soict.globalict.main.dataprocessing.fileexporter;

import org.apache.jena.rdf.model.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RdfXmlFileExporter implements FileExportable{
    public void exportFile(Model model, String filePath, String fileName) {
        try {
            File file = new File(filePath, fileName + ".rdf");
            model.write(new FileWriter(file), "RDF/XML");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
