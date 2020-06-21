package com.kh.mvc02.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


// file 유효성 검사를 하고 있다.
@Service
public class FileValidator implements Validator{
	

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	//검사를 해보고 잘못되었다면 error에 코드를 담아줄 것이다.
	@Override
	public void validate(Object uploadFile, Errors errors) {
		// target : 검사를 할 객체.
		// uploadFile클래스 하나 만들었죠. 이 친구를 받아서 클래스 객체를 받아서 검사
		// errors : error관련된 내용을 받아 또 처리를 할 것이다.
		UploadFile file = (UploadFile)uploadFile;
		
		if(file.getFile().getSize()==0) {
			errors.rejectValue("file", "errorCode","Please Select a file.");
		}
	}

}
