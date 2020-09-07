package com.andigeeky.spring.webservice.greetings.service

import com.andigeeky.spring.webservice.greetings.dao.StudentDAO
import com.andigeeky.spring.webservice.greetings.model.Student
import java.util.*

class StudentService(
    private val studentDAO : StudentDAO
) {
    fun persistNewStudent(studentID: UUID?, student: Student) : Int{
        return studentDAO.insertNewStudent(studentID ?: UUID.randomUUID() , student)
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