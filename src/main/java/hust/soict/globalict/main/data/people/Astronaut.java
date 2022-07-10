package hust.soict.globalict.main.data.people;


import hust.soict.globalict.utils.Utils;

public class Astronaut extends People {
	private final String education;
	private final String nationality;

	public Astronaut() {
	  super();
	  this.education = "?data dbo:education ?education.";
	  this.nationality = "?data dbo:nationality ?nationality.";
	  this.dataSource = "?data dct:subject dbc:Vietnamese_astronauts.";
	}

	public String getEducation() {
		return education;
	}

	public String getNationality() {
		return nationality;
	}
	
	@Override
	public String getPREFIXES() {
	    return super.getPREFIXES();
	}

	public String createConstructBody() {
	    return super.createConstructBody() + "\n" +
	            this.getEducation() + "\n" +
	            this.getNationality() + "\n" ;
	}

	public String createWhereBody() {
	    return super.createWhereBody() +
	    		Utils.createOptionalStatement(this.getEducation()) + "\n" +
                Utils.createOptionalStatement(this.getNationality()) + "\n" ;
	}
}