package com.example.mynotess.ui.details;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.mynotess.R;
import com.example.mynotess.domain.Note;
import com.example.mynotess.ui.list.NotesListFragment;

public class NoteDetailsFragment extends Fragment {


    public static final String TAG = "TAG";

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


        titleNote = view.findViewById(R.id.title_note);
        noteDescription = view.findViewById(R.id.note_description);
        view.findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = getParentFragmentManager().findFragmentByTag(TAG);


                if (fragment != null) {

                    getParentFragmentManager()
                            .popBackStack();
//                            .beginTransaction()
//                            .remove(fragment)
//                            .commit();

                }


            }
        });

        if (arguments != null && arguments.containsKey(ARG_NOTE)) {
            Note notes = arguments.getParcelable(ARG_NOTE);


            updateNote(notes);
        }


    }

    private void updateNote(Note notes) {
        titleNote.setText(notes.getTitle());
        noteDescription.setText(notes.getDescription());
    }

}
