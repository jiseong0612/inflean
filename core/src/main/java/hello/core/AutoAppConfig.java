package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//이건 기존 예제인 Appconfig를 예제로 남기고 현재 클래스를 빈으로 등록하기 위함 그냥 무시하고 공부하면 됨
@ComponentScan(
		excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
		)
public class AutoAppConfig {

}
