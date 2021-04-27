package com.h2kinfosys.jdbc.dto;

import java.sql.Timestamp;

// Entity, POJO, Bean, Transfer Object, Data TO, Persistence class
public class ActorDTO {

	private int actorId;
	private String firstName;
	private String lastName;
	private Timestamp lastUpdate;
	
	// Rule- Bean should have no-arg constructor 
	public ActorDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "ActorDTO [actorId= " + actorId + ", firstName= " + firstName + ", lastName= " + lastName + "]";
	}



	/**
	 * @return the actorId
	 */
	public int getActorId() {
		return actorId;
	}
	/**
	 * @param actorId the actorId to set
	 */
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the lastUpdate
	 */
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
