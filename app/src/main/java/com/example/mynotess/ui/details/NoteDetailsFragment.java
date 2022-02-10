package com.example.mynotess.ui.details;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.mynotess.R;
import com.example.mynotess.domain.Note;
import com.example.mynotess.ui.list.NotesListFragment;

public class NoteDetailsFragment extends Fragment {

    private static final String ARG_NOTE = "ARG_NOTE";
    private TextView titleNote;
    private TextView noteDescription;

    public static NoteDetailsFragment newInstance(Note notes) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, notes);

        NoteDetailsFragment fragment = new NoteDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public NoteDetailsFragment() {
        super(R.layout.fragment_note_details);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle arguments = getArguments();

        getParentFragmentManager().setFragmentResultListener(NotesListFragment.NOTE_SELECTED, getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Note notes = result.getParcelable(NotesListFragment.SELECTED_NOTE_BUNDLE);

                updateNote(notes);
            }
        });

        titleNote = view.findViewById(R.id.title_note);
        noteDescription = view.findViewById(R.id.note_description);

        if (arguments != null && arguments.containsKey(ARG_NOTE)) {
            Note notes = arguments.getParcelable(ARG_NOTE);


            updateNote(notes);
        }



        // MaterialDatePicker date = view.findViewById(R.id.data);


        //date = notes.getMaterialDatePicker();


    }

    private void updateNote(Note notes) {
        titleNote.setText(notes.getTitle());
        noteDescription.setText(notes.getDescription());
    }

}
