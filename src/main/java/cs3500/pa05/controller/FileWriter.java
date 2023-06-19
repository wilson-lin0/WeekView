package cs3500.pa05.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * FileEditor class to edit/write the final output file
 */
public class FileWriter {
  private File file;
  private Path path;

  FileWriter(File file) {
    this.file = file;
    this.path = file.toPath();
  }

  /**
   * Writes the file with only text enclosed in "[[" and "]]" and headers.
   *
   * @param listFiles the list of files to write and merge
   * @return File the file to output the contents
   * @throws IOException throws when file is not found
   */
  public File writeFile(ArrayList<File> listFiles) throws IOException {
    for (File file : listFiles) {
      List<String> lines = Files.readAllLines(file.toPath());
      for (String text : lines) {
        byte[] data = text.concat("\n").getBytes();
        Files.write(this.path, data, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
      }
    }
    return this.file;
  }
}