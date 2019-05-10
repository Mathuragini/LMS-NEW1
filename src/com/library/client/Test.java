package com.library.client;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.model.Classification;
import com.library.service.ClassificationService;
import com.library.service.impl.ClassificationServiceImpl;

public class Test {

	public static void main(String[] args) {

		
AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("Beans.xml");
		
ClassificationService classificationService=ctx.getBean("classificationService",ClassificationServiceImpl.class);
//Classification classification = new Classification();
//classification.setClassificationName("maths");
//
//classificationService.addClassification(classification);

for(Classification classification:classificationService.fetchClassificationList()) {
	System.out.println(classification.getClassificationId()+""+classification.getClassificationName());
}
		

		
	}

}
