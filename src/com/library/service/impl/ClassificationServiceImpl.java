package com.library.service.impl;

import java.util.List;

import com.library.dao.ClassificationDAO;
import com.library.model.Classification;
import com.library.service.ClassificationService;

public class ClassificationServiceImpl implements ClassificationService {
	//dependency injection
	private ClassificationDAO  classificationDAO;
	

	public ClassificationDAO getClassificationDAO() {
		return classificationDAO;
	}

	public void setClassificationDAO(ClassificationDAO classificationDAO) {
		this.classificationDAO = classificationDAO;
	}

	@Override
	public Classification addClassification(Classification classification) {
		
		return classificationDAO.createClassification(classification);
	}

	@Override
	public Integer deleteClassification(Integer classificationId) {

		return classificationDAO.deleteClassification(classificationId);
	}

	@Override
	public Classification updateClassification(Integer classificationId, Classification classification) {
	
		return classificationDAO.updateClassification(classificationId, classification);
	}

	@Override
	public Classification fetchClassification(Integer classificationId) {
		
		return classificationDAO.getClassificationById(classificationId);
	}

	@Override
	public List<Classification> fetchClassificationList() {
		
		return classificationDAO.getClassificationList();
	}

	
	


	
}
