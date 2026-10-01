package com.elkabani.mydb;

import com.elkabani.mydb.entities.Address;
import com.elkabani.mydb.entities.User;
import com.elkabani.mydb.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyDbApplication {

    public static void main(String[] args) {

      ApplicationContext context = SpringApplication.run(MyDbApplication.class, args);
      var repository = context.getBean(UserRepository.class);

      var user = User.builder()
                .name("John")
                .email("john@example.com")
                .password("Password")
                .build();

      /*  var address = Address.builder()
                .city("Cincinnati")
                .state("Ohio")
                .street("123 Main St")
                .zipCode("45202")
                .build();
        user.addAddress(address); */

//        repository.save(user);

        var user1 = repository.findById(2L).orElseThrow();
        System.out.println(user1.getEmail());

        var users = repository.findAll();
        users.forEach(u->System.out.println(u.getEmail()));

        repository.deleteById(1L);
    }

}
