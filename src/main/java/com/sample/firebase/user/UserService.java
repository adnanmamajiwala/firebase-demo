package com.sample.firebase.user;

import com.google.firebase.database.DatabaseReference;
import com.sample.firebase.common.ChildEventListenerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final DatabaseReference databaseReference;

    public void insert(User user) {
        DatabaseReference users = databaseReference.child("users_table");

        Map<String, Object> map = new HashMap<>();
        map.put(users.push().getKey(), user);

        users.updateChildrenAsync(map);
    }

    public Mono<User> findByName(String name){
        DatabaseReference reference = databaseReference.child("users_table");
        return Mono.create(monoSink -> reference
                .orderByChild("name")
                .equalTo(name)
                .limitToFirst(1)
                .addChildEventListener(new ChildEventListenerImpl<User>(monoSink)));
    }

}
