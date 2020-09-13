package com.andigeeky.spring.webservice.greetings.datasource

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PostgresDataSource {

    @Bean
    @ConfigurationProperties("app.datasource")
    fun hikariDataSource(): HikariDataSource = DataSourceBuilder
        .create()
        .type(HikariDataSource::class.java)
        .build()
}