package hust.soict.globalict.gui;

import hust.soict.globalict.main.dataprocessing.DataFetcher;
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
    private String filePath = "src/main/resources/storage/";

    private final String[] topics = {"Buildings and Structures", "Natural Attractions", "Culture", "People"};
    private final String[] buildingsAndStructures = {"Airport", "Amusement park", "Bridge", "Church", "Dam", "Hotel And Resort", "Mausoleum", "Monument", "Pagoda", "Museum"};
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

        if (category.equals("Choose category") || topic.equals("Choose topic")) {
            JOptionPane.showMessageDialog(null, "Please choose both topic and category.");
            return;
        }

        if (fileName.length() == 0) {
            fileName = Utils.createFileName(category.toLowerCase());
            fileNameField.setText(fileName);
            DataFetcher dataFetcher = new DataFetcher(category, filePath, fileName);
            dataFetcher.fetch();
        } else if (Utils.validateFileName(fileName)) {
            DataFetcher dataFetcher = new DataFetcher(category, filePath, fileName);
            dataFetcher.fetch();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid file name.");
            return;
        }

        previewTextArea.clear();
        try {
            Scanner input = new Scanner(new File(filePath + fileName + ".ttl"));
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
}
