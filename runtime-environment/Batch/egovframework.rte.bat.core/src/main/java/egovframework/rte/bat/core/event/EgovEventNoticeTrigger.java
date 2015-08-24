/*
 * Copyright 2012-2014 MOSPA(Ministry of Security and Public Administration).
 *  
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
package egovframework.rte.bat.core.event;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;

/**
 * EventNoticeTrigger 인터페이스를 최소한으로 구현한 클래스
 * 
 * @author 배치실행개발팀
 * @since 2012.06.27
 * @version 1.0
 * @see <pre>
 *      개정이력(Modification Information)
 *   
 *   수정일      수정자           수정내용
 *  ------- -------- ---------------------------
 *  2012.06.27  배치실행개발팀     최초 생성
 * </pre>
 */

public class EgovEventNoticeTrigger implements EventNoticeTrigger {

	/**
	 * 파라메터 없이 invoke 하는 Function Call 메서드
	 */
	public void invoke() {
	}

	/**
	 * StepExecution 을 파라메터 받는 Function Call 메서드
	 */
	public void invoke(StepExecution stepExecution) {
	}

	/**
	 * JobExecution 을 파라메터 받는 Function Call 메서드
	 */
	public void invoke(JobExecution jobExecution) {
	}

	/**
	 * Exception 을 파라메터 받는 Function Call 메서드
	 */
	public void invoke(Exception exception) {
	}
}
