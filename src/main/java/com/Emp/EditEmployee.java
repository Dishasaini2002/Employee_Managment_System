package com.Emp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class EditEmployee extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("ename");
			String dept = req.getParameter("dept");
			String email = req.getParameter("email");
			int sal = Integer.parseInt(req.getParameter("sal"));
			String location = req.getParameter("loc");

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("disha");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			Employee e1 = em.find(Employee.class, id);
			if (e1!=null) {
				e1.setName(name);	
				e1.setDept(dept);
				e1.setEmail(email);
				e1.setSalary(sal);
				e1.setLocation(location);
				
				et.begin();
				em.merge(e1);
				RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
				rd.include(req, resp);
				
				et.commit();
			}
			
			
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
}
