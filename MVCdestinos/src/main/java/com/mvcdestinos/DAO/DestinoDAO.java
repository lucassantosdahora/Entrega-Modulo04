package com.mvcdestinos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvcdestinos.connection.MyConnection;
import com.mvcdestinos.model.Destino;



public class DestinoDAO {
	
	private Connection connection;
	private String sql;

	public DestinoDAO() throws SQLException {
		connection = MyConnection.createConnection();
	}

	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createDestino( Destino destino) {
		sql = "INSERT INTO destino (nome,pais) VALUES (?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destino.getNome());
			stmt.setString(2, destino.getPais());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Destino findDestino(int id) {
	    Destino destinos = null;
	    sql = "SELECT * FROM destino WHERE id = ?";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        
	        stmt.setInt(1, id);
	        ResultSet res = stmt.executeQuery();
	        
	        if (res.next()) {
	            destinos = new Destino();  
	            destinos.setId(res.getInt("id"));
	            destinos.setNome(res.getString("nome"));
	            destinos.setPais(res.getString("pais"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return destinos;  

	}
	
	public  List<Destino> listDestino() {
		String sql = "SELECT * FROM destino";
		
		List<Destino> destinos = new ArrayList<Destino>();
		
		ResultSet res = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			res = stmt.executeQuery();
			
			while (res.next()) {
				Destino destino = new Destino();
				destino.setId(res.getInt("id"));
				destino.setNome(res.getString("nome"));
				destino.setPais(res.getString("pais"));
				
			  destinos.add(destino);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destinos;
		
	}
	
	public void updateDestino(Destino destino) {
	    sql = "UPDATE destino SET nome = ?, pais = ? WHERE id = ?";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, destino.getNome());
	        stmt.setString(2, destino.getPais());
	        stmt.setInt(3, destino.getId()); 
	        
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void deleteDestino(int id) {
		sql = "DELETE FROM destino WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
