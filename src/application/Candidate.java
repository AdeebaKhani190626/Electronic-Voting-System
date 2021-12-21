package application;

public class Candidate {

	private int CandidateID;
	private String CandidateName;
	private String EducationLevel;
	private int age;
	private String FatherName;
	private String Nationality;
	private int PartyID;
	
	/* Getters and Setters */
	/**
	 * @return the candidateID
	 */
	public int getCandidateID() {
		return CandidateID;
	}
	/**
	 * @param candidateID the candidateID to set
	 */
	public void setCandidateID(int candidateID) {
		CandidateID = candidateID;
	}
	/**
	 * @return the candidateName
	 */
	public String getCandidateName() {
		return CandidateName;
	}
	/**
	 * @param candidateName the candidateName to set
	 */
	public void setCandidateName(String candidateName) {
		CandidateName = candidateName;
	}	
	/**
	 * @return the educationLevel
	 */
	public String getEducationLevel() {
		return EducationLevel;
	}
	/**
	 * @param educationLevel the educationLevel to set
	 */
	public void setEducationLevel(String educationLevel) {
		EducationLevel = educationLevel;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return FatherName;
	}
	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return Nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
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
}
