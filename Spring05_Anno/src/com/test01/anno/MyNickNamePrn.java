package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyNickNamePrn {
	   @Autowired
	   private NickName nickName; // 해당 필드에 bean을 자동으로 주입하겠다는 의미.
	   // 해당 패키지를 스캔함으로써 bean이 있을 때 매칭을 해준다. 해당 필드를 의존하는 bean에.
	   // 일단 type! bean중에 NickName과 클래스타입이 같은 클래스가 존재한다. 그러면 자동으로 가져온다.
	   // ==> xml에 bean태그 추가해서, <property>로 추가하는 것 과 같다.
	   
	   public NickName getNickName() {
	      return nickName;
	   }

	   public void setNickName(NickName nickName) {
	      this.nickName = nickName;
	   }

	   @Override
	   public String toString() {
	      return "NickName: " + nickName;
	   }

}
