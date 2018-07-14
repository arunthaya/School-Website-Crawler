package com.example.springbootwithreactjs.controller;

import com.example.springbootwithreactjs.DAO.SchoolRepository;
import com.example.springbootwithreactjs.DAO.SchoolTable;
import com.example.springbootwithreactjs.model.MyJsoup;
import com.example.springbootwithreactjs.model.MyTika;
import com.google.gson.JsonObject;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class MyCrawlController {

    @Autowired
    SchoolRepository repository;

    public static String SEED1;

    public MyCrawlController(String seed1){
        this.SEED1 = seed1;
    }


    public void crawl(JsonObject response) throws Exception {
        String crawlStorageFolder = "~/crawlStorage";
        int numberOfCrawlers = 10;
        repository.save(new SchoolTable("carleton", "ottawa", "hello"));
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
        //config.setMaxPagesToFetch(1000);
        config.setMaxPagesToFetch(2);
        config.setMaxDepthOfCrawling(1);
        config.setIncludeHttpsPages(true);
        config.setResumableCrawling(false);
        config.setIncludeBinaryContentInCrawling(false);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        MyJsoup.getInstance().resetImageArrayJson();
        controller.addSeed(SEED1);
        controller.start(MyCrawler.class, numberOfCrawlers);
        response.addProperty("aboutData", MyCrawler.getParagraphs());
        if(MyTika.getInstance().getSchoolNameCurrent() == null) {
            response.addProperty("aboutTitle", MyCrawler.getTitle());
        } else {
            response.addProperty("aboutTitle", MyTika.getInstance().getSchoolNameCurrent());
        }
        response.addProperty("images", MyJsoup.getInstance().getImageArrayJson().toString());
        //response.add("images", MyJsoup.getInstance().getImages());
        //System.out.println(MyJsoup.getInstance().getImages().toString());
        System.out.println("response obj is: "+response.toString());
    }

}
