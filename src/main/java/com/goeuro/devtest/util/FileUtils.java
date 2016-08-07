package com.goeuro.devtest.util;

import com.goeuro.devtest.common.Constants;
import com.goeuro.devtest.csv.JSONCSVWriter;
import com.goeuro.devtest.json.model.Position;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.System.out;

/**
 * This class contains convenient methods to write to files.
 *
 * Created by bjagodzinski on 2016-08-06.
 */
public final class FileUtils {

    private FileUtils() {}

    /**
     * This method creates file with name <code>cityHint</code>.csv.
     * If file already exists it deletes it.
     * Writes <code>cities</code> to <code>Constants.CSV_FILE</code>.
     *
     * @param cities
     * @throws IOException
     */
    public static void writeToFile( String cityHint,  List<Position> cities) throws IOException {

        Path pathFile = Paths.get(cityHint + Constants.CSV_FILE_EXTENSION);
        if (Files.exists(pathFile)) {
            Files.delete(pathFile);
            out.println("WARING: File already exists. Deleting previous file.");
        }
        Files.createFile(pathFile);

        JSONCSVWriter jSONCSVWriter = JSONCSVWriter.newInstance();
        jSONCSVWriter.writeToFile(pathFile, cities);
        out.println("Records exported to '"+pathFile.getFileName() +"'.");
    }
}
