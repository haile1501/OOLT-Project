package hust.soict.globalict.main.data;

import hust.soict.globalict.utils.Utils;

public class Tourism {
    private final String labelFilter;
    private final String commentFilter;
    private final String label;
    private final String comment;
    private final String subject;
    private final String name;

    protected String dataSource;

    public Tourism() {
        this.commentFilter = "FILTER(langMatches(lang(?comment), \"en\"))";
        this.labelFilter = "FILTER(langMatches(lang(?label), \"en\"))";
        this.comment = "?data rdfs:comment ?comment.";
        this.subject = "?data dct:subject ?subject.";
        this.label = "?data rdfs:label ?label.";
        this.name = "?data foaf:name ?name.";
    }

    public String getLabelFilter() {
        return labelFilter;
    }

    public String getCommentFilter() {
        return commentFilter;
    }

    public String getLabel() {
        return label;
    }

    public String getComment() {
        return comment;
    }

    public String getSubject() {
        return subject;
    }

    public String getName() {
        return name;
    }

    public String getDataSource() {
        return dataSource;
    }

    public String getPREFIXES() {
        return """
                PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
                PREFIX dct: <http://purl.org/dc/terms/>
                PREFIX dbc: <http://dbpedia.org/resource/Category:>
                PREFIX foaf: <http://xmlns.com/foaf/0.1/>
                """;
    }

    public String createConstructBody() {
        return this.getComment() +
               this.getName() +
               this.getLabel() +
               this.getSubject() + "\n";
    }


    public String createWhereBody() {
        return this.getComment() +
                this.getLabel() +
                this.getSubject() +
                this.getLabelFilter() +
                this.getCommentFilter() +
                Utils.createOptionalStatement(this.getName()) +
                this.getDataSource() + "\n";
    }

    public String createQuery() {
        return getPREFIXES() + "CONSTRUCT {" + createConstructBody() + "}" + "WHERE {" + createWhereBody() + "}";
    }
}
