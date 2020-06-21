package com.kh.mvc02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.kh.mvc02.validate.FileValidator;
import com.kh.mvc02.validate.UploadFile;

@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   @Autowired
   private FileValidator fileValidator;
   
   @RequestMapping(value="/form")         //value=값 으로 명시를 해줄수도 있음
   public String getUploadForm() {
      return "uploadForm";
   }
   
   @RequestMapping(value="/upload")
   public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile,BindingResult result) {
      //BindingResult : 객체를 Binding 하다가 에러 발생 시 그 정보를 받기 위해 사용
      
      //유효성 검사, 파일크기가 0이면...
      fileValidator.validate(uploadFile, result);
      if(result.hasErrors()) {
         return "uploadForm";
      }
      
      //uploadFile에 담겨있는 파일을 가져오기
      MultipartFile file = uploadFile.getFile();
      String filename = file.getOriginalFilename();    //업로드한 실제 파일이름
      
      UploadFile fileobj = new UploadFile();
      fileobj.setFilename(filename);
      fileobj.setDesc(uploadFile.getDesc());
      
      InputStream inputStream = null;
      OutputStream outputStream = null;
      
      try {
         inputStream = file.getInputStream();
         
         //String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
         String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
         
         System.out.println("업로드 될 실제 경로: "+path);
         
         File storage = new File(path);
         if(!storage.exists()) { //경로 존재 여부
            storage.mkdirs();   //디렉토리생성
         }
         
         
         File newfile = new File(path+"/"+filename);
         
         if(!newfile.exists()) {
            newfile.createNewFile();
         }
         
         outputStream = new FileOutputStream(newfile);
         
         int read = 0;
         byte[] b = new byte[(int)file.getSize()];
         
         //파일을 읽어와서 output 해줌
         while((read=inputStream.read(b)) != -1) {
            outputStream.write(b, 0, read);
         }
         
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            inputStream.close();
            outputStream.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      
      model.addAttribute("fileobj", fileobj);
      return "uploadFile";
   }
 
   @RequestMapping(value="/download")
   @ResponseBody
   public byte[] fileDown(HttpServletRequest request,HttpServletResponse res,String filename) {
	   
	   byte[] bytes = null;
	   try {
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		File file = new File(path + "/" + filename);
		
		bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName().getBytes(),"8859_1");
		
		// inline, attachment
		res.setHeader("Content-Disposition", "attachment;filename=\""+fn+"\"");
		res.setContentLength(bytes.length);
		res.setContentType("image/jpeg");
		
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   //DispatcherServlet으로 가지 않고 바로 응답이 된다.
	   return bytes;
   }
   
   
}