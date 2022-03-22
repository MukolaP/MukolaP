package com.example.ultraproject.Notes;

import java.util.ArrayList;

public class NotesModel {
    private static final ArrayList<String> listThemes = new ArrayList<>();
    private static final ArrayList<String> listBody = new ArrayList<>();

    private static int pos;

    public static ArrayList<String> getListThemes() {
        return listThemes;
    }

    public static ArrayList<String> getListBody() {
        return listBody;
    }

    public static void setPos(int pos) {
        NotesModel.pos = pos;
    }

    public static int getPos() { return pos; }
}
