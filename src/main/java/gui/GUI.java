package gui;

import controller.NoteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    NoteController controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/noteBookGui.fxml"));
        VBox pane = fxmlLoader.load();


        Scene scene = new Scene(pane);
        primaryStage.setTitle("Jafestro Notebook");
        primaryStage.getIcons().add(new Image("note.jpg"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void init() {
        controller = new NoteController(this);
        controller.initialize();
    }
}
