package configFileReader;

import constants.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private static final String PROPERTY_FILE_PATH = "\\QA_Automation\\DatabaseConnector\\src\\main\\resources\\db.properties";
    private static final Properties properties = new Properties();

    public ConfigFileReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH))) {
            properties.load(reader);
        } catch (IOException e) {
            String errorMessage = "Error while reading configuration file: " + e.getMessage();
            throw new ConfigFileReaderException(errorMessage, e);
        }
    }

    public String driverUrl() {
        String driverUrl = properties.getProperty(Constants.DRIVER_URL);
        if (driverUrl != null) return driverUrl;
        else throw new ConfigFileReaderException("url not specified in the db.properties file.");
    }

    public String driverName() {
        String driverName = properties.getProperty(Constants.DRIVER_NAME);
        if (driverName != null) return driverName;
        else throw new ConfigFileReaderException("Driver not found in the db.properties file.");
    }

    public String dataBaseUser() {
        String dataBaseUser = properties.getProperty(Constants.DATABASE_USER);
        if (dataBaseUser != null) return dataBaseUser;
        else throw new ConfigFileReaderException("User not found in the db.properties file.");
    }

    public String dataBasePassword() {
        String dataBasePass = properties.getProperty(Constants.DATABASE_PASS);
        if (dataBasePass != null) return dataBasePass;
        else throw new ConfigFileReaderException("Password not found in the db.properties file.");
    }

    public String getTableName() {
        String table_name = properties.getProperty(Constants.TABLE_NAME);
        if (table_name != null) return table_name;
        else throw new ConfigFileReaderException("Table not found in the db.properties file.");
    }

    public String getCsvFilePath() {
        String filePath = properties.getProperty(Constants.CSV_FILEPATH);
        if (filePath != null) return filePath;
        else throw new ConfigFileReaderException("csv file location not found in the db.properties file.");
    }


}
