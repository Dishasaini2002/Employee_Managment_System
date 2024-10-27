package com.Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayEmp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("disha");
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("from Employee e ORDER BY e.id ASC");
		List<Employee> l = query.getResultList();

		out.println("<html>\r\n" + "<head>\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n"
				+ "    <style>\r\n" 
				+ "        table {\r\n" 
				+ "            border-radius: 12px; \r\n"
				+ "            overflow: hidden;\r\n" 
				+ "        }\r\n" 
				+ "    nav{\r\n"
				+ "	font-family: 'Raleway',  cursive;\r\n" 
				+ "	font-weight: bold;\r\n" 
				+ "	}" 
				+ "</style>\r\n"
				+ "</head>\r\n" 
				+ "<body class=\"bg-black\">\r\n" 
				+ "   <section>\r\n"
				+ "  <nav class=\"navbar navbar-black bg-black\">\r\n"
				+ "        <div class=\"container-fluid d-flex\">\r\n"
				+ "            <a href=\"Welcome.html\" class=\"navbar-brand text-white mx-auto\">Employee Management</a>\r\n"
				+ "        </div>\r\n" 
				+ "    </nav>\r\n" 
				+ "\r\n" 
				+ "</section>"
				+ " <div class=\"container mt-5\">\r\n"
				+ "        <table class=\"table table-bordered border-light text-center\">\r\n"
				+ "            <thead class=\"table-light\">\r\n" 
				+ "                <tr>\r\n"
				+ "                    <th>Name</th>\r\n" 
				+ "                    <th>Email</th>\r\n"
				+ "                    <th>Department</th>\r\n" 
				+ "                    <th>Email</th>\r\n"
				+ "                    <th>Salary</th>\r\n" 
				+ "                    <th>Location</th>\r\n"
				+ "                    <th>Modify</th>\r\n" 
				+ "                </tr>\r\n" 
				+ "            </thead>\r\n"
				+ "            <tbody class=\"table-dark\">");
		
		if (l != null) {
			for (Employee e : l) {
				int id=e.getId();
				out.println("<tr>");
				out.println("<td>" + e.getId() + "</td>");
				out.println("<td>" + e.getName() + "</td>");
				out.println("<td>" + e.getDept() + "</td>");
				out.println("<td>" + e.getEmail() + "</td>");
				out.println("<td>" + e.getSalary() + "</td>");
				out.println("<td>" + e.getLocation() + "</td>");
				out.println("<td><a href='EditForm.html?id="+id+"'>Edit</a>/<a href='Delete.html?id="+id+"'>Delete</a></td></tr>");
			}
		}
		out.println("</tbody>\r\n" 
				+ "						</table>\r\n" 
				+ "						</div>\r\n"
				+ "						</body>\r\n" 
				+ "						</html>");
	}
}
