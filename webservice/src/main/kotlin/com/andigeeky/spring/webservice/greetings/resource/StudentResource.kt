package com.andigeeky.spring.webservice.greetings.resource

import com.andigeeky.spring.webservice.greetings.model.Student
import com.andigeeky.spring.webservice.greetings.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/students")
class StudentResource(@Autowired private val studentService: StudentService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllStudents() : List<Student>{
        return studentService.getAllStudents()
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addStudent(@RequestBody student : Student){
        studentService.persistNewStudent(
            studentID = UUID.randomUUID(),
            student = student
        )
    }
}