package com.malinecs.test;

/**
 * Created with IntelliJ IDEA.
 * User: hoshi~
 * Date: 7/5/13
 * Time: 4:48 AM
 * To change this template use File | Settings | File Templates.
 */
/*

 * Copyright 2010 Nabeel Mukhtar

 *

 * Licensed under the Apache License, Version 2.0 (the "License");

 * you may not use this file except in compliance with the License.

 * You may obtain a copy of the License at

 *

 *  http://www.apache.org/licenses/LICENSE-2.0

 *

 * Unless required by applicable law or agreed to in writing, software

 * distributed under the License is distributed on an "AS IS" BASIS,

 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

 * See the License for the specific language governing permissions and

 * limitations under the License.

 *

 */


import java.text.MessageFormat;


import org.apache.commons.cli.BasicParser;

import org.apache.commons.cli.CommandLine;

import org.apache.commons.cli.HelpFormatter;

import org.apache.commons.cli.Option;

import org.apache.commons.cli.OptionBuilder;

import org.apache.commons.cli.Options;

import org.apache.commons.cli.ParseException;


import com.google.code.bing.search.client.BingSearchClient;

import com.google.code.bing.search.client.BingSearchServiceClientFactory;

import com.google.code.bing.search.client.BingSearchClient.SearchRequestBuilder;

import com.google.code.bing.search.schema.AdultOption;

import com.google.code.bing.search.schema.SearchRequest;

import com.google.code.bing.search.schema.SearchResponse;

import com.google.code.bing.search.schema.SourceType;

import com.google.code.bing.search.schema.multimedia.ImageResult;


/**
 * The Class ImageSample.
 */

public class ImageSample {


    /**
     * The Constant APPLICATION_KEY_OPTION.
     */

    private static final String APPLICATION_KEY_OPTION = "appid";


    /**
     * The Constant QUERY_OPTION.
     */

    private static final String QUERY_OPTION = "query";


    /**
     * The Constant HELP_OPTION.
     */

    private static final String HELP_OPTION = "help";


    /**
     * The main method.
     *
     * @param args
     *         the arguments
     */

    public static void main(String[] args) {

        Options options = buildOptions();

        try {

            CommandLine line = new BasicParser().parse(options, args);

            processCommandLine(line, options);

        } catch (ParseException exp) {

            System.err.println(exp.getMessage());

            printHelp(options);

        }

    }


    /**
     * Process command line.
     *
     * @param line
     *         the line
     * @param options
     *         the options
     */

    private static void processCommandLine(CommandLine line, Options options) {

        if (line.hasOption(HELP_OPTION)) {

            printHelp(options);

        } else if (line.hasOption(APPLICATION_KEY_OPTION) && line.hasOption(QUERY_OPTION)) {

            BingSearchServiceClientFactory factory = BingSearchServiceClientFactory.newInstance();

            BingSearchClient client = factory.createBingSearchClient();

            SearchResponse response = client.search(createSearchRequest(client, line.getOptionValue(APPLICATION_KEY_OPTION), line.getOptionValue(QUERY_OPTION)));

            printResponse(response);

        } else {

            printHelp(options);

        }

    }


    /**
     * Prints the response.
     *
     * @param response
     *         the response
     */

    private static void printResponse(SearchResponse response) {

        System.out.println("Bing API Version " + response.getVersion());

        System.out.println("Image results for " + response.getQuery().getSearchTerms());

        for (ImageResult result : response.getImage().getResults()) {

            System.out.println(result.getMediaUrl());

            System.out.println("Page Title: " + result.getTitle());

            System.out.println("Page URL: " + result.getUrl());

            System.out.println("Dimensions: "

                    + result.getWidth()

                    + "x"

                    + result.getHeight());

            System.out.println("Thumbnail URL: " + result.getThumbnail().getUrl());

        }

    }


    /**
     * Creates the search request.
     *
     * @param client
     *         the client
     * @param applicationId
     *         the application id
     * @param query
     *         the query
     * @return the search request
     */

    private static SearchRequest createSearchRequest(BingSearchClient client, String applicationId, String query) {

        SearchRequestBuilder builder = client.newSearchRequestBuilder();

        builder.withAppId(applicationId);

        builder.withQuery(query);

        builder.withSourceType(SourceType.IMAGE);

        builder.withVersion("2.0");

        builder.withMarket("en-us");

        builder.withAdultOption(AdultOption.MODERATE);

        builder.withImageRequestCount(10L);

        builder.withImageRequestOffset(0L);


        return builder.getResult();

    }


    /**
     * Builds the options.
     *
     * @return the options
     */

    private static Options buildOptions() {


        Options opts = new Options();


        String helpMsg = "Print this message.";

        Option help = new Option(HELP_OPTION, helpMsg);

        opts.addOption(help);


        String applicationKeyMsg = "You Application ID.";

        OptionBuilder.withArgName("appid");

        OptionBuilder.hasArg();

        OptionBuilder.withDescription(applicationKeyMsg);

        Option applicationKey = OptionBuilder.create(APPLICATION_KEY_OPTION);

        opts.addOption(applicationKey);


        String queryMsg = "Search Query.";

        OptionBuilder.withArgName("query");

        OptionBuilder.hasArg();

        OptionBuilder.withDescription(queryMsg);

        Option query = OptionBuilder.create(QUERY_OPTION);

        opts.addOption(query);


        return opts;

    }


    /**
     * Prints the help.
     *
     * @param options
     *         the options
     */

    private static void printHelp(Options options) {

        int width = 80;

        String syntax = ImageSample.class.getName() + " <options>";

        String header = MessageFormat.format("\nThe -{0} and -{1} options are required. All others are optional.", APPLICATION_KEY_OPTION, QUERY_OPTION);

        String footer = "";

        new HelpFormatter().printHelp(width, syntax, header, options, footer, false);

    }

}

