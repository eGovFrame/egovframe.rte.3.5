/*
 * Copyright 2014 MOSPA(Ministry of Security and Public Administration).
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
package egovframework.rte.fdl.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * egov-security schema namespace 'initializer' element 처리를 담당하는 bean definition parser 클래스
 * 
 *<p>Desc.: 설정 간소화 처리에 사용되는 bean definition parser</p>
 *
 * @author Vincent Han
 * @since 2014.03.12
 * @version 3.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *   수정일				수정자		수정내용
 *  ---------------------------------------------------------------------------------
 *   2014.03.12	한성곤		Spring Security 설정 간소화 기능 추가
 * 
 * </pre>
 */
public class EgovSecurityConfigInitializerBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSecurityConfigInitializerBeanDefinitionParser.class);

	@Override
	protected Class<?> getBeanClass(Element element) {
		return SecurityConfigInitializer.class;
	}
	
	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		
		LOGGER.debug("Load '/META-INF/spring/security/security-config.xml'");
		
		parserContext.getReaderContext().getReader().loadBeanDefinitions("classpath*:/META-INF/spring/security/security-config.xml");
		
		 String supportPointcut = element.getAttribute("supportPointcut");

		if (supportPointcut.equalsIgnoreCase("true")) {
			LOGGER.debug("Load '/META-INF/spring/security/pointcut-config.xml'");
			
			parserContext.getReaderContext().getReader().loadBeanDefinitions("classpath*:/META-INF/spring/security/pointcut-config.xml");
		}
		
		String supportMethod = element.getAttribute("supportMethod");

		if (supportMethod.equalsIgnoreCase("true")) {
			LOGGER.debug("Load '/META-INF/spring/security/method-config.xml'");
			
			parserContext.getReaderContext().getReader().loadBeanDefinitions("classpath*:/META-INF/spring/security/method-config.xml");
		}
	}
}