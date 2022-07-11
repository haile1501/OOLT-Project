package hust.soict.globalict.gui.controller;

import hust.soict.globalict.main.data.Tourism;
import hust.soict.globalict.main.data.buildingsandstructures.*;
import hust.soict.globalict.main.data.people.*;
import hust.soict.globalict.main.data.culture.*;
import hust.soict.globalict.main.data.naturalattractions.*;

import hust.soict.globalict.main.dataprocessing.DataFetcher;
import hust.soict.globalict.main.dataprocessing.fileexporter.*;
import hust.soict.globalict.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import javax.swing.JOptionPane;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Controller implements Initializable{

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ChoiceBox<String> topicBox;
    @FXML
    private ChoiceBox<String> categoryBox;

    @FXML
    private Button btnQuery;

    @FXML
    private TextField fileNameField;

    @FXML
    private TextArea previewTextArea;
    @FXML
    private Button btnBrowse;
    @FXML
    private Label filePathLabel;
    @FXML
    private Label currentFileDisplay;
    @FXML
    private RadioButton radio1, radio2, radio3, radio4;
    private String filePath = "src/main/resources/storage/";
    private String formatString = "Turtle (.ttl)";
    private String extension = ".ttl";

    private final String[] topics = {"Buildings and Structures", "Natural Attractions", "Culture", "People"};
    private final String[] buildingsAndStructures = {"Airport", "Amusement park", "Bridge", "Church", "Dam", "Hotel and Resort", "Mausoleum", "Monument", "Pagoda", "Museum"};
    private final String[] culture = {"Art", "Costume", "Ethnic group", "Festival", "Food", "History", "Religion", "Traditional game"};
    private final String[] naturalAttractions = {"Beach", "Cave", "Island", "Lake", "Mountain", "National park", "Pass", "River"};
    private final String[] people = {"Astronaut", "Businessman", "Engineer", "King", "Lawyer", "Politician"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topicBox.getItems().addAll(topics);
        topicBox.setValue("Choose topic");
        topicBox.setOnAction(this::setCategory);
        categoryBox.setValue("Choose category");
        btnQuery.setOnAction(this::executeQuery);
        btnBrowse.setOnAction(this::browseFolder);
        filePathLabel.setText("Path: " + filePath);
        radio1.setOnAction(this::chooseFormat1);
        radio2.setOnAction(this::chooseFormat2);
        radio3.setOnAction(this::chooseFormat3);
        radio4.setOnAction(this::chooseFormat4);
    }

    public void setCategory(ActionEvent actionEvent) {
        String topic = topicBox.getValue();
        switch (topic) {
            case "Buildings and Structures" -> categoryBox.getItems().setAll(buildingsAndStructures);
            case "Natural Attractions" -> categoryBox.getItems().setAll(naturalAttractions);
            case "Culture" -> categoryBox.getItems().setAll(culture);
            case "People" -> categoryBox.getItems().setAll(people);
        }

        categoryBox.setValue("Choose category");
    }

    public void executeQuery(ActionEvent actionEvent) {
        String category = categoryBox.getValue();
        String topic = topicBox.getValue();
        String fileName = fileNameField.getText();
        Tourism tourism = null;

        if (category.equals("Choose category") || topic.equals("Choose topic")) {
            JOptionPane.showMessageDialog(null, "Please choose both topic and category.");
            return;
        }

        switch (category) {
            case "Airport" -> tourism = new Airport();
            case "Amusement park" -> tourism = new AmusementPark();
            case "Bridge" -> tourism = new Bridge();
            case "Church" -> tourism = new Church();
            case "Dam" -> tourism = new Dam();
            case "Hotel and Resort" -> tourism = new HotelAndResort();
            case "Mausoleum" -> tourism = new Mausoleum();
            case "Monument" -> tourism = new Monument();
            case "Museum" -> tourism = new Museum();
            case "Pagoda" -> tourism = new Pagoda();
            case "Art" -> tourism = new Art();
            case "Costume" -> tourism = new Costume();
            case "Ethnic group" -> tourism = new EthnicGroup();
            case "Festival" -> tourism = new Festival();
            case "Food" -> tourism = new Food();
            case "History" -> tourism = new History();
            case "Religion" -> tourism = new Religion();
            case "Traditional game" -> tourism = new TraditionalGame();
            case "Beach" -> tourism = new Beach();
            case "Cave" -> tourism = new Cave();
            case "Island" -> tourism = new Island();
            case "Lake" -> tourism = new Lake();
            case "National park" -> tourism = new NationalPark();
            case "Mountain" -> tourism = new Mountain();
            case "River" -> tourism = new River();
            case "Pass" -> tourism = new Pass();
            case "Astronaut" -> tourism = new Astronaut();
            case "Businessman" -> tourism = new Businessman();
            case "Engineer" -> tourism = new Engineer();
            case "King" -> tourism = new King();
            case "Lawyer" -> tourism = new Lawyer();
            case "Politician" -> tourism = new Politician();
        }



        if (fileName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please input the file name.");
            return;
        } else if (Utils.validateFileName(fileName)) {
            FileExportable fileExporter = null;

            switch (formatString) {
                case "Turtle (.ttl)" -> {
                    fileExporter = new TurtleFileExporter();
                    extension = ".ttl";
                }
                case "JSON-LD (.jsonld)" -> {
                    fileExporter = new JsonLdFileExporter();
                    extension = ".jsonld";
                }
                case "N-Triples (.nt)" -> {
                    fileExporter = new NTriplesFileExporter();
                    extension = ".nt";
                }
                case "RDF/XML (.rdf)" -> {
                    fileExporter = new RdfXmlFileExporter();
                    extension = ".rdf";
                }
            }

            DataFetcher dataFetcher = new DataFetcher(tourism, filePath, fileName, fileExporter);
            dataFetcher.fetch();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid file name.");
            return;
        }

        previewTextArea.clear();
        fileNameField.clear();
        currentFileDisplay.setText(fileName + extension);

        try {
            Scanner input = new Scanner(new File(filePath + fileName + extension));
            while (input.hasNext()) {
                previewTextArea.appendText(input.nextLine() + '\n');
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void browseFolder(ActionEvent actionEvent) {
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File ("src/main/resources/storage/"));
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        File file = directoryChooser.showDialog(stage);

        if (file != null) {
            filePath = file.getAbsolutePath() + "/";
            filePathLabel.setText("Path: " + filePath);
        }
    }

    public void chooseFormat1(ActionEvent actionEvent) {
        formatString = radio1.getText();
    }
    public void chooseFormat2(ActionEvent actionEvent) {
        formatString = radio2.getText();
    }
    public void chooseFormat3(ActionEvent actionEvent) {
        formatString = radio3.getText();
    }
    public void chooseFormat4(ActionEvent actionEvent) {
        formatString = radio4.getText();
    }
}

