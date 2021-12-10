package com.example.demo.controller;


import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    @Autowired
    private CourseService courseService;

    // get all Courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    // get a course by id
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return courseService.getCourse(Long.parseLong(courseId));
    }

    // add a course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    // update a course by id
    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@PathVariable String courseId,@RequestBody Course course){
        return courseService.updateCourse(Long.parseLong(courseId),course);
    }

    // delete a course by id
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
