package schoolapi.entities;

import lombok.Data;

@Data
public class CourseResource {
  private Long id;
  private String title;

  public CourseResource(Long id, String title) {
    this.id = id;
    this.title = title;
  }
}
