package com.example.mynotess.ui.list;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mynotess.R;
import com.example.mynotess.domain.Note;
import com.example.mynotess.domain.NotesRepositoryImp;
import com.example.mynotess.ui.details.NoteDetailsFragment;

import java.util.List;

public class NotesListFragment extends Fragment implements NotesListView {

    public static final String NOTE_SELECTED = "NOTE_SELECTED";
    public static final String SELECTED_NOTE_BUNDLE = "SELECTED_NOTE_BUNDLE";

    private LinearLayout containerList;
    private NotesListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NotesListPresenter(NotesRepositoryImp.getINSTANCE(), this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        containerList = view.findViewById(R.id.container_list);
        presenter.requestNotes();
    }

    @Override
    public void showNotes(List<Note> notes) {

        for (Note note : notes) {

            View itemView = getLayoutInflater().inflate(R.layout.item_note, containerList, false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                        Bundle bundle = new Bundle();
                        bundle.putParcelable(SELECTED_NOTE_BUNDLE, note);

                        getParentFragmentManager()
                                .setFragmentResult(NOTE_SELECTED, bundle);

                }
            });

            TextView name = itemView.findViewById(R.id.name);
            name.setText(note.getTitle());

            ImageView coatOfArms = itemView.findViewById(R.id.coat_of_arms);
            coatOfArms.setImageResource(note.getImg());

            containerList.addView(itemView);
        }

    }
}
