package controller;

import gui.GUI;
import javafx.fxml.FXML;

import javax.swing.text.html.ListView;
import java.awt.*;

public class Controller {
    private final GUI gui;
    public Controller(GUI gui){
        this.gui = gui;
    }

    @FXML
    private TextField title;
    @FXML
    private TextArea note;
    @FXML
    private Button addButton;
    @FXML
    private ListView notes;

    public void addNote(){
        String title = this.title.getText();
        String note = this.note.getText();
        if(title.isEmpty()){
            return;
        }
        this.title.setText("");
        this.note.setText("");
        this.gui.addNoteToList(title, note);
    }
}
