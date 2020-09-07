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
        val id = UUID.randomUUID()
        studentService.persistNewStudent(
            studentID = id,
            student = student.copy(id = id)
        )
    }

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        path = ["{studentID}"]
    )
    fun getStudentByID(@PathVariable("studentID") studentID : UUID) : Student?{
        return studentService.getStudentByID(studentID)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateStudent(@RequestBody student : Student){
        studentService.updateStudentByID(
            studentID = student.id,
            newStudent = student
        )
    }
    @DeleteMapping(
        path = ["{studentID}"]
    )
    fun deleteStudentByID(@PathVariable("studentID") studentID : UUID){
        studentService.deleteStudentByID(studentID)
    }
}