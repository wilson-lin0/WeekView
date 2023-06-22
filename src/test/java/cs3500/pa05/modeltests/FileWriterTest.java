package cs3500.pa05.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the FileWriter Class
 */
public class FileWriterTest {
  private File tempFile;
  private FileWriter fileWriter;

  @BeforeEach
  public void setUp() throws IOException {
    tempFile = File.createTempFile("test", null);
    fileWriter = new FileWriter(tempFile);
  }

  @Test
  public void testWriteToFile() throws IOException {
    String contents = "This is a test content.";

    fileWriter.writeToFile(contents);

    String result = Files.readString(Path.of(tempFile.getPath()));

    assertEquals(contents, result);
  }

  @Test
  public void testWriteToNonexistentDirectory() {
    File directory = new File("nonexistentDir");

    String contents = "This is a test content.";

    FileWriter directoryWriter = new FileWriter(new File(directory, "test.txt"));

    assertThrows(RuntimeException.class, () -> {
      directoryWriter.writeToFile(contents);
    });
  }

  @Test
  public void testWriteToInvalidFilePath() {
    File invalidFile = new File("/invalid/path/file.txt");

    String contents = "This is a test content.";

    FileWriter invalidFileWriter = new FileWriter(invalidFile);

    assertThrows(RuntimeException.class, () -> {
      invalidFileWriter.writeToFile(contents);
    });
  }
}

