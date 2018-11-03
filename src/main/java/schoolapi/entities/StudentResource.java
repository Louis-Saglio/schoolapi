package schoolapi.entities;

import lombok.Data;

@Data
public class StudentResource {
  private Long id;
  private String name;
  private String grade;
  private Long courseId;

  public StudentResource(Long id, String name, String grade, Long courseId) {
    this.id = id;
    this.name = name;
    this.grade = grade;
    this.courseId = courseId;
  }
}
