package com.example.ultraproject.Notes;

import java.util.ArrayList;

public class NotesController {
    private static ArrayList<String> arrayList_themes = new ArrayList<>();
    private static ArrayList<String> arrayList_body = new ArrayList<>();

    private static int pos;

    public static ArrayList<String> getArrayList_themes() {
        return arrayList_themes;
    }

    public static ArrayList<String> getArrayList_body() { return arrayList_body; }

    public static void setPos(int pos) {
        NotesController.pos = pos;
    }

    public static int getPos() { return pos; }
}
