# egovframe.rte.3.5

## 실행환경 구성 (egovframe.rte)

1. Batch - 배치처리 (bat)

2. Foundation - 공통기반 (fdl)
 - cmmn : 공통
 - crypt : 암호화
 - excel : 엑셀처리
 - filehandling : 파일처리
 - idgnr : uuid 생성
 - logging : 로그처리
 - property : 속성관리
 - security : 보안 (로그인, 인증, 접근제어)
 - string : 문자열처리
 - xml : xml 처리 (Manipulation)
3. Integration - 연계통합 (itl)
 - integration : 메타데이터연계
 - webservice : 웹 서비스 연계
4. Persistence - 데이터처리 (psl)
 - jpa
 - mongodb
 - dataaccess : ORM
5. Presentation - 화면처리 (ptl)
 - mvc : model-view-contriller
 - spring-modules-validation : 입력유효성
 
## 빌드방법
 전체빌드 : 메인에 있는 pom.xml을 mvn install 수행
 개별빌드 : 디렉터리 안에 pom.xml 을 직접 mvn install 실행
