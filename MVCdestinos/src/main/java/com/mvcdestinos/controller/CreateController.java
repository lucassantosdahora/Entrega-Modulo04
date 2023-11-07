package com.mvcdestinos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcdestinos.DAO.DestinoDAO;
import com.mvcdestinos.model.Destino;

@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Destino destino = new Destino();
		
		destino.setNome(req.getParameter("nome"));
		destino.setPais(req.getParameter("pais"));
		
		try {
			DestinoDAO cDAO = new DestinoDAO();
			cDAO.createDestino(destino);
			
			res.sendRedirect("ReadController");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
