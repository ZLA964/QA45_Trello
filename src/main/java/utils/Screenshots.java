package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshots {
    public static String takeScreenShort(TakesScreenshot screenshot) {
        Path scrShFilePath = screenshot.getScreenshotAs(OutputType.FILE).toPath();
        Path targetPath = Paths.get("src/test/resources/test_logs/screenshots/" +
                LocalDateTime.now().format(DateTimeFormatter
                        .ofPattern("yyyy-MM-dd_HH-mm-ss")) +
                ".png");

        try {
            Files.copy(scrShFilePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyy-MM-dd_HH-mm-ss")) +
                ".png";
    }
}
