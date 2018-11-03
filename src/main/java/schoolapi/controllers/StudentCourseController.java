package schoolapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schoolapi.entities.StudentCourseResource;
import schoolapi.services.StudentCourseService;

@RestController
@RequestMapping(value = "coursestudents")
public class StudentCourseController {

  @Autowired
  private StudentCourseService studentCourseService;

  @GetMapping("/{id}")
  StudentCourseResource getOne(@PathVariable Long id) {
    return studentCourseService.findOneById(id);
  }
}
