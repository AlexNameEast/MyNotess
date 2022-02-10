package com.example.mynotess.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.mynotess.R;
import com.example.mynotess.domain.Note;

public class NoteDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_NOTE = "EXTRA_NOTE";

    public static void show(Context context, Note note) {

        Intent intent = new Intent(context, NoteDetailsActivity.class);
        intent.putExtra(EXTRA_NOTE, note);

        context.startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detailss);

        if (savedInstanceState == null) {

            Note notes = getIntent().getParcelableExtra(EXTRA_NOTE);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, NoteDetailsFragment.newInstance(notes))
                    .commit();
        }
    }
}