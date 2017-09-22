<h1>dependency-injection sample</h1>

<h3>빌드 및 실행</h3>
gradle runApplication
<br/><br/>


<h3>설명</h3>
Spring-context 에서 component-scan 하여 빈들을 주입시켜주는 부분을 흉내내보았다 
그냥 공부할 겸 만들어본 내용. <br/>

basePackage 밑으로 있는 @MyComponent 어노테이션을 사용한 클래스에 대해 자동 빈 생성 
@MyAutowired 를 통해 빈 필드 주입 가능. (필드로만 주입가능)
스프링의 다양한 옵션 기능 없음.<br/>

com.jess.di.project 하위의 클래스가 일반 스프링을 사용하는 어플리케이션 코드
com.jess.di 패키지(project 패키지 제외)가 spring-context 와 같은 부분<br/><br/> 


<h3>보완사항</h3>
그 어떠한 추가 옵션 기능없이 주입만 가능한 상태이다. 
시간이 된다면 기능을 추가해보아야겠다. 코드도 좀 깔끔하게...