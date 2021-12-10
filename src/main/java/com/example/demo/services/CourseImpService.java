package com.example.demo.services;


import com.example.demo.entities.Course;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseImpService implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourse(long courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    public Course updateCourse(long courseId,Course course) {
        Course updatedCourse = courseRepository.findById(courseId).get();
         if(Objects.nonNull(updatedCourse.getTitle()) && !"".equalsIgnoreCase(course.getTitle())){
             updatedCourse.setTitle(course.getTitle());
         }
        if(Objects.nonNull(updatedCourse.getDescription()) && !"".equalsIgnoreCase(course.getDescription())){
            updatedCourse.setDescription(course.getDescription());
        }
        return courseRepository.save(updatedCourse);
    }

    @Override
    public void deleteCourse(long courseId) {
        Optional<Course> deletedCourse = courseRepository.findById(courseId);
        if (deletedCourse.isPresent()){
            courseRepository.delete(courseRepository.findById(courseId).get());
        }
    }

}
