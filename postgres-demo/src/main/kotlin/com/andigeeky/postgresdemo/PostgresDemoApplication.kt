package com.andigeeky.postgresdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PostgresDemoApplication

fun main(args: Array<String>) {
	runApplication<PostgresDemoApplication>(*args)
}
