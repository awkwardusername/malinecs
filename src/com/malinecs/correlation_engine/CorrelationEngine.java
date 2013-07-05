/*
 * CorrelationEngine.JAVA
 * Source file containing the definition of the class providing shared methods by the submodules of the Correlation
 * Engine (CorrEng) module of MalInECS.
 * Date: 2013-07-05
 * Time: 00:11
 */

package com.malinecs.correlation_engine;

import com.malinecs.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class providing shared methods by the submodules of the Correlation Engine (CorrEng) of MalInECS.
 * @author Temoto-kun
 */
public class CorrelationEngine {
    /**
     * The articles.
     */
    private List<Article> articles = new ArrayList<Article>();

    /**
     * The sole <code>CorrelationEngine</code> instance.
     */
    public static CorrelationEngine instance = new CorrelationEngine();

    /**
     * Creates a new instance of the <code>CorrelationEngine</code> class.
     */
    private CorrelationEngine() {}

    /**
     * Gets all the articles retrieved by the InAPI.
     * @return The articles retrieved by the InAPI
     */
    public Article[] getArticles() { return (Article[]) articles.toArray(); }

    /**
     * Gets the keywords of a specific article.
     * @param i The index of the article to extract keywords from
     * @return Array containing the keywords extracted from the article
     */
    public String[] getArticleKeywords(int i) {
        return getArticleKeywords(articles.get(i));
    }

    /**
     * Gets the keywords of a specific article instance.
     * @param a An <code>Article</code> instance
     * @return Array containing the keywords extracted from the article
     */
    public String[] getArticleKeywords(Article a) {
        // TODO this
        /*
         * This method uses the Alchemy API for keyword extraction
         */
        return null;
    }

    /**
     * Gets the keywords of a specific article.
     * @param i The index of the article to extract keywords from
     * @param keyword A string
     * @return The frequency of the specified keyword in the article
     */
    public int getArticleKeywordFrequency(int i, String keyword) {
        return getArticleKeywordFrequency(articles.get(i), keyword);
    }

    /**
     * Gets the keywords of a specific article.
     * @param a An <code>Article</code> instance
     * @param keyword A string
     * @return The frequency of the specified keyword in the article
     */
    public int getArticleKeywordFrequency(Article a, String keyword) {
        // TODO this
        /*
         * Should this method use the Alchemy API, too? If it is too simple to just count the occurrences of the
         * keyword, don't use any API, unless provided by the API.
         */
        return 0;
    }
}
