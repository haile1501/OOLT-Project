package hust.soict.globalict.main.data.people;

public class Politician extends People {

	public Politician() {
	  super();
	  this.dataSource = "?data dct:subject dbc:Members_of_the_Politburo_of_the_Communist_Party_of_Vietnam";
	}

	@Override
	public String getPREFIXES() {
	    return super.getPREFIXES();
	}

	public String createConstructBody() {
	    return super.createConstructBody() + "\n" ;
	}

	public String createWhereBody() {
	    return super.createWhereBody() ;
	}
}



