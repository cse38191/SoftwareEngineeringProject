package model;

import helper.Praxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;





import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.DbConnection;

public class InsertTodb {
	DbConnection db = new DbConnection();

	public void insertPraxi(Praxi px) throws ClassNotFoundException, SQLException{

		Connection con = db.doConnect();
		PreparedStatement pst = null;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try{
			pst = con.prepareStatement("insert praxis (kaek,eponimo,onoma,patronimo,address,adt,ekdarxi,phone,arpraxis,hmerominia,symvoleografos) values(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, px.getKaek());
			pst.setString(2, px.getEponimo());
			pst.setString(3, px.getOnoma());
			pst.setString(4, px.getPatronimo());
			pst.setString(5, px.getAddress());
			pst.setString(6, px.getAdt());
			pst.setString(7, px.getEkdarxi());
			pst.setString(8, px.getPhone());
			pst.setString(9, px.getArpraxis());
			Date hm = formatter.parse(px.getHmerominia());
			formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			pst.setString(10, formatter.format(hm));
			pst.setString(11, px.getSymvolaiografos());

			pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			pst.close();
			con.close();
		}
	}

	public void updatePraxi(Praxi px) throws ClassNotFoundException, SQLException{

		Connection con = db.doConnect();
		PreparedStatement pst = null;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try{
			pst = con.prepareStatement("update praxis set kaek=?,eponimo=?,onoma=?,patronimo=?,address=?,adt=?,ekdarxi=?,phone=?,arpraxis=?,hmerominia=?,symvoleografos=? where id = ?");
			pst.setString(1, px.getKaek());
			pst.setString(2, px.getEponimo());
			pst.setString(3, px.getOnoma());
			pst.setString(4, px.getPatronimo());
			pst.setString(5, px.getAddress());
			pst.setString(6, px.getAdt());
			pst.setString(7, px.getEkdarxi());
			pst.setString(8, px.getPhone());
			pst.setString(9, px.getArpraxis());
			Date hm = formatter.parse(px.getHmerominia());
			formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			pst.setString(10, formatter.format(hm));
			pst.setString(11, px.getSymvolaiografos());
			pst.setInt(12, px.getId());
			pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			pst.close();
			con.close();
		}
	}

}
