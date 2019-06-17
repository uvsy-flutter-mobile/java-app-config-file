package com.universy.s3;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class S3Fetcher {

    private static final String REGION = "sa-east-1";
    private final String bucket;
    private final String file;


    public S3Fetcher(String bucket, String file) {
        this.bucket = bucket;
        this.file = file;
    }

    public S3Object fetch() {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(REGION)
                .withCredentials(new ProfileCredentialsProvider())
                .build();

        return s3Client.getObject(new GetObjectRequest(bucket, file));
    }
}
