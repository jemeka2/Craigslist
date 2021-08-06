package com.example.craigslist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    public static long idCounter = 0;

    public static int i = 0;

    ArrayList<Job> jobs = new ArrayList<>();

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("jobs", jobs);
        return "home";
    }

    @RequestMapping("/login")
    public String login(){return "login";}

    @RequestMapping("/logout")
    public String logout(){return "redirect:/";}

    @GetMapping("/add")
    public String add(Model model){
        Job newJob = new Job();
        idSetter(newJob);
        model.addAttribute("job", newJob);
        return "add";
    }

    @PostMapping("/save")
    public String save(@Valid Job job, BindingResult results){
        if(results.hasErrors()){
            return "add";
        }
        jobs.add(job);
        return "save";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/processregister")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        if(result.hasErrors()){
            user.clearPassword();
            model.addAttribute("user", user);
            return "register";
        }
        else{
            i++;
            String customRole = "ROLE_USER" + String.valueOf(i);

            model.addAttribute("user", user);
            model.addAttribute("message", "New user account created");

            user.setEnabled(true);
            userRepo.save(user);

            Role role1 = new Role(user.getUsername(), "ROLE_USER");
            Role role2 = new Role(user.getUsername(), customRole);

            roleRepo.save(role1);
            roleRepo.save(role2);
        }
        return "login";
    }

    @RequestMapping("/detail/{id}")
    public String detailItem(@PathVariable("id") long id, Model model){
        for (Job job: jobs){
            if(id == job.getId()){
                model.addAttribute("job", job);
                break;
            }
        }
        return "save";
    }

    @RequestMapping("/update/{id}")
    public String updateJob(@PathVariable("id") long id, Model model){

        for (Job job: jobs) {
            if (id == job.getId()) {

                model.addAttribute("job", job);
                jobs.set((int)id - 1, job);
                break;
            }
        }
        return "add";
    }
    @RequestMapping("/delete/{id}")
    public String deleteJob(@PathVariable("id") long id, Model model){

        for (Job job: jobs) {
            if (id == job.getId()) {
                jobs.remove((int)id - 1);
                break;
            }
        }
        return "home";
    }


    private void idSetter(Job job){
        idCounter += 1;
        job.setId(idCounter);
    }
}
