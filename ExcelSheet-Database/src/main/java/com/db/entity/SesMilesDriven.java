package com.db.entity;

import java.sql.Date;
import java.util.Objects;

public class SesMilesDriven {
	
	String costctrid;
	Double miles_driven;
	String reporting_yr;
	Integer reporting_pd;
	Integer reporting_wk;
	String source_system;
	Date ses_load_dt;
	String asset_no;
	Date rea_date;
	Double reading;
	Double miles_driven_orig;
	
	public String getCostctrid() {
		return costctrid;
	}
	public void setCostctrid(String costctrid) {
		this.costctrid = costctrid;
	}
	public Double getMiles_driven() {
		return miles_driven;
	}
	public void setMiles_driven(Double miles_driven) {
		this.miles_driven = miles_driven;
	}
	public String getReporting_yr() {
		return reporting_yr;
	}
	public void setReporting_yr(String reporting_yr) {
		this.reporting_yr = reporting_yr;
	}
	public Integer getReporting_pd() {
		return reporting_pd;
	}
	public void setReporting_pd(Integer reporting_pd) {
		this.reporting_pd = reporting_pd;
	}
	public Integer getReporting_wk() {
		return reporting_wk;
	}
	public void setReporting_wk(Integer reporting_wk) {
		this.reporting_wk = reporting_wk;
	}
	public String getSource_system() {
		return source_system;
	}
	public void setSource_system(String source_system) {
		this.source_system = source_system;
	}
	public Date getSes_load_dt() {
		return ses_load_dt;
	}
	public void setSes_load_dt(Date ses_load_dt) {
		this.ses_load_dt = ses_load_dt;
	}
	public String getAsset_no() {
		return asset_no;
	}
	public void setAsset_no(String asset_no) {
		this.asset_no = asset_no;
	}
	public Date getRea_date() {
		return rea_date;
	}
	public void setRea_date(Date rea_date) {
		this.rea_date = rea_date;
	}
	public Double getReading() {
		return reading;
	}
	public void setReading(Double d) {
		this.reading = d;
	}
	public Double getMiles_driven_orig() {
		return miles_driven_orig;
	}
	@Override
	public String toString() {
		return "SesMilesDriven [costctrid=" + costctrid + ", miles_driven=" + miles_driven + ", reporting_yr="
				+ reporting_yr + ", reporting_pd=" + reporting_pd + ", reporting_wk=" + reporting_wk
				+ ", source_system=" + source_system + ", ses_load_dt=" + ses_load_dt + ", asset_no=" + asset_no
				+ ", rea_date=" + rea_date + ", reading=" + reading + ", miles_driven_orig=" + miles_driven_orig + "]";
	}
	public void setMiles_driven_orig(Double miles_driven_orig) {
		this.miles_driven_orig = miles_driven_orig;
	}
	
	 @Override
	    public int hashCode() {
	        return Objects.hash(
	            costctrid, miles_driven, reporting_yr, reporting_pd, reporting_wk,
	            source_system, ses_load_dt, asset_no, rea_date, reading, miles_driven_orig
	        );
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        SesMilesDriven other = (SesMilesDriven) obj;
	        return Objects.equals(costctrid, other.costctrid) &&
	               Objects.equals(miles_driven, other.miles_driven) &&
	               Objects.equals(reporting_yr, other.reporting_yr) &&
	               Objects.equals(reporting_pd, other.reporting_pd) &&
	               Objects.equals(reporting_wk, other.reporting_wk) &&
	               Objects.equals(source_system, other.source_system) &&
	               Objects.equals(ses_load_dt, other.ses_load_dt) &&
	               Objects.equals(asset_no, other.asset_no) &&
	               Objects.equals(rea_date, other.rea_date) &&
	               Objects.equals(reading, other.reading) &&
	               Objects.equals(miles_driven_orig, other.miles_driven_orig);
	    }
	
	

}
