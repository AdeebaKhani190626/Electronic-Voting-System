package application;

public class Party {

	private int PartyID;
	private String PartyName;
	private String PartyPresident;
	private int PartyMembers;
	private int TotalVotes;
	
	/**
	 * @return the partyID
	 */
	public int getPartyID() {
		return PartyID;
	}
	/**
	 * @param partyID the partyID to set
	 */
	public void setPartyID(int partyID) {
		PartyID = partyID;
	}
	/**
	 * @return the partyName
	 */
	public String getPartyName() {
		return PartyName;
	}
	/**
	 * @param partyName the partyName to set
	 */
	public void setPartyName(String partyName) {
		PartyName = partyName;
	}
	/**
	 * @return the partyPresident
	 */
	public String getPartyPresident() {
		return PartyPresident;
	}
	/**
	 * @param partyPresident the partyPresident to set
	 */
	public void setPartyPresident(String partyPresident) {
		PartyPresident = partyPresident;
	}
	/**
	 * @return the partyMembers
	 */
	public int getPartyMembers() {
		return PartyMembers;
	}
	/**
	 * @param partyMembers the partyMembers to set
	 */
	public void setPartyMembers(int partyMembers) {
		PartyMembers = partyMembers;
	}
	/**
	 * @return the totalVotes
	 */
	public int getTotalVotes() {
		return TotalVotes;
	}
	/**
	 * @param totalVotes the totalVotes to set
	 */
	public void setTotalVotes(int totalVotes) {
		TotalVotes = totalVotes;
	}
}
