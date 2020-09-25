//package com.audio_translator.config;
//
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class S3Config {
//
//    @Value("lzhuoru0.aws.access_key_id")
//    private String awsId;
//
//    @Value("lzhuoru0.aws.secret_access_key")
//    private String awsKey;
//
//    @Value("lzhuoru0.s3.region")
//    private String region;
//
//    public AmazonS3 s3client() {
//        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
//        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                .withRegion(Regions.fromName(region))
//                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                .build();
//
//        return s3Client;
//    }
//}
