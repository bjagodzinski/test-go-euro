package com.goeuro.devtest.util;

import com.goeuro.devtest.common.Constants;

/**
 * This class contains utility methods that are
 * helpful in validation process.
 *
 * Created by bjagodzinski on 2016-08-06.
 */
public final class ValidationUtils {

    private ValidationUtils() {}

    /**
     * Validates the input arguments. If something illegal occurs
     * the method throws IllegalArgumentException (unchecked runtime exception).
     *
     * @param args input arguments of main function
     */
    public static String validateInputArguments(String... args) {

        if ( args == null || args.length == 0 ) {
            return (Constants.EXCEPTION_NOT_ENOUGH_ARGUMENTS);
        } else if ( args.length > 1 ) {
            return (Constants.EXCEPTION_TOO_MANY_ARGUMENTS);
        } else if ( args[0].split(Constants.SPACE).length > 1 ) {
            return (Constants.EXCEPTION_SPACE_NOT_ALLOWED);
        } else {
            return null;
        }
    }
}
