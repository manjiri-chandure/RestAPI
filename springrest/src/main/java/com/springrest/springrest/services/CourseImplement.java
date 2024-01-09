package com.springrest.springrest.services;

import com.springrest.springrest.entity.Cource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseImplement implements CorcesService{
    List<Cource> list;
    long CourseId;

    public CourseImplement(){

        list = new ArrayList<>();
//        list.add(new Cource(111, "Spring boot", "Spring boot tutorial"));
//        list.add(new Cource(112, "spring", "Spring tutotrial"));

    }
    @Override
    public List<Cource> getCourses(){
        return list;
    }
    @Override
    public Cource getCourse(long CourseId){
         Cource c = null;
         for(Cource course : list){
             if(course.getId() == CourseId){
                 c = course;
                 break;
             }
         }
         return  c;
    }

    @Override
    public Cource addCourse(Cource cource){
        list.add(cource);
        return cource;
    }

    @Override
    public Cource updateCourse(Cource cource){
        for(Cource cor : list){
            if(cor.getId() == cource.getId()){
                list.remove(cor);
                list.add(cource);
                break;
            }
        }

        return  cource;
    }



    @Override
    public Cource deleteCourse(long courceId){
        Cource c = null;
        for(Cource cor : list){
            if(cor.getId() == courceId){
                c = cor;
                list.remove(cor);
                break;
            }
        }

        return  c;
    }

}
