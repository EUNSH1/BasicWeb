package com.esh.start.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esh.start.board.qna.QnaFileVO;
import com.esh.start.board.qna.QnaVO;
import com.esh.start.util.FileManager;
import com.esh.start.util.Pager;

@Service
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.qna}")
	private String path;
	
	public List<QnaVO> getList(Pager pager) throws Exception{
		Long totalCount = qnaMapper.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		return qnaMapper.getList(pager);
	}

	public int setQnaList(QnaVO qnaVO) throws Exception {
		int result = qnaMapper.setQnaList(qnaVO);
		
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
		}
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				String fileName= fileManager.saveFile(f, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setNum(qnaVO.getNum());
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaMapper.setFileAdd(qnaFileVO);
			}
		}
		
		
		return result;
	}
	
	public QnaFileVO getFileCheck(QnaFileVO qnaFileVO) throws Exception{
		
		return qnaMapper.getFileCheck(qnaFileVO);
	}
	
	public QnaVO getListDetail(QnaVO qnaVO) throws Exception {
		
		return qnaMapper.getListDetail(qnaVO);
	}
	
	public int setDelete(QnaVO qnaVO) throws Exception{
		
		return qnaMapper.setDelete(qnaVO);
	}
	
	public int setUpdate(QnaVO qnaVO) throws Exception{
		
		return qnaMapper.setUpdate(qnaVO);
	}
}
