package schoolapi.clients;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import schoolapi.entities.CourseResource;

import java.util.List;

@Component
@FeignClient("CourseClient")
public interface CourseClient {
  @RequestLine("GET /")
  List<CourseResource> findAll();

  @RequestLine("GET /{id}")
  CourseResource findById(@Param("id") Long courseId);
}
