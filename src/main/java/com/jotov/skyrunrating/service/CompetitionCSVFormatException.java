package com.jotov.skyrunrating.service;

import java.util.ResourceBundle;

public class CompetitionCSVFormatException extends Exception {

    public enum FORMAT_ERROR {
        COMPETITION_HEADER_MISSING_COLUMNS,
        COMPETITION_HEADER_WRONG_COLUMN_ORDER,
        COMPETITION_DATA_MISSING_COLUMNS,
        COMPETITION_DATA_WRONG_COLUMN_FORMAT,
        RUNNER_HEADER_MISSING_COLUMNS,
        RUNNER_HEADER_WRONG_COLUMN_ORDER,
        RUNNER_DATA_MISSING_COLUMNS,
        RUNNER_DATA_WRONG_COLUMN_FORMAT;

        /** Resources for the default locale */
        private static final ResourceBundle res =
                ResourceBundle.getBundle("messages");

        /** @return the locale-dependent message */
        public String toString() {
            return res.getString(name());
        }
    }

    FORMAT_ERROR error_type;
    private long error_line;

    public CompetitionCSVFormatException(FORMAT_ERROR error_type, long error_line) {
        this.error_type = error_type;
        this.error_line = error_line;
    }

    @Override
    public String getMessage() {
        return error_type.toString() + " on line " + error_line;
    }

}
