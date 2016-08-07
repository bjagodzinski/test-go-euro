package com.goeuro.devtest.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.goeuro.devtest.json.model.Position;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Class responsible for reading/writing JSON.
 *
 * Created by bjagodzinski on 2016-08-04.
 */
public final class JSONReader {

    private final ObjectMapper mapper = new ObjectMapper();
    private final ObjectWriter writer = mapper.writer();

    private JSONReader() {
    }

    /**
     * Gets the new instance of the JSONReader.
     *
     * @return brand new instance of JSONReader that ignore unknown properties
     */
    public static JSONReader newInstance() {

        JSONReader jsonReader = new JSONReader();
        // Provide instance of mapper that ignore unknown properties
        jsonReader.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return jsonReader;
    }

    /**
     * Gets the list of <code>Position</code> objects that are mapped from
     * given <code>jsonString</code>.
     *
     * @param jsonString JSON formatted string
     * @return list of formatted objects
     *
     * @throws IOException
     */
    public List<Position> getPositions(String jsonString) throws IOException {

        List<Position> csvRows = mapper.readValue( jsonString, new TypeReference<List<Position>>(){} );
        return csvRows;
    }

    /**
     * Writes the array of jsonObjects to given file.
     *
     * @param file file t write to
     * @param jsonObjects list of JSON objects
     *
     * @throws IOException
     */
    public void writeToFile(File file, List<?> jsonObjects) throws IOException {

        writer.writeValue( file, jsonObjects );
    }
}
