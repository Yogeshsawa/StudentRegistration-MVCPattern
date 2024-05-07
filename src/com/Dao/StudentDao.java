package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentBean;
import com.util.ConDb;

public class StudentDao 
{
	public static void doinsert(StudentBean s1)
	{
		try 
		{
			Connection con=ConDb.myconnection();
			String sql="insert into studentreg(firstname,lastname,email,upass,DOB,gender,uadd)values(?,?,?,?,?,?,?)";
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, s1.getFirstname());
			pre.setString(2, s1.getLastname());
			pre.setString(3, s1.getEmail());
			pre.setString(4, s1.getUpass());
			pre.setString(5, s1.getDOB());
			pre.setString(6, s1.getGender());
			pre.setString(7, s1.getUadd());
			pre.executeUpdate();
			System.out.println("Data inserted sucessfully");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static List<StudentBean>getAll()
	{
		List<StudentBean> list= new ArrayList<StudentBean>();
		try {
				Connection con=ConDb.myconnection();
				String sql="select * from studentreg";
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while (rs.next()) 
				{
					StudentBean s1=new StudentBean();
					 s1.setId(rs.getInt("id"));
					 s1.setFirstname(rs.getString("firstname"));
					 s1.setLastname(rs.getString("lastname"));
					 s1.setEmail(rs.getString("email"));
					 s1.setUpass(rs.getString("upass"));
					 s1.setDOB(rs.getString("DOB"));
					 s1.setGender(rs.getString("gender"));
					 s1.setUadd(rs.getString("uadd"));
					 list.add(s1);
				}
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
		return list;
	}
	public static void delete(int id)
	{
		try 
		{
		Connection con=ConDb.myconnection();
		String sql=("delete from studentreg where id=?");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static StudentBean getStudentById(int id)
	{
		StudentBean s=null;
		try {
			Connection con=ConDb.myconnection();
			String sql="select * from studentreg where id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				s=new StudentBean();
				s.setId(rs.getInt("id"));
				s.setFirstname(rs.getString("firstname"));
				s.setLastname(rs.getString("lastname"));
				s.setEmail(rs.getString("email"));
				s.setUpass(rs.getString("upass"));
				s.setDOB(rs.getString("DOB"));
				s.setGender(rs.getString("gender"));
				s.setUadd(rs.getString("uadd"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public static void updatedata(StudentBean s)
	{
		try 
		{
			
		Connection con=ConDb.myconnection();
		String sql="update studentreg set firstname=?, lastname=?, email=? , upass=? , DOB=? , gender=? , uadd=? , where id=?";
	    PreparedStatement pst=con.prepareStatement(sql);
	    pst.setString(1, s.getFirstname());
	    pst.setString(2, s.getLastname());
	    pst.setString(3, s.getEmail());
	    pst.setString(4, s.getUpass());
	    pst.setString(5, s.getDOB());
	    pst.setString(6, s.getGender());
	    pst.setString(7, s.getUadd());
	    pst.setInt(5, s.getId());
	    pst.executeUpdate();
	    
	    
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
