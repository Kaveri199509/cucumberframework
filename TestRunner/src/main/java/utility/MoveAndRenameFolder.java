package utility;

import constants.LogImplementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class MoveAndRenameFolder {
    public static void renameFolder() {
        String parentFolderPath = "C:\\Users\\lenovo\\Desktop\\QA-Automation\\TestRunner\\ExtentReports"; // Replace this with the actual parent folder path
        String targetFolderPath = "C:\\Users\\lenovo\\Desktop\\QA-Automation\\TestRunner\\MovedExtentReports"; // Replace this with the actual target folder path

        File parentFolder = new File(parentFolderPath);
        File[] subFolders = parentFolder.listFiles();
        boolean andProcessSparkHtmlFile = findAndProcessSparkHtmlFile(parentFolder);
        if (subFolders != null && andProcessSparkHtmlFile) {
            for (File subFolder : subFolders) {
                LogImplementation.info("subFolder = " + subFolder);
                if (subFolder.isDirectory() && subFolder.getName().equalsIgnoreCase("SparkReport_ 21")) {
                    String folderName = subFolder.getName();
                    String[] splitName = folderName.split("_");
                    if (splitName.length == 2) {
                        String newName = splitName[0] + "_" + GetExtentReportTimestamp.getDateFromExtentReport();
                        File targetFolder = new File(targetFolderPath, newName);
                        try {
                            Files.move(subFolder.toPath(), targetFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
                            LogImplementation.info("Moved and renamed folder: " + targetFolder.getName());
                        } catch (IOException e) {
                            LogImplementation.info("Error moving folder: " + e.getMessage());
                        }
                    }
                }
            }
        } else {
            LogImplementation.info("spark.html file not found. Child folders will not be moved.");
        }
    }

    private static boolean findAndProcessSparkHtmlFile(File folder) {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively call the function for subdirectories
                    boolean foundInSubdirectory = findAndProcessSparkHtmlFile(file);
                    if (foundInSubdirectory) {
                        return true;
                    }
                } else if (file.getName().equalsIgnoreCase("Spark.html")) {
                    // Found Spark.html, return true
                    return true;
                }
            }
        }

        // Spark.html not found in this directory or subdirectories
        return false;
    }
}

