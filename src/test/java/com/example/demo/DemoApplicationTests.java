package com.example.demo;

import com.example.demo.Models.User;
import com.example.demo.Repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void checkUserTest(){
        User u = new User( "Karim", "Jouni", 30, "ceo");
        String userName = u.getFirstName();
        assertEquals(userName,"Karim");
    }

    @Test
    public void addUserTest(){
        User user = new User("Emna","a",23,"student");
        userRepo.save(user);
        int user_id = (int) user.getId();
        assertNotNull(user_id);
    }

}
