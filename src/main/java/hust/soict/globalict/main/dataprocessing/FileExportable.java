package hust.soict.globalict.main.dataprocessing;

import org.apache.jena.rdf.model.Model;

public interface FileExportable {
    void exportFile(Model model, String filePath, String fileName);
}
