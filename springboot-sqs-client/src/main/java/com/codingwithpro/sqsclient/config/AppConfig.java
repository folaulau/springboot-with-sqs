package com.codingwithpro.sqsclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig {

	@Value("${targetRegion:us-west-2}")
	private String targetRegion;

	private Regions getTargetRegion() {
		return Regions.fromName(targetRegion);
	}

	@Bean
	public AWSCredentialsProvider amazonAWSCredentials() {
		log.info("Region {}", getTargetRegion().getName());
//		return DefaultAWSCredentialsProviderChain.getInstance();
		// use datappraise
		return new ProfileCredentialsProvider("datappraise");
	}

	@Bean
	public AmazonSQS amazonSQS() {
		log.info("SQS {}", "sqs." + getTargetRegion().getName() + ".amazonaws.com");
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withCredentials(amazonAWSCredentials())
				.withEndpointConfiguration(new EndpointConfiguration(
						"sqs." + getTargetRegion().getName() + ".amazonaws.com", getTargetRegion().getName()))
				.build();
		return sqs;
	}

}
