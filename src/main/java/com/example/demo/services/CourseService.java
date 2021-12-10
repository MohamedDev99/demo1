package com.example.demo.services;

import com.example.demo.entities.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course addCourse(Course course);

    public Course getCourse(long courseId);

    public Course updateCourse(long courseId,Course course);

    public void deleteCourse(long parseLong);
}
