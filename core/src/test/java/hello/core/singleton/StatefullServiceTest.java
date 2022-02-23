package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefullServiceTest {
	@Test
	@DisplayName("state 테스트")
	public void StatefullServiceTests() {							//여기서 빈을 직접등록했기 때문에 @Configuration 생략 가능
		ApplicationContext ac = new  AnnotationConfigApplicationContext(TestCofig.class);
		StatefullService ss1 =  ac.getBean(StatefullService.class);
		StatefullService ss2 =  ac.getBean(StatefullService.class);
		
		ss1.order("userA", 10000);
		ss2.order("userB", 20000);
		
		System.out.println(ss1.getPrice());	// 난 분명 ss1의 getPrice()를 썻는데 ss2의 결과값을 준다.
		// 따라서 stateless 하게 상태를 유지하지 않게. 값을 원한다면 바로 리턴하게 바꿔준다.
			
		// ==> STATELESS 하게 변경. 값을 유지 하지 않고 바로 리턴
		int getPriceA = ss1.orderFix("userA_Fix", 1000);
		System.out.println("userA_Fix : "+getPriceA);
	}
	
	static class TestCofig{
		@Bean
		public StatefullService service() {
			return new StatefullService();
		}
	}
}
