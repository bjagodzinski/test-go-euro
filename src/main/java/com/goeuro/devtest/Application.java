package com.goeuro.devtest;

import com.goeuro.devtest.common.Constants;
import com.goeuro.devtest.json.JSONReader;
import com.goeuro.devtest.json.model.Position;
import com.goeuro.devtest.url.URLStreamReader;
import com.goeuro.devtest.util.FileUtils;
import com.goeuro.devtest.util.ValidationUtils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.System.err;

/**
 * Main application class.
 *
 * Created by bjagodzinski on 2016-08-06.
 */
public class Application {

    public static void main(String... args) throws IOException {

        validateArguments(args);

        String cityHint = args[0];

        String urlResponse          = getUrlResponse(cityHint);
        List<Position> positions    = getPositions(urlResponse);

        writeToFile(cityHint, positions);

        out.println("Export to CSV finished. Press any key to continue...");
        in.read();
    }

    /**
     * Validates the input arguments. If validation is not passed
     * the JVM exits.
     *
     * @param args
     */
    private static void validateArguments(String... args) {

        String validationResult = ValidationUtils.validateInputArguments(args);
        if ( validationResult != null ) {
            err.println("ERROR: Validation of input arguments failed. The message is:\n" + validationResult);
            exit(0);
        }
    }

    /**
     * Writes positions to file.
     *
     * @param cityHint
     * @param positions
     */
    private static void writeToFile(String cityHint, List<Position> positions) {

        if ( positions != null && !positions.isEmpty() ) {

            try {
                FileUtils.writeToFile(cityHint, positions);
            } catch (IOException e) {
                err.println("ERROR: Exception when writing to file. The message is:\n" + e.getMessage());
                throw new RuntimeException(e);
            }

        } else {
            out.println("WARNING: No data exported to file.");
        }
    }

    /**
     * Gets the list of <code>Position</code> created from given <code>urlResponse</code>.
     *
     * @param urlResponse
     * @return
     */
    private static List<Position> getPositions(String urlResponse) {

        try {

            JSONReader jsonReader = JSONReader.newInstance();
            return jsonReader.getPositions(urlResponse);

        } catch (IOException e) {
            err.println("ERROR: Exception when processing url response. The message is:\n" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    /**
     * Gets the string response from the <code>Constants.URL_STRING</code> with
     * '%s' substituted with the value of <code>position</code>.
     *
     * @param positionHint name of the city as a hint
     * @return string response from the url
     */
    public static String getUrlResponse( String positionHint ) {

        try {

            String urlWithCityName = String.format(Constants.URL_STRING, positionHint) ;
            return URLStreamReader.readFromURL(urlWithCityName);

        } catch (ConnectException ce) {
            err.println("ERROR: Timeout occurred. Please check your connection.");
            throw new RuntimeException(ce);
        } catch (UnknownHostException uhe) {
            err.println("ERROR: Unreachable host at given url " + Constants.URL_STRING);
            throw new RuntimeException(uhe);
        } catch (IOException e) {
            err.println("ERROR: Unexpected connection problem. The message is:\n" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
