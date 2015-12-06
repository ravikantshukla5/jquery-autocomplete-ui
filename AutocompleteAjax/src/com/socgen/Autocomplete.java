package com.socgen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import sun.org.mozilla.javascript.internal.json.JsonParser;

import com.socgen.vo.Person;

/**
 * Servlet implementation class Autocomplete
 */
@WebServlet("/autoComplete")
public class Autocomplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autocomplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("term");
		Person p1 = new Person("Ravi", "ravi@gmail.com","BTM");
		Person p2 = new Person("Ram", "ravi@gmail.com","Jayadeva");
		Person p3 = new Person("Rao", "ravi@gmail.com","Koramangala");
		
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		response.setContentType("application/json");
		response.getWriter().println(new JSONArray(list).toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		response.getWriter().println("<html>"+name+" : "+email+"</html>");
	}

}
