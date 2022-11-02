package com.esh.start.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.esh.start.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager extends AbstractView {
	
	@Value("${app.download.base}")
	private String base;
	
	// 상속 받아주는 메소드
	// 얘가 view 가 됨
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		QnaFileVO qnaFileVO = (QnaFileVO) model.get("fileVO");
		String path = (String) model.get("path");
		
		log.info("------------");
		log.info("FILEVO {}", qnaFileVO);
		
		File file = new File(base+path+"/",qnaFileVO.getFileName());
		
		// 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		// 총 파일의 크기
		response.setContentLengthLong(file.length());
		String [] test = {};
		// client가 다운로드 시 파일의 이름을 encoding 
		String oriName = URLEncoder.encode(qnaFileVO.getOriName(), "UTF-8");
		
		// header
		response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//HDD에서 파일을 읽을 준비
		FileInputStream fi = new FileInputStream(file);
		//Client 로 전송준비
		OutputStream os = response.getOutputStream();
		
		//전송
		FileCopyUtils.copy(fi, os);
		
		// 자원해제
		os.close();
		fi.close();
		
	}
	 public int solution(String[][] clothes) {
	        int answer = 0;
	        
	        Set<String> hashlist = new HashSet<>();
	        return answer;
	    }
	public String saveFile(MultipartFile multipartFile,String path) throws Exception{
		
		
		// 1. 중복되지 않는 파일명 생성(UUID,Date)
		String filename = UUID.randomUUID().toString();
		
		// 2. 확장자
//		filename = filename + multipartFile.getOriginalFilename();
		StringBuffer bf = new StringBuffer();
		bf.append(filename);
		bf.append("_");
		
//		String ex = multipartFile.getOriginalFilename();//아이유.jpg
//		ex = ex.substring(ex.lastIndexOf("."));
		
		bf.append(multipartFile.getOriginalFilename());
		
		filename = bf.toString();
		// 3. file 저장하기 Save
		File file = new File(path, bf.toString());
		
//		FileCopyUtils.copy(multipartFile.getBytes(), file);
		multipartFile.transferTo(file);
		
		// FileCopyUtils
		// MultipartFile
		
		return filename;
	}

}
