package hello.core.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import hello.core.scope.PrototypeTest.PrototypeBean;

public class SingletonTest {

	@Test
	void singletonBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
		SingletonBean bean1 = ac.getBean(SingletonBean.class);
		SingletonBean bean2 = ac.getBean(SingletonBean.class);
		System.out.println("bean1 :"+bean1);
		System.out.println("bean2 :"+bean2);
		Assertions.assertThat(bean1).isSameAs(bean2);
		ac.close();
	}
	
	@Scope("singleton")
	static class SingletonBean{
		
		@Autowired
		ApplicationContext ac;
		
		 @PostConstruct
		 public void inint() {
			 System.out.println("싱글톤 초기화......");
		 }
		 
		 //싱글톤에서 호출할 떄 마다 프로토타입 빈을 생성한다..
		 public void logic() {
			 PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
		 }
		 
		 @PreDestroy
		 public void destroy() {
			 System.out.println("싱글톤 종료.......");
		 }
	}
}
