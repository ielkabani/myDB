package com.elkabani.mydb.services;

import com.elkabani.mydb.entities.User;
import com.elkabani.mydb.repositories.ProfileRepository;
import com.elkabani.mydb.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;

    @Transactional
    public void showEntityState()
    {
        var user = User.builder()
                .name("John Doe")
                .email("jdoe@example.com")
                .password("password")
                .build();

        if(entityManager.contains(user))
            System.out.println("Peristent");
        else
            System.out.println("Transient/Detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Peristent");
        else
            System.out.println("Transient/Detached");
    }
@Transactional
    public void showRelatedEntities()
    {
      //  var user = userRepository.findById(2L).orElseThrow();
     //   System.out.println(user.getEmail());

        var profile = profileRepository.findById((2L)).orElseThrow();
        //System.out.println((profile.getBio()));
        System.out.println((profile.getUser().getEmail()));
    }
}
