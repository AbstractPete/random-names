package com.github.abstractpete.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * Created by Arthur Abramov on 19.09.2015.
 *
 * @author Arthur Abramov(bc.mdstudio@gmail.com)
 * @since 0.0.1
 */
public class Utils {
    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    private final static Random random;
    static {
        random = new Random(System.currentTimeMillis());
    }

    public static String[] fillArray(InputStream is){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            List<String> buffer = new ArrayList<>();
            while ((line= reader.readLine()) != null){
                buffer.add(line);
            }
            return buffer.toArray(new String[buffer.size()]);
        }catch (IOException e){
            LOGGER.warn(e.getMessage());
            return new String[0];
        }

    }
    public static String getRandom(String[] dictionary){
        if (dictionary != null){
            return dictionary[rangeOfRandom(0,dictionary.length)];
        }else return "";
    }
    public static int rangeOfRandom(int min,int max){
        return random.nextInt((max - min)) + min;
    }
}
