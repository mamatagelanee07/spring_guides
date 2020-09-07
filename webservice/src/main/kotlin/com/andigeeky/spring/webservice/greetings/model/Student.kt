package com.andigeeky.spring.webservice.greetings.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Student(
    @JsonProperty("id")
    val id: UUID,
    @JsonProperty("age")
    val age: Int,
    @JsonProperty("firstName")
    val firstName: String,
    @JsonProperty("lastName")
    val lastName: String,
    @JsonProperty("course")
    val course: String
)