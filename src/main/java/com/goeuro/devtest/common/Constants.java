package com.goeuro.devtest.common;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Class that holds constant values.
 *
 * Created by bjagodzinski on 2016-08-04.
 */
public final class Constants {

    /**
     * Url to be queried.
     * Use String.format or String's <code>replace</code> method
     * to replace the '%s' argument.
     */
    public static final String URL_STRING  = "http://api.goeuro.com/api/v2/position/suggest/en/%s";

    /**
     * New line separator used to read from the url response.
     */
    public static final String NEW_LINE = "\n";

    /**
     * Encoding that contains German letters.
     */
    public static final Charset GERMAN_ENCODING = StandardCharsets.ISO_8859_1;

    /**
     * Standard UTF8 encoding.
     */
    public static final Charset UTF8_ENCODING = StandardCharsets.UTF_8;

    /**
     * Extension for a given CSV reporting file.
     */
    public static final String CSV_FILE_EXTENSION = ".csv";

    /**
     * CSV column separator.
     */
    public static final String CSV_SEPARATOR = ";";

    /**
     * Whitespace character.
     */
    public static final String SPACE = " ";

    /**
     * Exception message. Occurs when there's not enough arguments.
     */
    public static final String EXCEPTION_NOT_ENOUGH_ARGUMENTS = "Not enough arguments. Expected number of arguments is 1.";

    /**
     * Exception message. Occurs when there's too many arguments.
     */
    public static final String EXCEPTION_TOO_MANY_ARGUMENTS = "Too many arguments. Expected number of arguments is 1.";

    /**
     * Exception message. Occurs when there's there are spaces in the first argument.
     */
    public static final String EXCEPTION_SPACE_NOT_ALLOWED = "Space is not allowed in the argument.";
}
