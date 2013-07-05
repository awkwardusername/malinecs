/*
 * InApi.JAVA
 * Source file containing the definition of InApi.
 * Date: 2013-07-05
 * Time: 00:10
 */

package com.malinecs.inapi_controller;

import com.malinecs.Article;

import java.util.Date;

/**
 * Interface for communicating with the Bing(TM) APIs.
 * @author Temoto-kun
 */
public interface InApi {
    /**
     * Gets the articles filtered by a specific country.
     * @param countryCode A number than corresponds to a country.
     * @param searchTerms Additional search terms.
     * @return Array containing the articles that have been filtered out by the specified country.
     */
    public Article[] getArticles(int countryCode, String... searchTerms);

    /**
     * Gets the articles filtered by a specific date.
     * @param date A date
     * @param searchTerms Additional search terms.
     * @return Array containing the articles that have been filtered out by the specified date
     *         (since 00:00-23:59, regardless of the time zone [as seen in the articles themselves]).
     */
    public Article[] getArticles(Date date, String... searchTerms);

    /**
     * Gets the articles filtered by a specific date range.
     * @param from Start date
     * @param to End date
     * @return Array containing the articles that have been filtered out by the specified date range
     *         (since 00:00 of start date to 23:59 of the end date, regardless of the time zone [as seen in the
     *         articles themselves]).
     */
    public Article[] getArticles(Date from, Date to);

    /**
     * Gets the articles filtered by a specific countryCode and date.
     * @param countryCode A number that corresponds to a countryCode
     * @param date A date
     * @return Array containing the articles that have been filtered out by the specified countryCode and date.
     * @see #getArticles(int)
     * @see #getArticles(java.util.Date)
     */
    public Article[] getArticles(int countryCode, Date date);

    /**
     * Gets the articles filtered by a specific countryCode and date range.
     * @param countryCode A number that corresponds to a countryCode
     * @param from Start date
     * @param to End date
     * @return Array containing the articles that have been filtered out by the specified countryCode and date range.
     * @see #getArticles(int)
     * @see #getArticles(java.util.Date, java.util.Date)
     */
    public Article[] getArticles(int countryCode, Date from, Date to);
}
