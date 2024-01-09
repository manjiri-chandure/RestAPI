package com.springrest.springrest.controller;

import com.springrest.springrest.services.CorcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.springrest.springrest.entity.Cource;

@RestController
public class MyController {

    @Autowired
    private CorcesService courseService;
    @GetMapping("/home")
    public String home(){
        return "welcome to rest in spring boot";
    }
    @GetMapping("/cources")
    public List<Cource>  GetCources(){
         return this.courseService.getCourses();
    }

    @GetMapping("/cources/{courseId}")
    public Cource getCourse(@PathVariable String courseId){
        return  this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/cources")
    public Cource addCourse(@RequestBody Cource cources){
        return this.courseService.addCourse(cources);
    }

    @PutMapping("/cources")
    public Cource updateCourse(@RequestBody Cource cource){
         return this.courseService.updateCourse(cource);
    }

    @DeleteMapping("/cources/{id}")
    public Cource deleteCource(@PathVariable String id){
        return this.courseService.deleteCourse(Long.parseLong(id));
    }
}
