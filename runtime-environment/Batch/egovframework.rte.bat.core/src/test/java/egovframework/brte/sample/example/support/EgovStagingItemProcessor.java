/*
 * Copyright 2006-2007 the original author or authors. *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.brte.sample.example.support;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.jdbc.core.simple.SimpleJdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.util.Assert;

/**
 *  BATCH_STAGING에 processed 값 업데이트
 *
 * @param <T> item type
 *
 * @see EgovStagingItemReader
 * @see EgovStagingItemWriter
 * @see EgovProcessIndicatorItemWrapper
 *
 */
@SuppressWarnings("deprecation")
public class EgovStagingItemProcessor<T> implements ItemProcessor<EgovProcessIndicatorItemWrapper<T>, T>, InitializingBean {

	//DB 사용을 위한  SimpleJdbcOperations
	private SimpleJdbcOperations jdbcTemplate;

	/**
	 * JdbcTemplate 세팅
	 */
	public void setJdbcTemplate(SimpleJdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * DataSource 세팅
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	/**
	 * 설정확인
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(jdbcTemplate, "Either jdbcTemplate or dataSource must be set");
	}

	/**
	 * BATCH_STAGING에 processed 값 업데이트
	 *
	 */
	@Override
	public T process(EgovProcessIndicatorItemWrapper<T> wrapper) throws Exception {

		int count = jdbcTemplate.update("UPDATE BATCH_STAGING SET PROCESSED=? WHERE ID=? AND PROCESSED=?", EgovStagingItemWriter.DONE, wrapper.getId(), EgovStagingItemWriter.NEW);

		if (count != 1) {
			throw new OptimisticLockingFailureException("The staging record with ID=" + wrapper.getId() + " was updated concurrently when trying to mark as complete (updated "
					+ count + " records.");
		}
		return wrapper.getItem();
	}

}
