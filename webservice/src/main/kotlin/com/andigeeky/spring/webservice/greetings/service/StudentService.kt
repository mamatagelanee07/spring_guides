package com.andigeeky.spring.webservice.greetings.service

import com.andigeeky.spring.webservice.greetings.dao.StudentDAO
import com.andigeeky.spring.webservice.greetings.model.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(@Autowired @Qualifier("fakeDAO") private val studentDAO : StudentDAO) {

    fun persistNewStudent(studentID: UUID?, student: Student) : Int{
        val id = studentID ?: UUID.randomUUID()
        return studentDAO.insertNewStudent(id, student.copy(id = id))
    }
    fun getStudentByID(studentID: UUID) : Student?{
        return studentDAO.selectStudentByID(studentID)
    }
    fun getAllStudents() : List<Student>{
        return studentDAO.selectAllStudents()
    }
    fun updateStudentByID(studentID: UUID, newStudent : Student) : Int{
        return studentDAO.updateStudentByID(studentID, newStudent)
    }
    fun deleteStudentByID(studentID: UUID) : Int{
        return studentDAO.deleteStudentByID(studentID)
    }
}