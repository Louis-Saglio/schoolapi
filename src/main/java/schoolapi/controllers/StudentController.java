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
import schoolapi.clients.StudentClient;
import schoolapi.entities.StudentResource;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

  private StudentClient studentClient = Feign.builder()
      .client(new OkHttpClient())
      .encoder(new GsonEncoder())
      .decoder(new GsonDecoder())
      .logger(new Slf4jLogger())
      .logLevel(Logger.Level.FULL)
      .target(StudentClient.class, "http://127.0.0.1:9001");

  @GetMapping()
  List<StudentResource> getAll() {
    return studentClient.findAll();
  }

  @GetMapping("/{id}")
  StudentResource getOne(@PathVariable Long id) {
    return studentClient.findOneById(id);
  }

}
