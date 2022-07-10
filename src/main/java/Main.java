import data.culture.*;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;


public class Main {

    public static void main(String[] args) {
        TraditionalGame pagoda = new TraditionalGame();

        Query query = QueryFactory.create(pagoda.createQuery());
        System.out.println(query);

        try(QueryExecution qexec = QueryExecution.service("http://dbpedia.org/sparql").query(query).build()) {
            Model model = qexec.execConstruct();
            model.write(System.out,"TURTLE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
