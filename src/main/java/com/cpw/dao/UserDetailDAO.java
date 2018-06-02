package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.UserDetail;

public interface UserDetailDAO {

	 /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  
  /** 
     * This is the method to be used to create
     * a record in the Student table.
  */
  public void createUser(UserDetail userDetail);
  
  /** 
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public UserDetail getUserDetail(String id);
  
  /** 
     * This is the method to be used to list down
     * all the records from the Student table.
  */
  public List<UserDetail> listUsers();
  
  
  /** 
     * This is the method to be used to update
     * a record into the Student table.
  */
  public void update(UserDetail userDetail);
}
