package com.andigeeky.spring.webservice.greetings.dao

import com.andigeeky.spring.webservice.greetings.model.Student
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.util.*

object StudentRowMapper : RowMapper<Student> {
    override fun mapRow(resultSet: ResultSet, rowNum: Int): Student? {
        return Student(
            id = UUID.fromString(resultSet.getString(StudentQueries.COLUMN_ID)),
            firstName = resultSet.getString(StudentQueries.COLUMN_FIRST_NAME),
            lastName = resultSet.getString(StudentQueries.COLUMN_LAST_NAME),
            age = resultSet.getInt(StudentQueries.COLUMN_AGE),
            course = resultSet.getString(StudentQueries.COLUMN_COURSE)
        )
    }
}