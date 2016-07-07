package com.lxp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lxp.entity.User;
import com.lxp.service.CheckUserService;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CheckUserService cku = new CheckUserService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("upwd");
		
		RequestDispatcher rd = null;
		String forward = null;
		
		if (uname == null || passwd == null) {
			forward = "/09/error.jsp";
			request.setAttribute("msg", "用户名或者密码不能为空！");
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		} else {
			User user = new User();
			user.setName(uname);
			user.setPassword(passwd);
			boolean bool = cku.check(user);
			if (bool) {
				forward = "/09/success.jsp";
			} else {
				forward = "/09/error.jsp";
			}
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

}
