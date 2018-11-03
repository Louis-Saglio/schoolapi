package schoolapi.clients;

import feign.Param;
import feign.RequestLine;
import schoolapi.entities.StudentResource;

import java.util.List;

public interface StudentClient {
  @RequestLine("GET /byCourse/{courseId}")
  List<StudentResource> findByCourseId(@Param("courseId") Long id);

  @RequestLine("GET /")
  List<StudentResource> findAll();

  @RequestLine("GET /{id}")
  StudentResource findOneById(@Param("id") Long id);
}
