package com.andigeeky.spring.webservice.greetings.dao

import com.andigeeky.spring.webservice.greetings.model.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.util.*

@Repository("postgres")
class StudentDAOImpl(@Autowired private val jdbcTemplate: JdbcTemplate) : StudentDAO{
    override fun insertNewStudent(studentID: UUID, student: Student): Int {
        return jdbcTemplate.update(
            StudentQueries.INSERT,
            student.id,
            student.firstName,
            student.lastName,
            student.age,
            student.course
        )
    }

    override fun selectStudentByID(studentID: UUID): Student? {
        return jdbcTemplate.queryForObject(
            StudentQueries.SELECT_BY_ID, arrayOf(studentID), StudentRowMapper
        )
    }

    override fun selectAllStudents(): List<Student> {
        return jdbcTemplate.query(StudentQueries.SELECT_ALL, StudentRowMapper)
    }

    override fun updateStudentByID(studentID: UUID, newStudent: Student): Int {
        return jdbcTemplate.update(
            StudentQueries.UPDATE_BY_ID,
            newStudent.firstName,
            newStudent.lastName,
            newStudent.age,
            newStudent.course,
            studentID
        )
    }

    override fun deleteStudentByID(studentID: UUID): Int {
        return jdbcTemplate.update(
            StudentQueries.DELETE_BY_ID,
            studentID
        )
    }
}