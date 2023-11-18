package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(
                studentService.getAllStudents(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable String id, @RequestBody StudentDTO request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
