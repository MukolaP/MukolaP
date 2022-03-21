package com.example.ultraproject.Notes;

import java.util.ArrayList;

public class NotesController {
    private static ArrayList<String> arrayList = new ArrayList<>();

    public static ArrayList<String> getArrayList() {
        return arrayList;
    }

    public static void setArrayList(ArrayList<String> arrayList) {
        NotesController.arrayList = arrayList;
    }
}
