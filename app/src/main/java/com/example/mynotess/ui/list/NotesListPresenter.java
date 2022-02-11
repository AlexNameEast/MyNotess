package com.example.mynotess.ui.list;

import com.example.mynotess.domain.Note;
import com.example.mynotess.domain.NotesRepository;

import org.w3c.dom.Node;

import java.util.List;

public class NotesListPresenter {

    private NotesRepository repository;
    private NotesListView view;

    public NotesListPresenter(NotesRepository repository, NotesListView view) {
        this.repository = repository;
        this.view = view;
    }

    public void requestNotes() {

        List<Note> notes = repository.getNotes();
        view.showNotes(notes);
        
    }
}
