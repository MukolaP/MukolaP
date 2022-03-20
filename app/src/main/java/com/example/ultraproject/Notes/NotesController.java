package com.example.ultraproject.Notes;

import java.util.ArrayList;

public class NotesController {

    private ArrayList<String> themes = new ArrayList<>();

    public void setThemes(ArrayList<String> themes) {
        this.themes = themes;
    }

    public ArrayList<String> getThemes() {
        return themes;
    }

    public void addThemes(String string) {
        themes.add(string);
    }
}

