package hust.soict.globalict.gui.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/main/resources/fxml/application.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setTitle("OOLT Project");
        stage.setScene(new Scene(root, 1200, 700));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
