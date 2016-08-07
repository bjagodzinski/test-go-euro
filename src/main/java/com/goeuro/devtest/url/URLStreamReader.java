package com.goeuro.devtest.url;

import com.goeuro.devtest.common.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static java.lang.System.err;
import static java.lang.System.exit;

/**
 * Class responsible for communication with the given URLs over the network.
 *
 * Created by bjagodzinski on 2016-08-04.
 */
public final class URLStreamReader {

    private URLStreamReader() {}

    /**
     * Reads the string response from the given url.
     * Uses default <code>Constants.UTF8_ENCODING</code> encoding.
     *
     * @param urlString url address responding with the string answer when queried
     * @return string answer of the url query
     *
     * @throws IOException
     */
    public static final String readFromURL(String urlString) throws IOException {

        return readFromURL(urlString, Constants.UTF8_ENCODING);
    }

    /**
     * Reads the string answer from the given url using given encoding.
     *
     * @param urlString url address responding with the string answer when queried
     * @param encoding encoding used to read the answer
     * @return string answer of the url query
     *
     * @throws IOException
     */
    public static final String readFromURL(String urlString, Charset encoding) throws IOException {

        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();

        return getStringFromURL(encoding, urlConnection);
    }

    /**
     * Reads the string answer from the given url connection.
     *
     * @param encoding encoding used to read the answer
     * @param urlConnection
     * @return
     * @throws IOException
     */
    private static String getStringFromURL(Charset encoding, URLConnection urlConnection) throws IOException {

        try ( BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( urlConnection.getInputStream(), encoding) ) ) {
            String urlText = bufferedReader.lines().collect( Collectors.joining(Constants.NEW_LINE) );
            return urlText;
        }
    }

}
