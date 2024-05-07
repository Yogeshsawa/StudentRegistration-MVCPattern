package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.StudentDao;
import com.bean.StudentBean;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) 
		{
			StudentBean s1 = new StudentBean();

			s1.setFirstname(request.getParameter("firstname"));
			s1.setLastname(request.getParameter("lastname"));
			s1.setEmail(request.getParameter("email"));
			s1.setUpass(request.getParameter("upass"));
			s1.setDOB(request.getParameter("DOB"));
			s1.setGender(request.getParameter("gender"));
			s1.setUadd(request.getParameter("uadd"));
			StudentDao.doinsert(s1);

			response.sendRedirect("show.jsp");
		} 
		else if (action.equalsIgnoreCase("delete")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			StudentDao.delete(id);
			response.sendRedirect("show.jsp");
		}
		else if (action.equalsIgnoreCase("edit")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			StudentBean s = StudentDao.getStudentById(id);
			request.setAttribute("s", s);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} 
		else if (action.equalsIgnoreCase("update")) 
		{
			StudentBean s1 = new StudentBean();
			s1.setId(Integer.parseInt(request.getParameter("id")));
			s1.setFirstname(request.getParameter("firstname"));
			s1.setLastname(request.getParameter("lastname"));
			s1.setEmail(request.getParameter("email"));
			s1.setUpass(request.getParameter("upass"));
			s1.setDOB(request.getParameter("DOB"));
			s1.setGender(request.getParameter("gender"));
			s1.setUadd(request.getParameter("uadd"));
			StudentDao.updatedata(s1);
			response.sendRedirect("show.jsp");
		}

	}

}
