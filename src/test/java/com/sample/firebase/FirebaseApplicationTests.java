package com.sample.firebase;

import com.sample.firebase.user.User;
import com.sample.firebase.user.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class FirebaseApplicationTests {

    @Autowired
    private UserService service;

    @After
    public void tearDown() throws Exception {
//        subscribe.dispose();
    }

    @Test
    public void contextLoads() {

        User user = service.findByName("Adnan").block();

        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualToIgnoringCase("adnan");

    }

    private User getUser(String name) {
        return User.builder()
                    .name(name)
                    .build();
    }

}
