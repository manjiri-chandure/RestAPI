package com.springrest.springrest.services;

import com.springrest.springrest.entity.Cource;

import java.util.List;

public interface CorcesService {

     public List<Cource> getCourses();
     public Cource getCourse(long courseId);

     public  Cource addCourse(Cource cource);
     public Cource updateCourse(Cource cource);

     public Cource deleteCourse(long courceId);
}
