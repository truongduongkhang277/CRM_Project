package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.myclass.dao.UserDao;
import com.myclass.dto.LoginDto;
import com.myclass.entity.User;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class AuthController extends HttpServlet {

	private UserDao userDao = null;

	public AuthController() {
		userDao = new UserDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/login":
			req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
			break;
		case "/logout":
			HttpSession session = req.getSession();
			session.removeAttribute("LOGIN");
			resp.sendRedirect(req.getContextPath() + "/login");
			break;
		default:
			break;
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		// BƯỚC 1: Gọi hàm findByEmail để check email
			// - TH1: findByEmail trả về null (email ko có trong db) => Xuất thông báo cho người dùng
			// - TH2: findByEmail trả về khác null => Qua bước 2
		LoginDto loginDto = userDao.checkLogin(email);
		if (loginDto == null) {
			req.setAttribute("message", "Sai email hoặc mật khẩu!");
			req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
		}
		
		// BƯỚC 2: Lấy mật khẩu trả về từ db so sánh với mật khẩu lấy từ form
			// - TH1: Nếu không khớp => Xuất thông báo cho người dùng
			// - TH2: Nếu khớp => Qua bước 3
		if( !BCrypt.checkpw(password, loginDto.getPassword())){
			req.setAttribute("message", "Sai email hoặc mật khẩu!");
			req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
		}
			
		// BƯỚC 3: Lưu thông tin user vào Sesson
			// TẠO ĐỐI TƯỢNG SESSION
			HttpSession session = req.getSession();
			// LƯU ĐỐI TƯỢNG USER VÀO SESSION
			session.setAttribute("LOGIN", loginDto);
			
		// BƯỚC 4: // CHuyển hướng qua trang chủ
			resp.sendRedirect(req.getContextPath() + "/home");
	}
}
