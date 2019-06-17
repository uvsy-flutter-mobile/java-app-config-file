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

            String userName = System.getProperty("user.name");
            String userDir = System.getProperty("user.dir");

            System.out.println(String.format("Hello %s!", userName));
            System.out.println("We are on: " + userDir);

            System.out.println("Stage you asked: " + stage);
            System.out.println("Fetching config from S3 Bucket!");
            ConfigFileFetcher fileFetcher = new ConfigFileFetcher(stage);
            String content = fileFetcher.fetch();

            if(content.isEmpty()){
                System.out.println("Config file is empty! What? Contact your AWS Admin. :(");
            } else{
                System.out.println("File retrieved successfully.");
                System.out.println("Writing file to config folder. Almost done! :)");
                ConfigFileWriter writer = new ConfigFileWriter(content);
                writer.write();
                System.out.println(String.format("We're done here. Thank you %s!", userName));

            }
        } catch (IOException e) {
            System.out.println(String.format("There was an error: %s. Sorry!", e.getMessage()));
        } catch (AmazonS3Exception e){
            System.out.println(String.format("There was an error with AWS: %s.", e.getMessage()));
            System.out.println("Possible problems: \n" +
                    "- Incorrect credentials in .aws/credentials. \n" +
                    "- Incorrect configuration in .aws/config. \n" +
                    "- Stage is not correct.");
         }
    }
}
