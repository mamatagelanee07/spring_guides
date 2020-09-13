package com.andigeeky.spring.webservice.greetings.dao

object StudentQueries {
    private const val TABLE_STUDENT = "student"

    const val COLUMN_ID = "id"
    const val COLUMN_FIRST_NAME = "firstName"
    const val COLUMN_LAST_NAME = "lastName"
    const val COLUMN_AGE = "age"
    const val COLUMN_COURSE = "course"

    const val INSERT = "INSERT INTO $TABLE_STUDENT ($COLUMN_ID, $COLUMN_FIRST_NAME, $COLUMN_LAST_NAME, $COLUMN_AGE, $COLUMN_COURSE) VALUES (?, ?, ?, ?, ?)"
    const val SELECT_BY_ID = "SELECT * FROM $TABLE_STUDENT WHERE $COLUMN_ID=?"
    const val SELECT_ALL = "SELECT * FROM $TABLE_STUDENT"
    const val UPDATE_BY_ID = "update $TABLE_STUDENT set $COLUMN_FIRST_NAME=?, $COLUMN_LAST_NAME=?, $COLUMN_AGE=?, $COLUMN_COURSE=? WHERE $COLUMN_ID=?"
    const val DELETE_BY_ID = "DELETE from $TABLE_STUDENT WHERE $COLUMN_ID=?"
}