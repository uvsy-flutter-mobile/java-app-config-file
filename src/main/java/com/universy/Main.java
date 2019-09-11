package com.universy;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.universy.environment.Environment;
import com.universy.files.ConfigFileWriter;
import com.universy.parameters.Parameters;
import com.universy.ssm.SSMParametersProvider;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            String profile = Environment.getProfile();
            String region = Environment.getRegion();
            String stage = Environment.getStage();
            String userName = Environment.getUserName();
            String userDir = Environment.getUserDir();

            System.out.println(String.format("Hello %s!", userName));
            System.out.println("We are on: " + userDir);

            System.out.println("Stage you asked: " + stage);
            System.out.println("Fetching parameters from ssm!");

            SSMParametersProvider ssmParametersProvider = new SSMParametersProvider(stage, region, profile);
            Parameters parameters = ssmParametersProvider.getParameters();

            System.out.println("Parameters fetched successfully.");
            System.out.println("Converting to json format.");

            ObjectMapper objectMapper = new ObjectMapper();
            String content = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parameters);

            System.out.println("Writing file to config folder. Almost done! :)");

            ConfigFileWriter writer = new ConfigFileWriter(content);
            writer.write();

            System.out.println(String.format("We're done here. Thank you %s!", userName));
        } catch (IOException e) {
            System.out.println(String.format("There was an error: %s. Sorry!", e.getMessage()));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(String.format("There was an error: %s.", e.getMessage()));
            System.out.println("Possible problems: \n" +
                    "- Incorrect credentials in .aws/credentials. \n" +
                    "- Incorrect configuration in .aws/config. \n" +
                    "- Stage is not correct.");
         }
    }
}
