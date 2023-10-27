package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		try { 
			FileInputStream fis = new FileInputStream (src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exceptio is " + e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getStagingURL()
	{
		String url = pro.getProperty("stagingURL");
		return url;
	}
	
	//Personal Details
	
	public String getName()
	{
		String name = pro.getProperty("name");
		return name;
	}
	
	public String getPhoneNumber()
	{
		String phoneNumber = pro.getProperty("phoneNumber");
		return phoneNumber;
	}
	
	public String getDobDate()
	{
		String dobDay = pro.getProperty("dobDay");
		return dobDay;
	}
	
	public String getDobMonth()
	{
		String dobMonth = pro.getProperty("dobMonth");
		return dobMonth;
	}
	
	public String getDobYear()
	{
		String dobYear = pro.getProperty("dobYear");
		return dobYear;
	}
	
	public String getExpYear()
	{
		String expYear = pro.getProperty("expYear");
		return expYear;
	}
	
	public String getExpMonth()
	{
		String expMonth = pro.getProperty("expMonth");
		return expMonth;
	}
	
	public String getFunctionalArea()
	{
		String functionalArea = pro.getProperty("functionalArea");
		return functionalArea;
	}
	
	public String getAnnualSalary()
	{
		String annualSalary = pro.getProperty("annualSalary");
		return annualSalary;
	}
	
	public String getCLoc()
	{
		String cLoc = pro.getProperty("cLoc");
		return cLoc;
	}
	
	public String getEmail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	//Education Details
	
	public String getDegree()
	{
		String degree = pro.getProperty("degree");
		return degree;
	}
	
	public String getInstituteName()
	{
		String instituteName = pro.getProperty("instituteName");
		return instituteName;
	}
	
	public String getBatchFrom()
	{
		String batchYear = pro.getProperty("batchFrom");
		return batchYear;
	}
	
	public String getBatchTo()
	{
		String batchYear = pro.getProperty("batchTo");
		return batchYear;
	}
	
	public String getRelevantEducation()
	{
		String relevantEducation = pro.getProperty("relevantEducation");
		return relevantEducation;
	}
	
	public String getDegree2()
	{
		String degree = pro.getProperty("degree2");
		return degree;
	}
	
	public String getInstituteName2()
	{
		String instituteName = pro.getProperty("instituteName2");
		return instituteName;
	}
	
	public String getBatchFrom2()
	{
		String batchYear = pro.getProperty("batchFrom2");
		return batchYear;
	}
	
	public String getBatchTo2()
	{
		String batchYear = pro.getProperty("batchTo2");
		return batchYear;
	}
	
	public String getDegree3()
	{
		String degree = pro.getProperty("degree3");
		return degree;
	}
	
	public String getInstituteName3()
	{
		String instituteName = pro.getProperty("instituteName3");
		return instituteName;
	}
	
	public String getBatchFrom3()
	{
		String batchYear = pro.getProperty("batchFrom3");
		return batchYear;
	}
	
	public String getBatchTo3()
	{
		String batchYear = pro.getProperty("batchTo3");
		return batchYear;
	}
	
	//Professional Details
	
	public String getDesignation()
	{
		String designation = pro.getProperty("designation");
		return designation;
	}
	
	public String getOrganizationName()
	{
		String organizationName = pro.getProperty("organizationName");
		return organizationName;
	}
	
	public String getTimePeriod()
	{
		String timePeriod = pro.getProperty("timePeriod");
		return timePeriod;
	}
	
	public String getCurrentlyWorking()
	{
		String currentlyWorking = pro.getProperty("currentlyWorking");
		return currentlyWorking;
	}
	
	public String getDesignation2(){
		String designation = pro.getProperty("designation2");
		return designation;
	}
	
	public String getOrganizationName2(){
		String organizationName = pro.getProperty("organizationName2");
		return organizationName;
	}
	
	public String getTimePeriod2(){
		String timePeriod = pro.getProperty("timePeriod2");
		return timePeriod;
	}
	
	public String getDesignation3(){
		String designation = pro.getProperty("designation3");
		return designation;
	}
	
	public String getOrganizationName3(){
		String organizationName = pro.getProperty("organizationName3");
		return organizationName;
	}
	
	public String getTimePeriod3(){
		String timePeriod = pro.getProperty("timePeriod3");
		return timePeriod;
	}

	public String getRegEmail() {
		String regEmail = pro.getProperty("regEmail");
		return regEmail;
	}

	public String getPdfResume() {
		String resume = pro.getProperty("resume");
		return resume;
	}

	public String getDocxResume() {
		String resume = pro.getProperty("resumeDocx");
		return resume;
	}

	public String getDocResume() {
		String resume = pro.getProperty("docResume");
		return resume;
	}

	public String getPngPicture() {
		String picture = pro.getProperty("pngPicture");
		return picture;
	}
	
	public String getJpgPicture() {
		String picture = pro.getProperty("jpgPicture");
		return picture;
	}
	
	public String getJpegPicture() {
		String picture = pro.getProperty("jpegPicture");
		return picture;
	}

	public String getBday() {
		String bday = pro.getProperty("bday");
		return bday;
	}
	
	public String getExp() {
		String exp = pro.getProperty("exp");
		return exp;
	}
	
	public String getChangedPassword() {
		String changedPassword = pro.getProperty("changedPassword");
		return changedPassword;
	}
	
	//Course Details

	public String getCourseName() {
		String courseName = pro.getProperty("courseName");
		return courseName;
	}

	public String getPeriodFrom() {
		String courseName = pro.getProperty("periodFrom");
		return courseName;
	}

	public String getPeriodTo() {
		String courseName = pro.getProperty("periodTo");
		return courseName;
	}
	
	//AdditionalDetails
	public String getIitRank() {
		String iitRank = pro.getProperty("iitRank");
		return iitRank;
	}
	
	public String getGmatScore() {
		String gmatScore = pro.getProperty("gmatScore");
		return gmatScore;
	}
	
	public String getCatPercentile() {
		String catPercentile = pro.getProperty("catPercentile");
		return catPercentile;
	}

	public String getInstitute() {
		String institute = pro.getProperty("institute");
		return institute;
	}

	public String getParamEmail() {
		String email = pro.getProperty("paramEmail");
		return email;
	}

	public String getParamPassword() {
		String pwd = pro.getProperty("paramPassword");
		return pwd;
	}
	
	public String getChangeEmail() {
		String changeEmail = pro.getProperty("changeEmail");
		return changeEmail;
	}
	
	public String getKeyword() {
		String keyword = pro.getProperty("keyword");
		return keyword;
	}
	
	public String getPortfolioPdf() {
		String portfolioPdf = pro.getProperty("portfolioPdf");
		return portfolioPdf;
	}

	public  String getBaseGmail() {
		
		return pro.getProperty("baseGmail");
	}

}
