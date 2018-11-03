package schoolapi.services;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import schoolapi.clients.StudentCourseClient;
import schoolapi.entities.StudentCourseResource;

@Service
@Slf4j
public class StudentCourseService {


  private StudentCourseClient studentCourseClient =
      Feign.builder()
          .client(new OkHttpClient())
          .encoder(new GsonEncoder())
          .decoder(new GsonDecoder())
          .logger(new Slf4jLogger())
          .logLevel(Logger.Level.FULL)
          .target(StudentCourseClient.class, "http://127.0.0.1:9002");

  public StudentCourseResource findOneById(Long id) {
    return studentCourseClient.findById(id);
  }
}
