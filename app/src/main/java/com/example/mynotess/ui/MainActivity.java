package com.example.mynotess.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mynotess.R;
import com.example.mynotess.domain.Note;
import com.example.mynotess.ui.details.NoteDetailsFragment;
import com.example.mynotess.ui.list.NotesListFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavDrawable {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawer);

        NavigationView navigationView = findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_notes) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container_list, new NotesListFragment())
                            .commit();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                if (item.getItemId() == R.id.empty_fragment) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container_list, new Fragment())
                            .commit();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.about_app) {

                    Toast.makeText(MainActivity.this, "About App", Toast.LENGTH_SHORT).show();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.action_settings_notes) {

                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                return false;
            }
        });


        getSupportFragmentManager()
                .setFragmentResultListener(NotesListFragment.NOTE_SELECTED, this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        Note note = result.getParcelable(NotesListFragment.SELECTED_NOTE_BUNDLE);

                        getSupportFragmentManager()
                                .beginTransaction()
                                //.add(R.id.fragment_container_list, NoteDetailsFragment.newInstance(note), NoteDetailsFragment.TAG)
                                .replace(R.id.fragment_container_list, NoteDetailsFragment.newInstance(note), NoteDetailsFragment.TAG)
                                .addToBackStack("")
                                .commit();
                    }
                });
    }

    @Override
    public void setAppBar(Toolbar toolbar) {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer
        );

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
    }
}