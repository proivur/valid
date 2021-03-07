package com.validtest.shared.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateUtils {

    private static final Logger LOG = LogManager.getLogger(DateUtils.class);

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String SHORT_PATTERN = "MM/dd/yyyy";

    private DateUtils () {
    }

    public static Date parseDate(String dateString, String pattern) {
        LOG.debug(dateString);
        LOG.debug(pattern);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);

            return sdf.parse(dateString);
        } catch (Exception ex) {
            LOG.error(ex, ex);

            return null;
        }
    }

    public static Date defaultParseDate(String dateString) {
        LOG.debug(dateString);
        LOG.debug(DEFAULT_PATTERN);

        return dateString != null ? parseDate(dateString, DEFAULT_PATTERN) : null;
    }

    public static String formatDate(Date date, String pattern) {
        LOG.debug(date);
        LOG.debug(pattern);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);

            return date != null ? sdf.format(date) : null;
        } catch (Exception ex) {
            LOG.error(ex, ex);

            return null;
        }
    }

    public static String defaultFormatDate(Date date) {
        LOG.debug(date);
        LOG.debug(DEFAULT_PATTERN);

        return date != null ? formatDate(date, DEFAULT_PATTERN) : null;
    }

    public static String getCurrentLocalDateTime () {
        ZoneId denverTimeZone = ZoneId.systemDefault();
        LocalDateTime ldt = LocalDateTime.ofInstant(new Date().toInstant(), denverTimeZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = ldt.format(formatter);

        return formattedDateTime;
    }

    public static Date getCurrentLocalDateTimeTZ () {
        ZoneId denverTimeZone = ZoneId.of( "US/Eastern" );
        LocalDateTime ldt = LocalDateTime.ofInstant(new Date().toInstant(), denverTimeZone);

        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }

}
