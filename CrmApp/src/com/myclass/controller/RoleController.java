package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.dao.RoleDao;
import com.myclass.entity.Role;

@WebServlet(name = "RoleServlet", urlPatterns = { "/role", "/role/add", "/role/edit", "/role/delete" })
public class RoleController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RoleDao roleDao = null;

	public RoleController() {
		roleDao = new RoleDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/role":
			List<Role> listRole = roleDao.findAll();
			req.setAttribute("roles", listRole);
			req.getRequestDispatcher("/WEB-INF/views/role/index.jsp").forward(req, resp);
			break;
		case "/role/add":
			req.getRequestDispatcher("/WEB-INF/views/role/add.jsp").forward(req, resp);
			break;
		case "/role/edit":
			int id = Integer.valueOf(req.getParameter("id"));
			Role role = roleDao.findById(id);
			req.setAttribute("role", role);
			req.getRequestDispatcher("/WEB-INF/views/role/edit.jsp").forward(req, resp);
			break;
		case "/role/delete":
			int idDel = Integer.valueOf(req.getParameter("id"));
			roleDao.deleteById(idDel);
			resp.sendRedirect(req.getContextPath() + "/role");
			return;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		String name = req.getParameter("name");
		String desc = req.getParameter("desc");

		Role role = new Role();
		role.setName(name);
		role.setDescription(desc);

		switch (action) {
		case "/role/add":
			roleDao.add(role);
			break;
		case "/role/edit":
			int id = Integer.valueOf(req.getParameter("id"));
			role.setId(id);
			roleDao.update(role);
			break;
		default:
			break;
		}
		resp.sendRedirect(req.getContextPath() + "/role");
	}
}
