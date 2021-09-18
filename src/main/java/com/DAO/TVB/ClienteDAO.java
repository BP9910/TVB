package com.DAO.TVB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.DTO.TVB.ClienteVO;

public class ClienteDAO {
	
	//@param persona
	public void registrarPersona(ClienteVO persona) {
		Conexion conex=new Conexion();
		try {
			Statement st=conex.getConnection().createStatement();
			st.executeUpdate("INSERT INTO cliente VALUES ('"+persona.getIdCliente()+"'"
					+persona.getNombreCliente()+"','"+persona.getApellidoCliente()+"')");
			JOptionPane.showMessageDialog(null,"Se ha registrado exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
			st.close();
			conex.desconectar();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se registro la persona");
			
		}
	}
	
	//@param documento
	
	public ArrayList<ClienteVO> consultarPersona(int documento){
		ArrayList<ClienteVO> lista=new ArrayList<ClienteVO>();
		Conexion conex=new Conexion();
		try {
			PreparedStatement consulta=conex.getConnection().prepareStatement("SELECT*FROM cliente where idcliente=?");
			consulta.setInt(1, documento);
			ResultSet res=consulta.executeQuery();
			if(res.next()) {
				ClienteVO persona=new ClienteVO();
				persona.setIdCliente(Integer.parseInt(res.getString("idcliente")));
				persona.setNombreCliente(res.getString("nombre"));
				persona.setApellidoCliente(res.getString("apellido"));
				lista.add(persona);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo cpnsultar la persoona"+e);
			
		}
		return lista;
	}
	
	public ArrayList<ClienteVO> listarPersona(){
		ArrayList<ClienteVO> lista=new ArrayList<ClienteVO>();
		Conexion conex=new Conexion();
		
		try {
			PreparedStatement consulta=conex.getConnection().prepareStatement("SELECT*FROM cliente");
			ResultSet res = consulta.executeQuery();
			while(res.next()) {
				ClienteVO persona=new ClienteVO();
				persona.setIdCliente(Integer.parseInt(res.getString("idcliente")));
				persona.setNombreCliente(res.getString("nombre"));
				persona.setApellidoCliente(res.getString("apellido"));
				lista.add(persona);
				
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "No se pudo listar"+ex);
		}
		return lista;
	}
}
