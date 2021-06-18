package com.satyacodes.cricinfoutil;

public class PlayerInfo {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getBatIngs() {
		return batIngs;
	}
	public void setBatIngs(int batIngs) {
		this.batIngs = batIngs;
	}
	public int getNotouts() {
		return notouts;
	}
	public void setNotouts(int notouts) {
		this.notouts = notouts;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getFiftys() {
		return fiftys;
	}
	public void setFiftys(int fiftys) {
		this.fiftys = fiftys;
	}
	public int getHundrds() {
		return hundrds;
	}
	public void setHundrds(int hundrds) {
		this.hundrds = hundrds;
	}
	public float getBatAvg() {
		return batAvg;
	}
	public void setBatAvg(float batAvg) {
		this.batAvg = batAvg;
	}
	public float getBatStr() {
		return batStr;
	}
	public void setBatStr(float batStr) {
		this.batStr = batStr;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public int getBowIngs() {
		return bowIngs;
	}
	public void setBowIngs(int bowIngs) {
		this.bowIngs = bowIngs;
	}
	public int getWik() {
		return wik;
	}
	public void setWik(int wik) {
		this.wik = wik;
	}
	public int getWik5() {
		return wik5;
	}
	public void setWik5(int wik5) {
		this.wik5 = wik5;
	}
	public float getBowAvg() {
		return bowAvg;
	}
	public void setBowAvg(float bowAvg) {
		this.bowAvg = bowAvg;
	}
	public float getBowStr() {
		return bowStr;
	}
	public void setBowStr(float bowStr) {
		this.bowStr = bowStr;
	}
	public String getBowBest() {
		return bowBest;
	}
	public void setBowBest(String bowBest) {
		this.bowBest = bowBest;
	}
	public float getEcon() {
		return econ;
	}
	public void setEcon(float econ) {
		this.econ = econ;
	}
	
	public int getWik4() {
		return wik4;
	}
	public void setWik4(int wik4) {
		this.wik4 = wik4;
	}
	
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	
	private String name;
	private String country;
	private int profileId;
	private int mat;
	private int batIngs;
	private int notouts;	
	private int runs;
	private int fiftys;
	private int hundrds;
	private float batAvg;
	private float batStr;
	private int high;
	private int bowIngs;	
	private int wik;
	private int wik5;
	private int wik4;
	private float bowAvg;
	private float bowStr;
	private String bowBest;
	private float econ;	
	private String pic;
	@Override
	public String toString() {
		return String.format(
				"PlayerInfo [name=%s, country=%s, profileId=%s, mat=%s, batIngs=%s, notouts=%s, runs=%s, fiftys=%s, hundrds=%s, batAvg=%s, batStr=%s, high=%s, bowIngs=%s, wik=%s, wik5=%s, wik4=%s, bowAvg=%s, bowStr=%s, bowBest=%s, econ=%s, pic=%s]",
				name, country, profileId, mat, batIngs, notouts, runs, fiftys, hundrds, batAvg, batStr, high, bowIngs,
				wik, wik5, wik4, bowAvg, bowStr, bowBest, econ, pic);
	}

	
	
	

}
