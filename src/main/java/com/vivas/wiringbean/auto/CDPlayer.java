package com.vivas.wiringbean.auto;

import com.vivas.utils.BundleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by duyot on 8/11/2016.
 */
@Component(value = "cdplayer")
@Profile("prod")
public class CDPlayer {
    @Autowired
    private CompactDisk cd;

    public CDPlayer() {
    }

    public CDPlayer(CompactDisk cd) {
        this.cd = cd;
    }

    public void play(){
        cd.play();
    }

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","prod");
        System.setProperty("default.artist","cho hoan");

        Locale.setDefault(new Locale("vi", "VN"));
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");

        DataSource cdPlayer = (DataSource) context.getBean("dataSource");
        System.out.println(cdPlayer.toString());

        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
//        System.out.println(cdPlayer.toString());
//        Billboard billboard = (Billboard) context.getBean("billboard");
//        Billboard billboard = context.getBean("billboard",Billboard.class);
//        cdPlayer.play();
//        billboard.play();
//        System.out.println(BundleUtils.getString("language"));
//
//        Locale.setDefault(new Locale("en","US"));
//        System.out.println(BundleUtils.getString("language"));
//        System.exit(0);
    }
}
