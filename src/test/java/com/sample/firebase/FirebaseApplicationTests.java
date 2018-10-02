package com.sample.firebase;

import com.sample.firebase.user.User;
import com.sample.firebase.user.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.Disposable;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class FirebaseApplicationTests {

    @Autowired
    private UserService service;
    private Disposable subscribe;

    @After
    public void tearDown() throws Exception {
//        subscribe.dispose();
    }

    @Test
    public void contextLoads() {

//        service.insert(getUser("Adnan"));
//        service.insert(getUser("tasneem"));
        service.insert(getUser("Hatim"));

        subscribe = service.findByName("Adnan")
                .subscribe(u -> {
                    System.out.println(u);
                    subscribe.dispose();
                });
        System.out.println("Hello World");

    }

    private User getUser(String name) {
        return User.builder()
                    .name(name)
                    .build();
    }

}
