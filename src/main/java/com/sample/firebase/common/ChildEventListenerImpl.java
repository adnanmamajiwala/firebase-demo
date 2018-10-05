package com.sample.firebase.common;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.sample.firebase.user.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.MonoSink;

@RequiredArgsConstructor()
public class ChildEventListenerImpl<T> implements ChildEventListener {

    private final MonoSink<User> monoSink;

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        System.out.println(dataSnapshot.toString());
        User value = dataSnapshot.getValue(User.class);
        monoSink.success(value);
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The findByName failed: " + databaseError.getCode());
    }
}
