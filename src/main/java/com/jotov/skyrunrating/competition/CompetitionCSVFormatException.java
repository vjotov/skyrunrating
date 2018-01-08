package com.jotov.skyrunrating.competition;

public class CompetitionCSVFormatException extends Exception {

    enum FORMAT_ERROR {
        COMPETITION_HEADER_MISSING_COLUMNS,
        COMPETITION_HEADER_WRONG_COLUMN_ORDER,
        COMPETITION_DATA_MISSING_COLUMNS,
        COMPETITION_DATA_WRONG_COLUMN_FORMAT,
        RUNNER_HEADER_MISSING_COLUMNS,
        RUNNER_HEADER_WRONG_COLUMN_ORDER,
        RUNNER_DATA_MISSING_COLUMNS,
        RUNNER_DATA_WRONG_COLUMN_FORMAT
    }

    FORMAT_ERROR error_type;
    private long error_line;

    public CompetitionCSVFormatException(FORMAT_ERROR error_type, long error_line) {
        this.error_type = error_type;
        this.error_line = error_line;
    }

}
