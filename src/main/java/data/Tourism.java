package data;

public class Tourism {
    public String getPREFIXES() {
        return """                
                PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
                PREFIX dct: <http://purl.org/dc/terms/>
                PREFIX dbc: <http://dbpedia.org/resource/Category:>
                PREFIX foaf: <http://xmlns.com/foaf/0.1/>
                PREFIX dbr: <http://dbpedia.org/resource/>
                """;
    }

    public String getConstructPart() {
        return """
                CONSTRUCT {
                ?data rdfs:label ?label.                
                ?data rdfs:comment ?comment.
                ?data dct:subject ?subject.
                ?data foaf:name ?name.
                """;
    }

    public String getWherePart() {
        return """
                WHERE {
                ?data rdfs:label ?label.
                FILTER(langMatches(lang(?label), "en"))                
                ?data rdfs:comment ?comment.
                FILTER(langMatches(lang(?comment), "en"))
                OPTIONAL { ?data foaf:name ?name }
                ?data dct:subject ?subject.
                """;
    }



}
