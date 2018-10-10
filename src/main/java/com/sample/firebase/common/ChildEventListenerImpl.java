package com.sample.firebase.common;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.MonoSink;

@RequiredArgsConstructor
public class ChildEventListenerImpl<T> implements ChildEventListener {

    private final MonoSink<T> monoSink;
    private final Class<T> typeClass;

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        T value = dataSnapshot.getValue(this.typeClass);
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
