package com.h2kinfosys.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.h2kinfosys.jdbc.dto.ActorDTO;
import com.h2kinfosys.jdbc.util.ConnectionUtil;

public class ActorDAO {
	// SelectAll, SelectByID, Create, Update, Delete
	private String selectAll = "Select * from Actor";
	private String selectById = "Select * from Actor where actor_id = ?";
	private String create_actor = "INSERT INTO actor(first_name,last_name,last_update)VALUES (?,?,CURRENT_TIMESTAMP)";
	private String update_actor = "UPDATE actor SET first_name = ?, last_name = ?, last_update = CURRENT_TIMESTAMP WHERE actor_id = ?";
	private String delete_actor = "Delete from Actor where actor_id = ?";
	
	
	public ArrayList<ActorDTO> selectAll() throws Exception{
		ArrayList<ActorDTO> actors = new ArrayList<ActorDTO>();
		Connection conn = ConnectionUtil.getConnection();
		Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stat.executeQuery(selectAll);
		if(rs!= null) {
			ActorDTO actor = null;
			while(rs.next()) {
				actor = new ActorDTO();
				actor.setActorId(rs.getInt("actor_id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actor.setLastUpdate(rs.getTimestamp("last_update"));
				// Play with resultset
				if(actor.getActorId() == 206) {
					rs.updateString("first_name", "Charlie");
					rs.updateRow();
				}
				rs.refreshRow();
				actor.setFirstName(rs.getString("first_name"));
				actors.add(actor);
			}
		}
		ConnectionUtil.closeConnection(conn);
		System.out.println(actors);
		return actors;
	}
	
	
	public ArrayList<ActorDTO> selectById(int actorId) throws Exception{
		ArrayList<ActorDTO> actors = new ArrayList<ActorDTO>();
		Connection conn = ConnectionUtil.getConnection();
		// As the parameters are dynamic, we use PreparedStatement
		PreparedStatement pStat = conn.prepareStatement(selectById);
		pStat.setInt(1, actorId);
		
		ResultSet rs = pStat.executeQuery();
		if(rs!= null) {
			ActorDTO actor = null;
			while(rs.next()) {
				actor = new ActorDTO();
				actor.setActorId(rs.getInt("actor_id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actor.setLastUpdate(rs.getTimestamp("last_update"));
				actors.add(actor);
			}
		}
		ConnectionUtil.closeConnection(conn);
		System.out.println(actors);
		return actors;
	}
	
	// Can this method return generated key?
	public int createActor(ActorDTO actor) throws Exception{
		int actorId = 0;
		Connection conn = ConnectionUtil.getConnection();
		// As the parameters are dynamic, we use PreparedStatement
		PreparedStatement pStat = conn.prepareStatement(create_actor, Statement.RETURN_GENERATED_KEYS);
		pStat.setString(1, actor.getFirstName());
		pStat.setString(2, actor.getLastName());
		
		int numberOfRowsAffected = pStat.executeUpdate();
		if(numberOfRowsAffected == 1) {
			System.out.println("Insert Successful " + numberOfRowsAffected);
			ResultSet rs = pStat.getGeneratedKeys();
			while(rs.next()) {
				actorId = rs.getInt(1);
			}
		}
		ConnectionUtil.closeConnection(conn);
		return actorId;
	}
	
	// Update method
	public int updateActor(ActorDTO actor) throws Exception{
		Connection conn = ConnectionUtil.getConnection();
		// As the parameters are dynamic, we use PreparedStatement
		PreparedStatement pStat = conn.prepareStatement(update_actor);
		pStat.setString(1, actor.getFirstName());
		pStat.setString(2, actor.getLastName());
		pStat.setInt(3, actor.getActorId());
		
		int numberOfRowsAffected = pStat.executeUpdate();
		if(numberOfRowsAffected == 1) {
			System.out.println("Update Successful " + numberOfRowsAffected);
		}
		ConnectionUtil.closeConnection(conn);
		return numberOfRowsAffected;
	}
	
	//  Delete method
	public int deleteActor(int actorId) throws Exception{
		Connection conn = ConnectionUtil.getConnection();
		conn.setAutoCommit(false);
		int numberOfRowsAffected = 0;
		try {
			// As the parameters are dynamic, we use PreparedStatement
			PreparedStatement pStat = conn.prepareStatement(delete_actor);
			pStat.setInt(1, actorId);
			
			numberOfRowsAffected = pStat.executeUpdate();
			if(numberOfRowsAffected == 1) {
				System.out.println("Delete Successful " + numberOfRowsAffected);
			}
			conn.commit();
		}catch(Exception exe) {
			exe.printStackTrace();
			conn.rollback();
		}
		ConnectionUtil.closeConnection(conn);
		return numberOfRowsAffected;
	}
	
	// Scrollable result sets
	
	
	
}