package cs3500.pa05.modelTests;

import cs3500.pa05.model.FileWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class FileWriterTest {
  private File tempFile;
  private FileWriter fileWriter;

  @BeforeEach
  public void setUp() throws IOException {
    // Create a temporary file
    tempFile = File.createTempFile("test", null);

    // Create a new FileWriter instance
    fileWriter = new FileWriter();
  }

  @Test
  public void testWriteToFile() throws IOException {
    // File path for the temporary file
    String filePath = tempFile.getPath();

    // Contents to write to the file
    String contents = "This is a test content.";

    // Write the contents to the file using FileWriter
    fileWriter.writeToFile(tempFile, contents);

    // Read the contents from the file
    String result = Files.readString(Path.of(filePath + ".bujo"));

    // Verify the contents
    assertEquals(contents, result);
  }

  @Test
  public void testWriteToNonexistentDirectory() {
    // Create a file object pointing to a nonexistent directory
    File directory = new File("nonexistentDir");

    // Contents to write to the file
    String contents = "This is a test content.";

    // Write the contents to the nonexistent directory using FileWriter
    assertThrows(RuntimeException.class, () -> {
      fileWriter.writeToFile(new File(directory, "test.txt"), contents);
    });
  }

  @Test
  public void testWriteToInvalidFilePath() {
    // Create a file object with an invalid file path
    File invalidFile = new File("/invalid/path/file.txt");

    // Contents to write to the file
    String contents = "This is a test content.";

    // Write the contents to the invalid file path using FileWriter
    assertThrows(RuntimeException.class, () -> {
      fileWriter.writeToFile(invalidFile, contents);
    });
  }
}
