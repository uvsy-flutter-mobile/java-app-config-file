package com.universy;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.universy.files.ConfigFileWriter;
import com.universy.s3.ConfigFileFetcher;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        if(args.length != 1) {
            System.out.println("You must specify the stage and only the stage!");
            return;
        }

        String stage = args[0];

        try {
            System.out.println("Working on: " + System.getProperty("user.dir"));

            System.out.println("Stage: " + stage);
            System.out.println("Fetching config from S3 Bucket");
            ConfigFileFetcher fileFetcher = new ConfigFileFetcher(stage);
            String content = fileFetcher.fetch();

            if(content.isEmpty()){
                System.out.println("Config file is empty!");
            } else{
                System.out.println("File retrieved successfully.");
                System.out.println("Writing file to config folder.");
                ConfigFileWriter writer = new ConfigFileWriter(content);
                writer.write();
            }
        } catch (IOException e) {
            System.out.println("There was an error: " + e.getMessage());
        } catch (AmazonS3Exception e){
            System.out.println("The stage may not be valid. Try another.");
        }
    }
}
