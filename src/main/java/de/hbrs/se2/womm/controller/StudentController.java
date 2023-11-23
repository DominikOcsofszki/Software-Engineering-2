package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(
                studentService.getAlleStudenten(),
                HttpStatus.OK
        );
    }

    @GetMapping("students/{id}")
    public ResponseEntity<List<StudentDTO>> getStudentById(@PathVariable String id) {
        List<StudentDTO> alleStudenten = studentService.getAlleStudenten();
        return new ResponseEntity<>(alleStudenten, HttpStatus.OK);
    }

    @PostMapping("students")
    public ResponseEntity<Void> updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
