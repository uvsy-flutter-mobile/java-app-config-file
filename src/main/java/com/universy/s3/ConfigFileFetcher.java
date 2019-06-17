package com.universy.s3;

import com.amazonaws.services.s3.model.S3Object;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ConfigFileFetcher {

    private static final String BUCKET = "flutter-app-config";
    private static final String FILE_TEMPLATE = "%s_config.json";
    private static final String DELIMITER = "\n";

    private final String stage;

    public ConfigFileFetcher(String stage) {
        this.stage = stage;
    }

    public String fetch() {
        S3Object s3ConfigFile = fetchConfigFileFromS3();
        String configFileContent = getS3ObjectContent(s3ConfigFile);
        return configFileContent;
    }

    private String getS3ObjectContent(S3Object s3Object) {
        InputStream inputStream = new BufferedInputStream(s3Object.getObjectContent());
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining(DELIMITER));
    }

    private S3Object fetchConfigFileFromS3() {
        String file = constructFileName();
        S3Fetcher fetcher = new S3Fetcher(BUCKET, file);
        return fetcher.fetch();
    }

    private String constructFileName() {
        return String.format(FILE_TEMPLATE, stage);
    }
}
