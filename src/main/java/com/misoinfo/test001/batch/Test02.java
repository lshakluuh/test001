package com.misoinfo.test001.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Test02 implements Tasklet, InitializingBean {
	
	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
		log.info("test02");
		log.info("test02");
		log.info("test02");
		log.info("test02");
		log.info("test02");
		log.info("test02");
		return RepeatStatus.FINISHED;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
	
	}
}
