package com.scg.util;



public enum StateCode {
			CA("CA"),
			WA("WA");



    /**
     * The state's abbreviation.
     */
    private String abbreviation;

    StateCode(final String abbreviation){
    	this.abbreviation = abbreviation;
    }

	public String getAbbreviation() {
		return abbreviation;
	}


}
