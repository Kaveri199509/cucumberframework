package utility;

import constants.LogImplementation;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FolderCopyWithTimestamp {
    private FolderCopyWithTimestamp() {

    }

    public static void FolderRename() {
        String sourceFolderPath = "QA_Automation/TestRunner/ExtentReports/SparkReport_ 21"; // Replace with the path of the source folder
        String destinationFolderPath = "QA_Automation/TestRunner/oldExtentReport"; // Replace with the path of

        try {
            // Get the source folder name and create a new folder name with the current timestamp
            Path sourcePath = Paths.get(sourceFolderPath);
            String sourceFolderName = sourcePath.getFileName().toString();
            String timestamp = new SimpleDateFormat("d_MMM_yy HH_mm_ss").format(new Date());

            String newFolderName = sourceFolderName + "_" + timestamp;

            // Create the destination folder with the new folder name
            Path destinationPath = Paths.get(destinationFolderPath, newFolderName);
            Files.createDirectories(destinationPath);

            // Copy the entire source folder to the destination folder
            CopyOption[] options = {StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING};
            Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path relativePath = sourcePath.relativize(file);
                    Path destinationFile = destinationPath.resolve(relativePath);
                    Files.copy(file, destinationFile, options);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Path relativePath = sourcePath.relativize(dir);
                    Path destinationDir = destinationPath.resolve(relativePath);
                    Files.createDirectories(destinationDir);
                    return FileVisitResult.CONTINUE;
                }
            });

            LogImplementation.info("Folder copied successfully. New folder name: " + newFolderName);
        } catch (IOException e) {
            LogImplementation.info("Error while copying the folder: " + e.getMessage());
        }
    }
}

