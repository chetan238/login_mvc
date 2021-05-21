package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.regDAO;
import VO.regVO;

/**
 * Servlet implementation class regcontroller
 */
@WebServlet("/regcontroller")
public class regcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public regcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String f = request.getParameter("flag");
		if (f.equals("search")) {
			search(request, response);
		}
		if (f.equals("delete")) {
			delete(request, response);
			search(request, response);
		}
		if (f.equals("edit")) {
			edit(request, response);
			// search(request, response);
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String f = request.getParameter("flag");
		if (f.equals("insert")) {
			insert(request, response);
			search(request, response);
		}
		if (f.equals("login")) {
			
			login(request, response);
			//search(request, response);
		}
		

		if (f.equals("update")) {
			update(request, response);
			search(request, response);
		}
		if (f.equals("forgot")) {
			forgot(request, response);
			//search(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	regVO r = new regVO();

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String s1 = request.getParameter("fn");
		String s2 = request.getParameter("ln");
		String s3 = request.getParameter("un");
		String s4 = request.getParameter("pn");

		r.setFn(s1);
		r.setLn(s2);
		r.setUn(s3);
		r.setPn(s4);

		regDAO d = new regDAO();
		d.insert(r);

		//.sendRedirect("mvc_1/reg.jsp");

	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		regDAO d = new regDAO();
		List<regVO> ls = d.search();
		HttpSession s = request.getSession();
		s.setAttribute("list", ls);
		response.sendRedirect("mvc_1/search.jsp");

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		int id1 = Integer.parseInt(request.getParameter("id_edit"));
		r.setId(id1);
		// System.out.print(id1);
		regDAO d = new regDAO();
		List<regVO> ls = d.edit(r);
		HttpSession s = request.getSession();
		s.setAttribute("editlist", ls);
		response.sendRedirect("mvc_1/edit.jsp");

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		int id1 = Integer.parseInt(request.getParameter("id_delete"));
		r.setId(id1);
		regDAO d = new regDAO();
		d.delete(r);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String s1 = request.getParameter("fn");
		String s2 = request.getParameter("ln");
		String s3 = request.getParameter("un");
		String s4 = request.getParameter("pn");

		r.setFn(s1);
		r.setLn(s2);
		r.setUn(s3);
		r.setPn(s4);

		regDAO d = new regDAO();
		d.update(r);

		// response.sendRedirect("mvc_1/reg.jsp");

	}

	protected void forgot(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1 = request.getParameter("username");
		String s2 = request.getParameter("newpswd");
		String s3 = request.getParameter("cnnewpswd");
		System.out.print("username: " + s1);

		if (s2.equals(s3)) {
			r.setUn(s1);
			r.setPn(s2);
			regDAO d = new regDAO();
			List<regVO> ls=d.forgot(r);
			Object[] st=ls.toArray();
			int a=st.length;
			System.out.print(a);
			if(a!=0)
			{
				search(request, response);
			}
			
			else
			{
				HttpSession s = request.getSession();
				s.setAttribute("error1", "wrong username !!!!!!");
				response.sendRedirect("mvc_1/forgot.jsp");
			}
			// response.sendRedirect("mvc_1/search.jsp");
		} else {
			HttpSession s = request.getSession();
			s.setAttribute("error", "password mismatch !!!!!!");
			response.sendRedirect("mvc_1/forgot.jsp");
		}
		

	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String us=request.getParameter("uname");
		 String ps=request.getParameter("pname");
		 System.out.println("username-"+us);
		 System.out.println("password-"+ps);
		 r.setUn(us);
		 r.setPn(ps);
		regDAO d = new regDAO();
		System.out.print("login");
		List<regVO> ls=d.login(r);
		//int a=ls.size();
	//	System.out.print(a);
		//System.out.print(ls.get(1));
		if(ls.isEmpty())
		{
			HttpSession s = request.getSession();
			s.setAttribute("error", "details mismatch !!!!!!");
			response.sendRedirect("mvc_1/login.jsp");
			

		}
		else
		{
			response.sendRedirect("mvc_1/welcome.jsp");
		}
		//response.sendRedirect("mvc_1/welcome.jsp");

	}


}
