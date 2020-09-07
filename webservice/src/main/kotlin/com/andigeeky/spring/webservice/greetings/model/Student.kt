package com.andigeeky.spring.webservice.greetings.model

import java.util.*

data class Student(
    val id: UUID,
    val age: Int,
    val firstName: String,
    val lastName: String,
    val course: String
)