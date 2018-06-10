package com.example.springbootwithreactjs.controller;

import com.google.gson.JsonObject;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.util.HashMap;

public class MyCrawlController {

    public static String SEED1;
    public static MyCrawlController instance;

    private MyCrawlController(String seed1){
        this.SEED1 = seed1;
    }

    public static MyCrawlController getInstance(String seed){
        if(instance == null){
            instance = new MyCrawlController(seed);
        }
        return instance;
    }

    public static void crawl(JsonObject response) throws Exception {
        String crawlStorageFolder = "~/crawlStorage";
        int numberOfCrawlers = 10;

        CrawlConfig config = new CrawlConfig();
//        config.setCrawlStorageFolder(crawlStorageFolder);
//        config.setPolitenessDelay(150);
//        config.setMaxPagesToFetch(500);
//        config.setIncludeHttpsPages(true);
//        config.setResumableCrawling(false);
//        config.setIncludeBinaryContentInCrawling(true);

        /*CrawlConfig config for testing */
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setPolitenessDelay(10);
        config.setMaxPagesToFetch(1000);
        config.setMaxDepthOfCrawling(3);
        config.setIncludeHttpsPages(true);
        config.setResumableCrawling(false);
        config.setIncludeBinaryContentInCrawling(false);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.addSeed(SEED1);
        controller.start(MyCrawler.class, numberOfCrawlers);
        response.addProperty("aboutData", MyCrawler.getParagraphs());
        response.addProperty("aboutTitle", MyCrawler.getTitle());
    }

}
