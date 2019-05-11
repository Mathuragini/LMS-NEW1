package com.library.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.model.Classification;
import com.library.service.ClassificationService;
import com.library.service.impl.ClassificationServiceImpl;


@WebServlet("/ClassificationController")
public class ClassificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClassificationController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String classificationName = request.getParameter("classificationName");
		
		
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("Beans.xml");
		ClassificationService classificationService=ctx.getBean("classificationService",ClassificationServiceImpl.class);
		Classification classification = new Classification();
		classification.setClassificationName(classificationName);
		
		classificationService.addClassification(classification);

		doGet(request, response);
	}

}
