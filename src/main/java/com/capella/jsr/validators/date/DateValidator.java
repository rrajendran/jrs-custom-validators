package com.capella.jsr.validators.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 *
 *
 * @author Ramesh Rajendran
 */
public final class DateValidator {

    public static boolean isDateValid(final String dateToValidate, String dateFormat) throws ParseException {

        if(dateToValidate == null || dateToValidate.trim().length() == 0){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            sdf.parse(dateToValidate);
        } catch (ParseException e) {
            throw e;
        }

        return true;
    }

    public static LocalDate toDate(final String dateToValidate, String dateFormat) throws ParseException {

        if(dateToValidate == null || dateToValidate.trim().length() == 0){
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            return asLocalDate(sdf.parse(dateToValidate));
        } catch (ParseException e) {
            throw e;
        }

    }

    /**
     * Calls {@link #asLocalDate(Date, ZoneId)} with the system default time zone.
     */
    public static LocalDate asLocalDate(java.util.Date date) {
        return asLocalDate(date, ZoneId.systemDefault());
    }

    /**
     * Creates {@link LocalDate} from {@code java.util.Date} or it's subclasses. Null-safe.
     */
    public static LocalDate asLocalDate(java.util.Date date, ZoneId zone) {
        if (date == null)
            return null;

        if (date instanceof java.sql.Date)
            return ((java.sql.Date) date).toLocalDate();
        else
            return Instant.ofEpochMilli(date.getTime()).atZone(zone).toLocalDate();
    }

    /**
     * Is date in range for given two dates.
     * @param fieldStartDate
     * @param fieldEndDate
     * @param format
     * @return
     * @throws ParseException
     */
    public static boolean isDatesInRange(String fieldStartDate, String fieldEndDate, String format) throws ParseException {
        if(isDateValid(fieldStartDate,format) && isDateValid(fieldEndDate,format)){
            LocalDate startDate = toDate(fieldStartDate,format);
            LocalDate endDate = toDate(fieldEndDate,format);
            return startDate.isBefore(endDate);
        }
        return false;
    }

}
