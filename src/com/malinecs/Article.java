/*
 * Article.JAVA
 * Source file containing the class definitions of articles.
 * Date: 2013-07-05
 * Time: 00:18
 */

package com.malinecs;

import java.util.Date;

/**
 * Class for the article.
 * @author Temoto-kun
 */
public class Article {
    /**
     * The title of the article.
     */
    private String title;

    private String url;

    /**
     * The date when the article was written or posted.
     */
    private Date date;

    /**
     * The content of the article.
     */
    private String content;

    /**
     * The tags of the article.
     */
    private String[] tags;

    /**
     * Gets the title of the article.
     * @return The title of the article
     */
    public String getTitle() { return title; }

    public String getUrl() { return url; }

    /**
     * Gets the date when the article was written or posted.
     * @return The date when the article was written or posted
     */
    public Date getDate() { return date; }

    /**
     * Gets the content of the article.
     * @return The content of the article
     */
    public String getContent() { return content; }

    /**
     * Gets the tags of the article.
     * @return Array containing the tags of the article
     */
    public String[] getTags() { return tags; }

    private Article() {}

    /**
     * Creates a new instance of the Article class.
     * @param title The title of the article
     * @param date The date when the article was written or posted
     * @param content The content of the article
     * @param tags The tags of the article
     */
    public Article(String title, String url, Date date, String content, String... tags) {
        this.title = title;
        this.url = url;
        this.date = date;
        this.content = content;
        this.tags = tags;
    }
}
