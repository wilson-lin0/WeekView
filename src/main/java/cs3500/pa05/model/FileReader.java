package cs3500.pa05.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Reads the file.
 */
public class FileReader {
  /**
   * Reads the contents of the given file and returns it as a string.
   *
   * @param file the file to read
   * @return the contents of the file as a string
   * @throws IOException if an error occurs during file reading
   */
  public String readFile(File file) throws IOException {
    return Files.readString(file.toPath());
  }
}


