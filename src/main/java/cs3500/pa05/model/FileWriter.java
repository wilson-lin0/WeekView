package cs3500.pa05.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Write the file.
 */
public class FileWriter {
  File file;

  public FileWriter(File file) {
    this.file = file;
  }

  /**
   * Writes the given String to the given filepath.
   *
   * @param contents contents to write to the file
   */
  public void writeToFile(String contents) {
    // Add fileType extension to the end of the file path
    Path path = Path.of(file.getPath());

    // Convert String to data for writing ("raw" byte data)
    byte[] data = contents.getBytes();

    // The path may not exist, or we may not have permissions to write to it,
    // in which case we need to handle that error (hence try-catch)
    try {
      // Built-in convenience method for writing data to a file
      Files.write(path, data);
    } catch (IOException e) {
      throw new RuntimeException("An error occurred while writing to the file: " + e.getMessage());
    }
  }
}
