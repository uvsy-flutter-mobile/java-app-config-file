package com.universy;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.universy.environment.Environment;
import com.universy.files.ConfigFileWriter;
import com.universy.parameters.Parameters;
import com.universy.parameters.analyzer.AnalyzerResult;
import com.universy.parameters.analyzer.ParametersAnalyzer;
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

            System.out.printf("Hello %s!\n", userName);
            System.out.println("We are on: " + userDir);

            System.out.println("Stage you asked: " + stage);
            System.out.println("Fetching parameters from ssm!");

            SSMParametersProvider ssmParametersProvider = new SSMParametersProvider(stage, region, profile);
            Parameters parameters = ssmParametersProvider.getParameters();

            System.out.print("Analyzing result...");

            ParametersAnalyzer analyzer = new ParametersAnalyzer();
            AnalyzerResult analyzerResult = analyzer.analyze(parameters);

            if(analyzerResult.isValid()){
                System.out.println("Parameters fetched successfully.");
                System.out.println("Converting to json format.");

                ObjectMapper objectMapper = new ObjectMapper();
                String content = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parameters);

                System.out.println("Writing file to config folder. Almost done! :)");

                ConfigFileWriter writer = new ConfigFileWriter(content);
                writer.write();
                System.out.println(String.format("We're done here. Thank you %s!", userName));
            } else {
                System.out.println("Parameters were not fetched successfully");
                System.out.printf("For stage [%s] in region [%s] with profile [%s], " +
                                "this are the missing parameters: \n\n",
                        stage, region, profile);
                analyzerResult.getMissingParameters().forEach(System.out::println);
            }


        } catch (IOException e) {
            System.out.println(String.format("There was an error: %s. Sorry!", e.getMessage()));
        } catch (Exception e){
            System.out.println(String.format("There was an error: %s.", e.getMessage()));
            System.out.println("Possible problems: \n" +
                    "- Incorrect credentials in ~/.aws/credentials. \n" +
                    "- Incorrect configuration in ~/.aws/config.");
         }
    }
}
