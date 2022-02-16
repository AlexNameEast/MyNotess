package com.example.mynotess.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import android.os.Bundle;

import com.example.mynotess.R;
import com.example.mynotess.domain.Note;
import com.example.mynotess.ui.details.NoteDetailsFragment;
import com.example.mynotess.ui.list.NotesListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().setFragmentResultListener(NotesListFragment.NOTE_SELECTED, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Note note = result.getParcelable(NotesListFragment.SELECTED_NOTE_BUNDLE);

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, NoteDetailsFragment.newInstance(note), NoteDetailsFragment.TAG)
                        //.replace(R.id.container, NoteDetailsFragment.newInstance(note))
                        .addToBackStack("")
                        .commit();
            }
        });
    }
}