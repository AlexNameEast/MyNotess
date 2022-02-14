package com.example.mynotess.domain;

import com.example.mynotess.R;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotesRepositoryImp implements NotesRepository {


    private static final NotesRepository INSTANCE = new NotesRepositoryImp();

    public static NotesRepository getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        notes.add(new Note(UUID.randomUUID().toString(), R.drawable.ic_baseline_notes_24, "Note 1", "Himenaeos eleifend vel vulputate molestie hac nam bibendum tincidunt tristique vivamus, blandit posuere efficitur nisl lobortis nostra magnis orci laoreet, sapien massa aenean condimentum ultrices class varius netus rutrum. Volutpat sed nisl tellus mauris dignissim pulvinar mattis duis lacus nostra ad rutrum at montes, tortor sagittis consectetur class euismod vulputate risus dapibus convallis ultrices fusce facilisi turpis. Vivamus pulvinar risus ultrices morbi fermentum ridiculus dignissim, nulla porttitor tincidunt sagittis velit vitae facilisi fringilla, dui congue feugiat metus nisi class. Nullam iaculis scelerisque dictumst suspendisse interdum amet porta ipsum ad mattis porttitor, sagittis litora varius imperdiet sollicitudin suscipit luctus maximus rutrum. Tristique sem quisque mus sagittis torquent etiam enim tempor semper, dignissim fames convallis quis penatibus eget venenatis aenean, class laoreet ligula felis nisl vitae nulla potenti. Libero nisi enim sagittis dictum aenean posuere taciti conubia augue fermentum, ultrices sapien morbi porta euismod nibh finibus interdum malesuada eget, volutpat suspendisse aliquet consequat bibendum semper pellentesque integer hendrerit. Ridiculus elementum mauris sodales tortor sem dolor, eleifend aptent auctor lacus et duis, lobortis libero lorem morbi curabitur. Pharetra nam potenti lectus litora dui nostra placerat, rutrum blandit molestie consectetur nisl volutpat, posuere interdum imperdiet quisque dignissim congue. Platea imperdiet pellentesque libero augue massa etiam laoreet, erat quisque venenatis aenean elementum quis, morbi mattis eu egestas feugiat leo."));
        notes.add(new Note(UUID.randomUUID().toString(), R.drawable.ic_baseline_notes_24, "Note 2", "Laoreet congue leo sit curabitur scelerisque natoque elit placerat, sollicitudin habitasse pretium maximus id neque porta sapien, litora conubia primis auctor metus dis porttitor. Himenaeos fermentum nostra vivamus morbi mi cursus nisi habitasse laoreet ex mollis, lectus euismod faucibus cubilia massa imperdiet maximus blandit interdum curabitur dictumst, ultrices bibendum vestibulum auctor vulputate conubia phasellus mus tristique libero. Consectetur tempus varius dis habitasse mollis nascetur semper, dictum lorem parturient bibendum fermentum senectus ut, et nec pretium vestibulum quam nullam. Ante dui sit ad cursus quam mattis volutpat fringilla est semper malesuada, pretium lacus eget mi feugiat torquent tortor ut rutrum morbi scelerisque, nec duis consectetur mauris facilisis pellentesque quisque habitant adipiscing nulla. Scelerisque ex duis iaculis amet metus nibh fames, erat ultricies eleifend sed sapien elementum dictum dictumst, convallis nostra quisque felis inceptos gravida. Libero tellus quis mus rutrum litora ligula enim, amet mauris diam accumsan a sociosqu habitant, neque orci lorem placerat turpis odio. Diam maximus potenti sit torquent venenatis ipsum, interdum pellentesque penatibus felis aenean natoque, odio euismod class bibendum dignissim. Class nisi rhoncus fringilla elit facilisi phasellus bibendum velit libero porta lorem luctus, dictumst dui nec potenti etiam egestas venenatis nullam ultricies risus turpis maximus, convallis in rutrum proin pellentesque platea efficitur integer eleifend finibus cubilia."));

        return notes;
    }
}
