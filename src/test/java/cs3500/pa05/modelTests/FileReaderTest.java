package cs3500.pa05.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.FileReader;
import java.nio.file.Files;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class FileReaderTest {
  private File tempFile;
  private String content;
  private FileReader fileReader;

  @BeforeEach
  public void setUp() throws IOException {
    // Create a temporary file with some contents
    tempFile = File.createTempFile("test", ".txt");
    content = "This is a test file.";
    Files.write(tempFile.toPath(), content.getBytes());

    // Create a new FileReader instance
    fileReader = new FileReader();
  }

  @Test
  public void testReadFile() throws IOException {
    // Read the file using FileReader
    String result = fileReader.readFile(tempFile);

    // Verify the contents
    assertEquals(content, result);
  }

  @Test
  public void testReadEmptyFile() throws IOException {
    // Create an empty file
    File emptyFile = File.createTempFile("empty", ".txt");

    // Read the empty file using FileReader
    String result = fileReader.readFile(emptyFile);

    // Verify that the result is an empty string
    assertEquals("", result);
  }

  @Test
  public void testReadNonexistentFile() {
    // Create a file object pointing to a nonexistent file
    File nonexistentFile = new File("nonexistent.txt");

    // Read the nonexistent file using FileReader
    assertThrows(IOException.class, () -> {
      fileReader.readFile(nonexistentFile);
    });
  }

  @Test
  public void testReadDirectoryAsFile() {
    // Create a file object pointing to a directory
    File directory = new File("directory");

    // Read the directory as a file using FileReader
    assertThrows(IOException.class, () -> {
      fileReader.readFile(directory);
    });
  }

  @Test
  public void testReadFileWithException() {
    // Create a file object pointing to a file that is not readable
    File unreadableFile = new File("/dev/null");

    // Read the unreadable file using FileReader
    assertThrows(IOException.class, () -> {
      fileReader.readFile(unreadableFile);
    });
  }
}
