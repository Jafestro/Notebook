package model;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Note> notes;

    public Notebook() {
        notes = new ArrayList<Note>();
    }

    public void addNote(String title, String note) {
        notes.add(new Note(title, note));
    }

    public void removeNote(int index) {
        notes.remove(index);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }
}
