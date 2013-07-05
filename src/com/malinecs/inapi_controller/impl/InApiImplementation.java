/*
 * InApiImplementation.JAVA
 * Source file containing the class definition of the InApi implementation.
 * Date: 2013-07-05
 * Time: 00:55
 */

package com.malinecs.inapi_controller.impl;

import com.google.code.bing.search.client.BingSearchClient;
import com.google.code.bing.search.client.BingSearchServiceClientFactory;
import com.google.code.bing.search.schema.AdultOption;
import com.google.code.bing.search.schema.SearchOption;
import com.google.code.bing.search.schema.SearchResponse;
import com.google.code.bing.search.schema.SourceType;
import com.google.code.bing.search.schema.web.WebResponse;
import com.google.code.bing.search.schema.web.WebResult;
import com.google.code.bing.search.schema.web.WebSearchOption;
import com.google.code.bing.search.schema.web.WebSearchTag;
import com.malinecs.Article;
import com.malinecs.inapi_controller.InApi;

import java.util.*;

/**
 * Class of the implementation of InApi.
 * @author Temoto-kun
 */
public class InApiImplementation implements InApi {
    BingSearchServiceClientFactory factory = BingSearchServiceClientFactory.newInstance();
    BingSearchClient client = factory.createBingSearchClient();
    BingSearchClient.SearchRequestBuilder builder = client.newSearchRequestBuilder();
    long searchLimit = 20L;

    /**
     * Gets the market from a country code.
     * @param country A number representing a country
     * @return String representing a market
     */
    private String getMarket(int country) {
        switch(country) {
            case 0: return "en-PH";
        }
        return "en-PH";
    }

    /**
     * Gets the country with the specified code.
     * @param code A number
     * @return String representing a country name that corresponds to the number
     */
    private String getCountry(int code) {
        if(code == 0)
            return "Philippines";
        return "";
    }

    private void init() {
        builder.withAppId("vdn/LbmRRNVb/ChKdXbi6dDNx+IxrsqiiMVLKxJ6RHA");
        builder.withSourceType(SourceType.WEB);
        builder.withVersion("2.0");
        builder.withAdultOption(AdultOption.MODERATE);
        //builder.withSearchOption(SearchOption.ENABLE_HIGHLIGHTING); // uncomment this to enable highlighting

        builder.withWebRequestCount(searchLimit);
        builder.withWebRequestOffset(0L);
        builder.withWebRequestSearchOption(WebSearchOption.DISABLE_HOST_COLLAPSING);
        builder.withWebRequestSearchOption(WebSearchOption.DISABLE_QUERY_ALTERATIONS);
    }

    public static InApiImplementation instance = new InApiImplementation();

    private InApiImplementation() {
        factory = BingSearchServiceClientFactory.newInstance();
        client = factory.createBingSearchClient();
        builder = client.newSearchRequestBuilder();

        init();
    }

    private Article[] doSearch() {
        List<Article> articles = new LinkedList<>();
        SearchResponse response = client.search(builder.getResult());
        WebResponse webResponse = response.getWeb();
        List<WebResult> results = webResponse.getResults();

        for (WebResult result : results) {
            // TODO get article tags
            List<WebSearchTag> searchTags = result.getSearchTags();

            Article a = new Article(result.getTitle(), result.getUrl(), result.getDateTime(), result.getDescription());
            articles.add(a);
        }
        return (Article[]) articles.toArray();
    }

    /**
     * Gets the articles filtered by a specific country.
     * @param countryCode A number than corresponds to a country.
     * @param searchTerms Additional search terms.
     * @return Array containing the articles that have been filtered out by the specified country.
     * @see InApi#getArticles(int, String...)
     */
    @Override
    public Article[] getArticles(int countryCode, String... searchTerms) {
        StringBuilder query = new StringBuilder(getCountry(countryCode));
        for(String searchTerm : searchTerms)
            query.append(" " + searchTerm);

        builder.withMarket(getMarket(countryCode));
        builder.withQuery(query.toString());

        return doSearch();
    }

    /**
     * Gets the articles filtered by a specific date.
     * @param date A date
     * @param searchTerms Additional search terms.
     * @return Array containing the articles that have been filtered out by the specified date
     *         (since 00:00-23:59, regardless of the time zone [as seen in the articles themselves]).
     * @see InApi#getArticles(java.util.Date, String...)
     */
    @Override
    public Article[] getArticles(Date date, String... searchTerms) {
        /*
        List<Article> articles = new LinkedList<>();

        // TODO limit articles to specified date only.
        builder.withQuery(date.toString());

        return doSearch();
        */

        return null;
    }

    /**
     * Gets the articles filtered by a specific date range.
     * @param from Start date
     * @param to End date
     * @return Array containing the articles that have been filtered out by the specified date range
     *         (since 00:00 of start date to 23:59 of the end date, regardless of the time zone [as seen in the
     *         articles themselves]).
     * @see InApi#getArticles(java.util.Date, java.util.Date)
     */
    @Override
    public Article[] getArticles(Date from, Date to) {
        // TODO this
        return null;
    }

    /**
     * Gets the articles filtered by a specific country and date.
     * @param countryCode A number than corresponds to a country.
     * @param date A date
     * @return Array containing the articles that have been filtered out by the specified country and date.
     * @see InApi#getArticles(int, java.util.Date)
     */
    @Override
    public Article[] getArticles(int countryCode, Date date) {
        // TODO this
        return null;
    }

    /**
     * Gets the articles filtered by a specific country and date range.
     * @param countryCode A number than corresponds to a country.
     * @param from Start date
     * @param to End date
     * @return Array containing the articles that have been filtered out by the specified country and date range.
     * @see InApi#getArticles(int, java.util.Date, java.util.Date)
     */
    @Override
    public Article[] getArticles(int countryCode, Date from, Date to) {
        // TODO this
        return null;
    }
}
