package com.vivas.wiringbean.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by duyot on 8/11/2016.
 */
//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Scope(value = WebApplicationContext.)
public class Billboard implements CompactDisk {

    private String title;
    private String artist;
    private Resource banner;

    public Billboard() {
    }

    public void init(){
        System.out.println("Init before init bean...");
    }

    public void destroy(){
        System.out.println("Destroy before shutdown...");
    }

    public Billboard(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        showWelcome();
        System.out.println("You're listening from "+ title + " performed by "+ artist);
    }

    public void showWelcome(){

        InputStream in = null;
        try {
            in = banner.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Resource getBanner() {
        return banner;
    }

    public void setBanner(Resource banner) {
        this.banner = banner;
    }
}
