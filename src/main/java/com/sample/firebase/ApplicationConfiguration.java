package com.sample.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Configuration
public class ApplicationConfiguration {

    @PostConstruct
    public void init() throws Exception{
        InputStream inputStream = new ClassPathResource("service-account.json").getInputStream();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .setDatabaseUrl("https://my-demo-sample.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);
    }

    @Bean
    public DatabaseReference firebaseDatabse() {
        return FirebaseDatabase.getInstance().getReference();
    }

}
