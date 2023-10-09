package org.example;

import configFileReader.ConfigFileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    static ConfigFileReader configFileReader=new ConfigFileReader();
    public static Connection setCon() throws ClassNotFoundException, SQLException {
        Class.forName(configFileReader.driverName());
        Connection con= DriverManager
                .getConnection(configFileReader.driverUrl()
                        ,configFileReader.dataBaseUser()
                        ,configFileReader.dataBasePassword());
        return con;
}}
