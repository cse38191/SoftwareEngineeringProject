package model;

import helper.Praxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.DbConnection;

public class Selections {
	DbConnection db = new DbConnection();

	public Praxi selectPraxi(String arPraxis, String kaek) throws ClassNotFoundException, SQLException{

		Connection con = db.doConnect();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Praxi px = new Praxi();

		try{
			pst = con.prepareStatement("select * from praxis where arpraxis like ?");
			pst.setString(1, "%"+arPraxis+"%");
			//pst.setString(2, "%" + kaek + "%");
			rs = pst.executeQuery();
			
			while (rs.next()){
				px.setId(rs.getInt("id"));
				px.setEponimo(rs.getString("eponimo"));
				px.setOnoma(rs.getString("onoma"));
				px.setPatronimo(rs.getString("patronimo"));
				px.setAddress(rs.getString("address"));
				px.setAdt(rs.getString("adt"));
				px.setEkdarxi(rs.getString("ekdarxi"));
				px.setPhone(rs.getString("phone"));
				px.setArpraxis(rs.getString("arpraxis"));
				px.setHmerominia(rs.getString("hmerominia"));
				px.setSymvolaiografos(rs.getString("symvoleografos"));
				px.setKaek(rs.getString("kaek"));
			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			pst.close();
			con.close();

		}
		return px;
	}

	public List<Praxi> selectMetavoles(String kaek) throws ClassNotFoundException, SQLException{

		Connection con = db.doConnect();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		List<Praxi> lista = new ArrayList<Praxi>();

		try{
			pst = con.prepareStatement("select * from praxis where kaek like ?");
			pst.setString(1, "%"+kaek+"%");
			rs = pst.executeQuery();
			
			while (rs.next()){
				Praxi px = new Praxi();
				px.setId(rs.getInt("id"));
				px.setEponimo(rs.getString("eponimo"));
				px.setOnoma(rs.getString("onoma"));
				px.setPatronimo(rs.getString("patronimo"));
				px.setAddress(rs.getString("address"));
				px.setAdt(rs.getString("adt"));
				px.setEkdarxi(rs.getString("ekdarxi"));
				px.setPhone(rs.getString("phone"));
				px.setArpraxis(rs.getString("arpraxis"));
				px.setHmerominia(rs.getString("hmerominia"));
				px.setSymvolaiografos(rs.getString("symvoleografos"));
				px.setKaek(rs.getString("kaek"));
				lista.add(px);
			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			pst.close();
			con.close();

		}
		return lista;
	}

}
