package com.test03;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MTest {

	public static void main(String[] args) {
		/*
		 *  ( 1 ) 스프링을 사용하기 전
		 *  우리는 지금까지 한 클래스 내에서 다른 클래스의 기능을 필요로 할 때,
		 *  new 연산자를 통해 그 클래스의 생성자를 호출해서 사용했었다. 
		 *  
		 *   예를 들어. com.test01 에서 MTest main method내에서 MessageBean의 기능 SayHello 을 쓰기 위해,
		 *   MessgeBean bean = new MessageBean();
		 *   bean.sayHello("Spring");
		 *   
		 *   와 같이 우리(주체)가 사용 할 클래스(MTest) 내 에서 사용 될 클래스(MessageBean)를 만들고(new) 사용(.method())햇다.
		 *   ==> 즉 우리가 사용 할 클래스와 사용 될 클래스의 관계는 개발자(우리)에 의해 직접 코드에서 부여함.
		 *   ==> 이제까지는 클래스를 사용하려면 자바코드에서 클래스 생성자를 호출해 객체를 생성했다.
		 *   
		 *   MTest는 sayHello() 기능을 사용 하려면 MessageBean 클래스가 필요하다.
		 *   즉 MTest는 MessageBean에 <<의존>>하고 있다.
		 *   
		 *   ("의존하다"의 의미 : 어떤 기능을 실행시키기 위해 다른 클래스가 필요로 할 때. 즉, A가 B에 의존한다는 것은 A가 B객체를 사용한다는 것. )
		 * 
		 *   이러한 방식은 아래와 같은 문제점이 있다.
		 *   만약 의존하는 클래스(MessageBean)에 변경사항이 생기면 해당 클래스를 의존하고 있던 모든 클래스들의 소스코드를 수정해 줄 필요가 생긴다.
		 *   ==> 서로 간의 의존관계가 높기 때문이다. == 결합도가 높다!
		 *   
		 *   ------------------------------
		 *   
		 *   (cf) 강한결합 vs 약한결합
		 *   현실에서 우리는 자동차의 에어컨이 고장 나면 당연히 에어컨만 수리하거나 교체하면 된다. 
		 *   하지만 만약 자동차 에어컨의 기능이 자동차 엔진과 관련있게 설계되었다고 (현실적이지 않지만) 가정해보자.
		 *   에어컨에 작은 문제라도 생기면 자동차 엔진까지 손을 봐야 하는 상황이 생길 것이다!.
		 *   
		 *   자동차 부품과 에어컨 부품은 전혀 << "연관성"이 없음에도 >> 
		 *   엔지니어가 자동차 부품과 에어컨 부품이 서로 관련 있게 설계를 했다면
		 *   이러한 문제가 생긴다. (에어컨이 고장났으니 에어컨 부품만 손보면 되는데 멍청한 엔지니어가 에어컨 부품과 자동차 부품을 연관지었다면 자동차까지 손봐야 한다.)
		 *   
		 *   다시말해, 컴퓨터의 그래픽 카드가 고장났다면 그래픽 카드만 교체하면 되는데,
		 *   컴퓨터와 그래픽카드의 기능을 서로 관련 있게 설계했다면
		 *   컴퓨터까지 교체할 상황이 온다는 의미이다.
		 *   
		 *   즉, 엔지니어는 << 서로 관련이 없는 기능끼리는  서로 영향을 주지 않게 설계해야할 필요 >> 가 있다.
		 *   
		 *   이때의 엔지니어를 개발자, 자동차를 프로그램이라고 생각하면,
		 *   
		 *   프로그램도 각각의 독립적인 기능들로 구성되어 있다.
		 *   또 각 기능들은 또 세부기능을 하는 여러 클래스들로 이루어 진다.
		 *   
		 *   그런데 부품 기능을 하는 클래스에 변경 사항이 발생(ex. 에어컨 부품)했을 때 
		 *   그 클래스의 기능과 관련 없는 다른 클래스(ex. 자동차 부품)까지 손봐야 한다면
		 *   위의 예처럼 여러가지 문제가 발생할 수 있다.
		 *   
		 *   그러므로 서로 관련이 있는 기능들은 강하게 결합하고 관련이 없는 기능들은 약하게 결합해야 좋은 프로그램 이다.
		 *   
		 *   ------------------------------
		 *   
		 *   
		 *   이러한 문제점을 해결하기 위해 나온 것이 DI(Dependency Injection).
		 *   각 클래스 사이의 의존관계를 낮추는 것이다.
		 *   
		 *   
		 *   ( 2 ) 스프링의 DI
		 *   스프링 프레임워크는 객체의 생성,소멸과 객체간의 의존관계를 제어한다.
		 *   전에는 개발자(우리:==주체)가 직접 코드로 객체를 생성 소멸하고 그 객체간의 의존관계를 제어 했다면,
		 *   스프링은 스프링이 직.접 제어한다.
		 *   
		 *   개발자가 객체를 제어했던 것을, 스프링이 제어하게 되었으므로 
		 *   <<제어권>>이 개발자에서 스프링으로 <<역전>>된 것이다.
		 *   
		 *   그러므로 스프링의 특징 중 IoC(Inversion of Control) : 제어의 역전 이라고 부른다.
		 *   
		 *   이 때 IoC 되도록 하는 방식을  "의존성 주입"이라 한다.
		 *   == 제어권이 역전 되도록 스프링 프레임워크(컨테이너)가 연관 관계를 직접 규정하는 것이다. == > DI
		 *   그러면 코드에서 직접적인 연관 관계가 발생하지 않으므로 (개발자가 직접 제어하는 것이 아니므로)
		 *   클래스들의 변경이 자유로워 진다 (의존성이 낮아진다 == 약한 결합)
		 *   
		 *   ( 3 ) 사용법
		 *   스프링 컨테이너는 스프링 프레임워크를 초기화 하는 역할을 한다.
		 *   그 과정은 아래와 같다.
		 *   
		 *   1. 스프링 컨테이너 생성
		 *   2. Bean 들이 들어있는 XML파일이 읽힘
		 *   3. XML파일에 등록된 Bean들의 Life Cycle과 Dependency가 관리되기 시작.
		 *   
		 *   이때 스프링 컨테이너는 크게 두 가지 종류가 있다.
		 *   - BeanFactory
		 *   - ApplicationContext
		 *   
		 * */

		// 기존에 사용하던 DI 방식
		// 1.
		// 해당 beans.xml을 읽어서 준비를 하겠다.
		//Resource res = new FileSystemResource("src/com/test03/beans.xml");
		
		// 2. 
		// 최상위 폴더로 src가 잡혀있기때문에 com..으로
		//Resource res = new ClassPathResource("com/test03/beans.xml");
		//BeanFactory factory = new XmlBeanFactory(res);
		
		
		
		// << BeanFactory >> 
		// DI의 기본 기능. 기본적인 의존성 주입을 지원하는 가장 간단한 형태의 컨테이너
		// 이 친구를 이용해서 Bean관련된 작업들 생성하고,분배하고..이러한 것들을 책임지는 클래스.
		
		
		// << ApplicationContext >>
		// -> BeanFactory의 자식. 좀 더 다양한 기능을 가지고 있다.
		// Object생성,관계설정,방식,자동생성까지, 좀 더 다양한 기능을 가지고 있다.
		// BeanFactory를 상속받아서 매우 유사하다.
		
		// DI관련된 가장 단순한 클래스,컨테이너 => BeanFactory
		// 좀 더 다양한 기능을 제공 =>  ApplicationContext.
		
		// BeanFactory의 경우 getBean()메소드가 호출될 때 까지 Bean생성을 미룬다.
		// 이 뜻은 BeanFactory는 모든 bean을 늦게 등록 한다는 것이다.
		
		// 반면에 ApplicationContext는 Context시작하기 전에 모든 singleton bean을 미리 등록함으로써
		// bean이 필요할 때 즉/시 사용할 수 있도록 해준다.
		
		//3.
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		// beanFactory <- ApplicationContext <- ClassPathXmlApplication
		
		// ClassPathXmlApplicationContext : 지정된 classpath에서 xml파일을 읽어 생성
		
		// 스프링의 ApplicationContext 객체는 스프링 컨테이너의 인스턴스이다.
		// 스프링은 ApplicationContext 인터페이스의 몇가지 기본 구현을 제공한다.
		
		
		MessageBean bean = (MessageBean)factory.getBean("korean"); // id를 통해 가져온다.
		bean.sayHello("스프링");
		
		// 의존성 주입을 이용해서 주입을 하겠다. 우리가 Bean을 인스턴스화 한다. getBean을 통해서 호출이 되는 타이밍부터 시작.
		// 여기서부터 Bean의 일생이 시작되는 것이다. 여기서부터 생명이 가진다.
		// Beans.xml 에 설정정보를 해줬죠. 그 중에 하나, 준비되어있는 bean을 가져와서 interface MessageBean 에 집어넣겠다.
		// 스프링이 만들어 놓은 객체(Bean)를 주입!!!!!
		
		// 이미 스프링이 만들어서 준비해놓은 Bean을 우리가 interface MessageBean 에 주입을 시킨 것이다.
		
		// 지금까지는 매번 객체가 필요할 때마다 우리가 new연산자로 생성해서 사용을 했지만,
		// 이제는 스프링이 bean이라는 이름으로 객체를 미리 준비시켜서
		// 사용자가 필요할 때마다, 스프링이 생성한 bean을 getBean을 통해 사용할 수 있게 함. => 주입하였다. DI
		
		// << BeanFactory >>
		// getBean을 했을 때 그제서야 bean을 생성한다.
		// 호출되는 시점에 만든다 : 레이지 로딩
		// 불러서야 그때 호출 하니까.
		
		// << ApplicationContext >>
		// 그와 다르게 ApplicationContext는 해당 Context를 읽을 때 미리 만든다. 만들어둔 bean을 공유해서(싱글톤)으로 가져다 쓴다.
		// 지연없이 그 bean을 얻을 수 있다. 미리 bean을 생성해두고, bean을 필요할 때마다 즉시즉시 사용할 수 있다.
		// 즉시 사용할 수 있는 것을 보장한다.
		
		bean = (MessageBean)factory.getBean("english");
		bean.sayHello("Spring");

	}

}
