package schoolapi.entities;

import lombok.Data;

import java.util.List;

@Data
public class StudentCourseResource {

  private CourseResource course;
  private List<StudentResource> students;

  public StudentCourseResource(CourseResource course, List<StudentResource> students) {
    this.course = course;
    this.students = students;
  }
}
