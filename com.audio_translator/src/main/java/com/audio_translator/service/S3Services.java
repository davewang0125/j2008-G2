package com.audio_translator.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class S3Services {
    private Logger logger = LoggerFactory.getLogger(S3Services.class);

    @Autowired
    private AmazonS3 s3client;

    @Value("${lzhuoru0.s3.bucket}")
    private String bucketName;

    public void uploadFile(String keyName, MultipartFile file) {

        try {
            File f = new File("/Users/zhuoruli/Desktop/testFile/" + keyName);
            file.transferTo(f);
            s3client.putObject(new PutObjectRequest(bucketName, keyName, f));
            logger.info("===================== Upload File - Done! =====================");
        } catch (AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
            logger.info("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.info("AWS Error Code:   " + ase.getErrorCode());
            logger.info("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
