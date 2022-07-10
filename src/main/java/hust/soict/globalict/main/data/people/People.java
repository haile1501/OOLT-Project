package hust.soict.globalict.main.data.people;


import hust.soict.globalict.main.data.Tourism;
import hust.soict.globalict.utils.Utils;

public class People extends Tourism {
	private final String abstractProp;
	private final String birthDate;
	private final String deathDate;

	public People() {
	  super();
	  this.abstractProp = "?data dbo:abstract ?abstract.";
	  this.birthDate = "?data dbp:birthDate ?birthDate.";
	  this.deathDate = "?data dbp:deathDate ?deathDate.";
	}
	

	public String getAbstractProp() {
	    return abstractProp;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	@Override
	public String getPREFIXES() {
	    return super.getPREFIXES() +
	                """                
	                PREFIX dbp: <http://dbpedia.org/property/>
	                PREFIX dbo: <http://dbpedia.org/ontology/>
	                PREFIX dbr: <http://dbpedia.org/resource/>
	                """;
	}

	public String createConstructBody() {
	    return super.createConstructBody() +
	            this.getAbstractProp() + "\n" +
	            this.getBirthDate() + "\n" +
	            this.getDeathDate() + "\n" ;
	}

	public String createWhereBody() {
	    return super.createWhereBody() +
	    		Utils.createOptionalStatement(this.getAbstractProp()) + "\n" +
                Utils.createOptionalStatement(this.getBirthDate()) + "\n" +
		        Utils.createOptionalStatement(this.getDeathDate())+ "\n" ;
	}

}


