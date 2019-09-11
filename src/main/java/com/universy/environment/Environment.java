package com.universy.environment;

import com.universy.environment.exceptions.CorruptEnvironmentException;

import java.util.Optional;

public class Environment {

    private Environment() {
    }

    public static String getRegion(){
        return Optional.ofNullable(System.getProperty("region"))
                .orElseThrow(CorruptEnvironmentException::new);
    }

    public static String getProfile(){
        return Optional.ofNullable(System.getProperty("profile"))
                .orElseThrow(CorruptEnvironmentException::new);
    }

    public static String getStage(){
        return Optional.ofNullable(System.getProperty("stage"))
                .orElseThrow(CorruptEnvironmentException::new);
    }

    public static String getUserName(){
        return Optional.ofNullable(System.getProperty("user.name"))
                .orElse("user");
    }

    public static String getUserDir(){
        return Optional.ofNullable(System.getProperty("user.dir"))
                .orElseThrow(CorruptEnvironmentException::new);
    }
}
