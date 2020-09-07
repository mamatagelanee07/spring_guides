package com.andigeeky.spring.webservice.greetings.dao

import com.andigeeky.spring.webservice.greetings.model.Student
import java.util.*

class FakeStudentDAOImpl : StudentDAO {

    private val database: MutableMap<UUID, Student> = mutableMapOf()

    override fun insertNewStudent(studentID: UUID, student: Student): Int {
        database[studentID] = student
        return 1
    }

    override fun selectStudentByID(studentID: UUID): Student? {
        return database[studentID]
    }

    override fun selectAllStudents(): List<Student> {
        return database.map { it.value }
    }

    override fun updateStudentByID(studentID: UUID, updatedStudent: Student): Int {
        return if (database.containsKey(studentID)) {
            database[studentID] = updatedStudent
            1
        } else 0
    }

    override fun deleteStudentByID(studentID: UUID): Int {
        return if (database.containsKey(studentID)) {
            database.remove(studentID)
            1
        } else 0
    }
}