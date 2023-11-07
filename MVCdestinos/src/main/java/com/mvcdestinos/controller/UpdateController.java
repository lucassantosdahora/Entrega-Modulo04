package com.mvcdestinos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcdestinos.DAO.DestinoDAO;
import com.mvcdestinos.model.Destino;




@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    int id = Integer.parseInt(req.getParameter("id"));

	    try {
	        DestinoDAO cDAO = new DestinoDAO();
	        Destino destino = cDAO.findDestino(id);

	        req.setAttribute("destino", destino);

	        RequestDispatcher rd = req.getRequestDispatcher("atualizar.jsp");
	        rd.forward(req, res);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			Destino destino = new Destino();
			destino.setId(Integer.parseInt(req.getParameter("id")));
			destino.setNome(req.getParameter("nome"));
			destino.setPais(req.getParameter("pais"));
			
			DestinoDAO cDAO = new DestinoDAO();
			cDAO.updateDestino(destino);
			
			res.sendRedirect("ReadController");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
