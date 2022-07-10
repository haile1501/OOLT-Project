package hust.soict.globalict.main.dataprocessing;


import hust.soict.globalict.main.data.buildingsandstructures.*;
import hust.soict.globalict.main.data.culture.*;
import hust.soict.globalict.main.data.naturalattractions.*;
import hust.soict.globalict.main.data.people.*;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;

public class DataFetcher {
    private final String category;
    private final String fileName;

    public DataFetcher(String category, String fileName) {
        this.category = category;
        this.fileName = fileName;
    }

    private String createQueryString() {
        String queryString = null;
        switch (category) {
            case "Airport" -> queryString = new Airport().createQuery();
            case "Amusement park" -> queryString = new AmusementPark().createQuery();
            case "Bridge" -> queryString = new Bridge().createQuery();
            case "Church" -> queryString = new Church().createQuery();
            case "Dam" -> queryString = new Dam().createQuery();
            case "Hotel and resort" -> queryString = new HotelAndResort().createQuery();
            case "Mausoleum" -> queryString = new Mausoleum().createQuery();
            case "Monument" -> queryString = new Monument().createQuery();
            case "Museum" -> queryString = new Museum().createQuery();
            case "Pagoda" -> queryString = new Pagoda().createQuery();
            case "Art" -> queryString = new Art().createQuery();
            case "Costume" -> queryString = new Costume().createQuery();
            case "Ethnic group" -> queryString = new EthnicGroup().createQuery();
            case "Festival" -> queryString = new Festival().createQuery();
            case "Food" -> queryString = new Food().createQuery();
            case "History" -> queryString = new History().createQuery();
            case "Religion" -> queryString = new Religion().createQuery();
            case "Traditional game" -> queryString = new TraditionalGame().createQuery();
            case "Beach" -> queryString = new Beach().createQuery();
            case "Cave" -> queryString = new Cave().createQuery();
            case "Island" -> queryString = new Island().createQuery();
            case "Lake" -> queryString = new Lake().createQuery();
            case "National park" -> queryString = new NationalPark().createQuery();
            case "Pass" -> queryString = new Pass().createQuery();
            case "Astronaut" -> queryString = new Astronaut().createQuery();
            case "Businessman" -> queryString = new Businessman().createQuery();
            case "Engineer" -> queryString = new Engineer().createQuery();
            case "King" -> queryString = new King().createQuery();
            case "Lawyer" -> queryString = new Lawyer().createQuery();
            case "Politician" -> queryString = new Politician().createQuery();
        }

        return queryString;
    }

    public void fetch() {
        Query query = QueryFactory.create(this.createQueryString());

        try (QueryExecution queryExecution = QueryExecution.service("http://dbpedia.org/sparql").query(query).build()) {
            FileExporter fileExporter = new FileExporter();
            fileExporter.exportFile(queryExecution.execConstruct(), fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
