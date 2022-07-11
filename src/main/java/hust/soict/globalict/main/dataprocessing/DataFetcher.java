package hust.soict.globalict.main.dataprocessing;

import hust.soict.globalict.main.data.Tourism;
import hust.soict.globalict.main.dataprocessing.fileexporter.FileExportable;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;

public class DataFetcher {
    private final Tourism tourism;
    private final String fileName;
    private final String filePath;

    private final FileExportable fileExporter;

    public DataFetcher(Tourism tourism, String filePath, String fileName, FileExportable fileExporter) {
        this.tourism = tourism;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileExporter = fileExporter;
    }

    private String createQueryString() {
        return tourism.createQuery();
    }

    public void fetch() {
        Query query = QueryFactory.create(this.createQueryString());

        try (QueryExecution queryExecution = QueryExecution.service("http://dbpedia.org/sparql").query(query).build()) {
            fileExporter.exportFile(queryExecution.execConstruct(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
