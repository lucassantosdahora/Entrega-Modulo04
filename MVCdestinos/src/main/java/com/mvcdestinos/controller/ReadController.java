package com.mvcdestinos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcdestinos.DAO.DestinoDAO;
import com.mvcdestinos.model.Destino;



@WebServlet("/ReadController")
public class ReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			DestinoDAO cDAO = new DestinoDAO();
			List<Destino> destino = cDAO.listDestino();
			req.setAttribute("destino", destino);
			
			RequestDispatcher rd = req.getRequestDispatcher("destino.jsp");
			rd.forward(req, res);
			
			res.sendRedirect("destino.jsp");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
