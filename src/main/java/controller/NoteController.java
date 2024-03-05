package controller;

import gui.GUI;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import model.Note;
import model.Notebook;

import java.time.LocalDate;

public class NoteController {
    private final GUI gui;
    private Notebook notebook;

    private int noteIndex;
    public NoteController(){
        this.gui = null;
    }
    public NoteController(GUI gui){
        this.gui = gui;
    }

    @FXML
    private TextField title;
    @FXML
    private TextArea note;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;
    @FXML
    private ListView<String> notes = new ListView<>();

    public void add(){
        String title = this.title.getText();
        String note = this.note.getText();
        notebook.addNote(title, note);
        if(title.isEmpty()){
            return;
        }
        this.title.setText("");
        this.note.setText("");
        System.out.println(title + " " + note);
        notes.getItems().add(title + " " + LocalDate.now());
    }

    public void initialize(){
        this.notebook = new Notebook();
        final boolean[] empty1 = new boolean[1];
        notes.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                ListCell<String> cell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item);
                        }
                        empty1[0] = empty;
                    }
                };
                // Add click listener to each cell
                cell.setOnMouseClicked(event -> {
                    if (!empty1[0] && cell.getIndex() >= 0) {
                        int clickedIndex = cell.getIndex();
                        handleNoteClick(clickedIndex); // Call the defined method
                    }
                });
                return cell;
            }
        });

    }

    public void handleNoteClick(int index) {
        if (index >= 0 && index < notebook.getNotes().size()) {
            noteIndex = index;
            this.title.setText(notebook.getNotes().get(noteIndex).getTitle());
            this.note.setText(notebook.getNotes().get(noteIndex).getNote());
            System.out.println("Clicked note: " + noteIndex);
        }
    }

    public void deleteNote(){
        notebook.removeNote(noteIndex);
        notes.getItems().remove(noteIndex);
    }

    public void editNote(){
        Note note = notebook.getNotes().get(noteIndex);
        note.setTitle(title.getText());
        note.setNote(this.note.getText());
        notes.getItems().set(noteIndex, note.getTitle() + " " + LocalDate.now());
        notebook.getNotes().set(noteIndex, note);
    }

    public ListView<String> getNotes() {
        return notes;
    }
}
