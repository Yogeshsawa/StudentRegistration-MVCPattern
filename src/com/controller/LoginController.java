package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ConDb;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try 
		{
			PrintWriter out=response.getWriter();
			String u=request.getParameter("uname");
			String p=request.getParameter("pass");
			Connection con=ConDb.myconnection();
			String sql="select * from studentreg where email=? and upass=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, u);
			pst.setString(2, p);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("loginsucess.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("Username or Password is wrong");
				RequestDispatcher rd=request.getRequestDispatcher("login-fail.jsp");
				rd.forward(request, response);
			}
		} 
		catch (Exception e) 
		{
			
		}
	}

}
