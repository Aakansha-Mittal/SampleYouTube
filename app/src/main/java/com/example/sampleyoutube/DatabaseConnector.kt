package com.example.sampleyoutube

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DatabaseConnector {
    private const val DB_URL = "jdbc:postgresql://10.0.2.2:5432/Youtube"
    private const val USER = "postgres"
    private const val PASSWORD = "#Aakansha123"


    fun getConnection(): Connection? {
        return try {
            Class.forName("org.postgresql.Driver")
            DriverManager.getConnection(DB_URL, USER, PASSWORD)

        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            null
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}
