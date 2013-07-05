package com.malinecs.test;

import com.malinecs.Article;
import com.malinecs.inapi_controller.impl.InApiImplementation;

/**
 * Created with IntelliJ IDEA.
 * User: hoshi~
 * Date: 7/5/13
 * Time: 4:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class InApiTest {
    public static void main(String[] args) {
        for(Article a : InApiImplementation.instance.getArticles(0))
            System.out.println(a.getTitle());
    }
}
