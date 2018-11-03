package schoolapi.clients;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import schoolapi.entities.CourseResource;
import schoolapi.entities.StudentCourseResource;

@FeignClient("StudentCourse")
public interface StudentCourseClient {

  @RequestLine("GET /{id}")
  StudentCourseResource findById(@Param("id") Long courseStudentId);
}
