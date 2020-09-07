package com.andigeeky.spring.webservice.greetings.dao

import com.andigeeky.spring.webservice.greetings.model.Student
import java.util.*

interface StudentDAO {
    fun insertNewStudent(studentID: UUID, student: Student) : Int
    fun selectStudentByID(studentID: UUID) : Student?
    fun selectAllStudents() : List<Student>
    fun updateStudentByID(studentID: UUID, newStudent : Student) : Int
    fun deleteStudentByID(studentID: UUID) : Int
}