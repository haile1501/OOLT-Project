package hust.soict.globalict.main.data.people;


import hust.soict.globalict.utils.Utils;

public class King extends People {
	private final String activeYearsStartYear;
	private final String activeYearsEndYear;

	public King() {
	  super();
	  this.activeYearsStartYear = "?data dbo:activeYearsStartYear ?activeYearsStartYear.";
	  this.activeYearsEndYear = "?data dbo:activeYearsEndYear ?activeYearsEndYear.";
	  this.dataSource = "?data dct:subject dbc:Vietnamese_monarchs.";
	}

	public String getActiveYearsStartYear() {
		return activeYearsStartYear;
	}

	public String getActiveYearsEndYear() {
		return activeYearsEndYear;
	}

	@Override
	public String getPREFIXES() {
	    return super.getPREFIXES();
	}

	public String createConstructBody() {
	    return super.createConstructBody() + "\n" +
	            this.getActiveYearsStartYear() + "\n" +
	            this.getActiveYearsEndYear() + "\n" ;
	}

	public String createWhereBody() {
	    return super.createWhereBody() +
	    		Utils.createOptionalStatement(this.getActiveYearsStartYear()) + "\n" +
                Utils.createOptionalStatement(this.getActiveYearsEndYear()) + "\n" ;
	}
}