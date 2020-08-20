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
	private Test01 scrapTasklet01;
	@Autowired
	private Test02 scrapTasklet02;
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}
	
	@Bean(name = "scrapJob01")
	public Job scrapJob01() {
		return jobBuilderFactory.get("scrapJob01")
			       .start(scrapTasklet01())
			       .build();
	}
	
	@Bean(name = "scrapJob02")
	public Job scrapJob02() {
		return jobBuilderFactory.get("scrapJob02")
			       .start(scrapTasklet02())
			       .build();
	}
	
	@Bean
	public Step scrapTasklet01() {
		return stepBuilderFactory.get("scrapTasklet01")
			       .tasklet(scrapTasklet01)
			       .build();
	}
	
	@Bean
	public Step scrapTasklet02() {
		return stepBuilderFactory.get("scrapTasklet02")
			       .tasklet(scrapTasklet02)
			       .build();
	}
	
	
	
	
}
