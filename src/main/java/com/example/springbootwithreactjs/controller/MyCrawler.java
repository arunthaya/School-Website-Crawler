package com.example.springbootwithreactjs.controller;

import com.example.springbootwithreactjs.database.MongoDB;
import com.example.springbootwithreactjs.model.MyTika;
import com.mongodb.BasicDBObject;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.regex.Pattern;

public class MyCrawler extends WebCrawler {

    private Date startTime;
    private Date endTime;

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|vcf|ico" + "|mid|mp2|mp3|mp4"
            + "|wav|avi|mov|mpeg|ram|m4v" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {

        endTime = new Date();

        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && (href.startsWith(MyCrawlController.SEED1));
    }

    @Override
    public void visit(Page page){
        System.out.println("currently crawling and checking "+page.getWebURL().getURL());
        this.getMyController().getConfig().setPolitenessDelay(200);
        startTime = new Date();
        int docid = page.getWebURL().getDocid();
        BasicDBObject pageToStore = new BasicDBObject();
        pageToStore.append(MongoDB.URL, page.getWebURL().getURL());
        boolean aboutUsPage = false;
        URL url = null;
        try{
            url = new URL(page.getWebURL().getURL());
        } catch(MalformedURLException e1){
            e1.printStackTrace();
        }
        aboutUsPage = MyTika.getInstance().validAboutUsPage(url);
        if(aboutUsPage){
            System.out.println("Found a valid about us page");
            MyTika.getInstance().store(url,pageToStore);
            MongoDB.getInstance().addBasicDBObject(pageToStore);
        }
    }




}

