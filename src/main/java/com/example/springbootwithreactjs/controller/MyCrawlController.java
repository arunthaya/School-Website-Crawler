package com.example.springbootwithreactjs.controller;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

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

    public static boolean crawl() throws Exception {
        String crawlStorageFolder = "~/crawlStorage";
        int numberOfCrawlers = 10;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setPolitenessDelay(200);
        config.setMaxPagesToFetch(300);
        config.setIncludeHttpsPages(true);
        config.setResumableCrawling(false);
        config.setIncludeBinaryContentInCrawling(true);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.addSeed(SEED1);
        controller.start(MyCrawler.class, numberOfCrawlers);
        return false;
    }

}