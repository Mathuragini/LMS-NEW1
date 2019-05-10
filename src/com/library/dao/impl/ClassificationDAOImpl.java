package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.library.dao.ClassificationDAO;
import com.library.model.Classification;

public class ClassificationDAOImpl implements ClassificationDAO {

	// dependency injection
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	

	@Override
	public Integer deleteClassification(Integer classificationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classification updateClassification(Integer classificationId, Classification classification) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Classification> getClassificationList() {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Classification> classificationList = new ArrayList<Classification>();
		try {
			connection=dataSource.getConnection();
			String SQL="SELECT mainclassification_id,mainclassification_name FROM mainclassification";
			ps=connection.prepareStatement(SQL);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				Classification classification = new Classification();
				classification.setClassificationId(rs.getInt("mainclassification_id"));
				classification.setClassificationName(rs.getString("mainclassification_name"));
				classificationList.add(classification);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return classificationList;
	}

	@Override
	public Classification getClassificationById(Integer classificationId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Classification createClassification(Classification classification) {
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection=dataSource.getConnection();
			String SQL="INSERT INTO mainclassification(mainclassification_name) VALUES (?)";
			ps=connection.prepareStatement(SQL,
                    ps.RETURN_GENERATED_KEYS);
			
			ps.setString(1, classification.getClassificationName());
			
			
			int executeUpdate=ps.executeUpdate();
			if(executeUpdate>0) {
				System.out.println("MainClassification is created");
			}
			
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	//classification.setClassificationId(generatedKeys.getLong(1));
	            	System.out.println("last insert id:"+generatedKeys.getLong(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	

	
}
