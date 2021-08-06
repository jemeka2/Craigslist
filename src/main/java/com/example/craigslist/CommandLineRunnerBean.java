package com.example.craigslist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    public void run(String...args){
        User admin = new User("jabir", "super@domain.com", "jabir", "Super", "Hero", true);
        Role adminRole1 = new Role("jabir", "ROLE_ADMIN");
        Role adminRole2 = new Role("jabir", "ROLE_USER");

        userRepo.save(admin);
        roleRepo.save(adminRole1);
        roleRepo.save(adminRole2);
    }

}
