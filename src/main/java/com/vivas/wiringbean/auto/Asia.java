package com.vivas.wiringbean.auto;

import org.springframework.stereotype.Component;

/**
 * Created by duyot on 8/11/2016.
 */
@Component
public class Asia {
    private String title = "Asia top 100";
    private String artist = "Various artists";

    public void play() {
        System.out.println("You're listening from "+ title + " performed by "+ artist);
    }
}
