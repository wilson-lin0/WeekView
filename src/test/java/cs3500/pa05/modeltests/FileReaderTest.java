package cs3500.pa05.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the FileReader class.
 */
public class FileReaderTest {
  private File tempFile;
  private String content;
  private FileReader fileReader;

  /**
   * Sets up the test fixture.
   */
  @BeforeEach
  public void setUp() throws IOException {
    tempFile = File.createTempFile("test", ".txt");
    content = "This is a test file.";
    Files.write(tempFile.toPath(), content.getBytes());

    fileReader = new FileReader();
  }

  @Test
  public void testReadFile() throws IOException {
    String result = fileReader.readFile(tempFile);

    assertEquals(content, result);
  }

  @Test
  public void testReadEmptyFile() throws IOException {
    File emptyFile = File.createTempFile("empty", ".txt");

    String result = fileReader.readFile(emptyFile);

    assertEquals("", result);
  }

  @Test
  public void testReadNonexistentFile() {
    File nonexistentFile = new File("nonexistent.txt");

    assertThrows(IOException.class, () -> {
      fileReader.readFile(nonexistentFile);
    });
  }

  @Test
  public void testReadDirectoryAsFile() {
    File directory = new File("directory");

    assertThrows(IOException.class, () -> {
      fileReader.readFile(directory);
    });
  }

  @Test
  public void testReadFileWithException() {
    File unreadableFile = new File("unreadable", ".txt");
    unreadableFile.setReadable(false);
    assertThrows(IOException.class, () -> {
      fileReader.readFile(unreadableFile);
    });
  }

  @Test
  public void testReadFileWithSpecialCharacters() throws IOException {
    File specialFile = File.createTempFile("special", ".txt");
    String content = "This is a file with special characters: !@#$%^&*()_+";
    Files.write(specialFile.toPath(), content.getBytes());

    String result = fileReader.readFile(specialFile);

    assertEquals(content, result);
  }
}
