package com.example.mynotess.ui.details;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.mynotess.R;
import com.example.mynotess.domain.Note;
import com.example.mynotess.ui.MainActivity;
import com.example.mynotess.ui.NavDrawable;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        if (requireActivity() instanceof NavDrawable) {
            ((NavDrawable) requireActivity()).setAppBar(toolbar);
        }
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_share) {
                    Toast.makeText(requireContext(), "Share", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        Bundle arguments = getArguments();


        titleNote = view.findViewById(R.id.title_note);
        noteDescription = view.findViewById(R.id.note_description);

        titleNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), view);

                requireActivity().getMenuInflater().inflate(R.menu.menu_title_pop_up, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.action_search) {
                            Toast.makeText(requireContext(), "Search", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        if (item.getItemId() == R.id.action_copy_to_clipboard) {
                            Toast.makeText(requireContext(), "Copy to Clipboard", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        return false;
                    }
                });

                popupMenu.show();
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



