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

/**
 * 샘플을 수행하기 위해 필요한 랩퍼
 * 
 * @author 배치실행개발팀
 * @since 2012. 07.25
 * @version 1.0
 * @see <pre>
 *      개정이력(Modification Information)
 *   
 *   수정일      수정자           수정내용
 *  ------- -------- ---------------------------
 *  2012. 07.25  배치실행개발팀     최초 생성
 *  </pre>
 */

public class EgovProcessIndicatorItemWrapper<T> {

	private long id;

	private T item;

	/**
	 * EgovProcessIndicatorItemWrapper 생성자
	 * id와 item을 설정한다.
	 * @param id
	 * @param item
	 */
	public EgovProcessIndicatorItemWrapper(long id, T item) {
		this.id = id;
		this.item = item;
	}

	/**
	 * id를 가져온다
	 * @return id 
	 */
	public long getId() {
		return id;
	}

	/**
	 * item을 가져온다
	 * @return item 
	 */
	public T getItem() {
		return item;
	}
}
