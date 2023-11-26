package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/students")
public class StudentController {

    // TODO add logic to methods and suitable return types for ResponseEntities

    @GetMapping("")
    public ResponseEntity<Void> getAllStudents() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Void> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/student/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable String id, @RequestBody StudentDTO request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
