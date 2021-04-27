package com.h2kinfosys.jdbc;

import com.h2kinfosys.jdbc.dao.ActorDAO;
import com.h2kinfosys.jdbc.dto.ActorDTO;

public class TestActorDAO {

	public static void main(String[] args) {
		ActorDAO actorDao = new ActorDAO();
		try {
			// actorDao.selectAll();
			// actorDao.selectById(100);
			ActorDTO actor = new ActorDTO();
			actor.setFirstName("BUZZ");
			actor.setLastName("LIGHTYEAR");
			actorDao.createActor(actor);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
