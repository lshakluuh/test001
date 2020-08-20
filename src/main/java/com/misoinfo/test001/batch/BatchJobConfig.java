package com.misoinfo.test001.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchJobConfig {
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public BatchConfigurer batchConfigurer() {
		return new InMemoryBatchConfigurer();
	}
	
	@Autowired
	private Test01 scrapTasklet;
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}
	
	@Bean(name = "scrapJob")
	public Job scrapJob() {
		return jobBuilderFactory.get("scrapJob")
			       .start(scrapTasklet())
			       .build();
	}
	
	@Bean
	public Step scrapTasklet() {
		return stepBuilderFactory.get("scrapTasklet")
			       .tasklet(scrapTasklet)
			       .build();
	}
	
	
	
	
}
