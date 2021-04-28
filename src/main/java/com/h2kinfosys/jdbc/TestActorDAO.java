package com.h2kinfosys.jdbc;

import com.h2kinfosys.jdbc.dao.ActorDAO;
import com.h2kinfosys.jdbc.dto.ActorDTO;

public class TestActorDAO {

	public static void main(String[] args) {
		ActorDAO actorDao = new ActorDAO();
		try {
			 actorDao.selectAll();
			// actorDao.selectById(100);
			/*
			 * ActorDTO actor = new ActorDTO(); actor.setFirstName("Einstine");
			 * actor.setLastName("Begals"); actor.setActorId(213); //
			 * actorDao.updateActor(actor); actorDao.deleteActor(213);
			 */
			
			//int actorId = actorDao.createActor(actor);
			//System.out.println("Inserted Actor ID " + actorId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
