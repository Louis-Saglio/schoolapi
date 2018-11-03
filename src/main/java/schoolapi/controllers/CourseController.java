package schoolapi.controllers;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schoolapi.clients.CourseClient;
import schoolapi.entities.CourseResource;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

  private CourseClient courseClient = Feign.builder()
      .client(new OkHttpClient())
      .encoder(new GsonEncoder())
      .decoder(new GsonDecoder())
      .logger(new Slf4jLogger())
      .logLevel(Logger.Level.FULL)
      .target(CourseClient.class, "http://127.0.0.1:9000");

  @GetMapping()
  List<CourseResource> getAll() {
    return courseClient.findAll();
  }

  @GetMapping("{id}")
  CourseResource getOne(@PathVariable Long id) {
    return courseClient.findById(id);
  }

}
