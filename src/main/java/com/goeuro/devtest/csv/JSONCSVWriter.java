package com.goeuro.devtest.csv;

import com.goeuro.devtest.common.Constants;
import com.goeuro.devtest.json.model.Position;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Class responsible for writing/exporting JSON to CSV file.
 *
 * Created by bjagodzinski on 2016-08-06.
 */
public final class JSONCSVWriter {

    private JSONCSVWriter() {
    }

    /**
     * Gets the new instance of the JSONCSVWriter.
     *
     * @return brand new instance of JSONCSVWriter.s
     */
    public static JSONCSVWriter newInstance() {

        JSONCSVWriter JSONCSVWriter = new JSONCSVWriter();
        return JSONCSVWriter;
    }

    /**
     * Writes the array of jsonObjects to given file.
     *
     * @param pathFile file to write to
     * @param cities list of JSON objects
     *
     * @throws IOException
     */
    public void writeToFile(Path pathFile, List<Position> cities) throws IOException {

        StringBuilder builder = new StringBuilder();
        for (Position position : cities) {
            builder.append(position.get_id());
            builder.append(Constants.CSV_SEPARATOR);
            builder.append(position.getName());
            builder.append(Constants.CSV_SEPARATOR);
            builder.append(position.getType());
            builder.append(Constants.CSV_SEPARATOR);
            builder.append(position.getGeo_position().getLatitude());
            builder.append(Constants.CSV_SEPARATOR);
            builder.append(position.getGeo_position().getLongitude());
            builder.append(Constants.NEW_LINE);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(pathFile)) {
            writer.write(builder.toString());
        }

    }
}
