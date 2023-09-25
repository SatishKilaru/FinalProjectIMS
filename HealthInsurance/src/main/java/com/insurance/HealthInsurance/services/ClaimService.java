package com.insurance.HealthInsurance.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.HealthInsurance.contractors.InsuranceClaim;
import com.insurance.HealthInsurance.models.Claim;
import com.insurance.HealthInsurance.models.Claims;
import com.insurance.HealthInsurance.models.DiseaseDetails;
import com.insurance.HealthInsurance.models.InsurancePackage;
import com.insurance.HealthInsurance.models.InsurancePackageCoveredDisease;
import com.insurance.HealthInsurance.models.LoginClass;

@Service
public class ClaimService {

	@Autowired
	InsuranceClaim insuranceClaim;

	public void addClaim(Claim claim) {
		insuranceClaim.addClaim(claim);
	}

	public List<InsurancePackage> getAllInsurancePackages() {
		return insuranceClaim.getAllInsurancePackages();
	}

	public List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId) {
		return insuranceClaim.getCoveredDiseasesByPackageId(packageId);
	}

	public DiseaseDetails getDiseaseDetailsById(int discId) {

		return insuranceClaim.getDetailsByDiseaseId(discId);
	}

	public List<InsurancePackage> getFilteredPackages(String status, int age) {
		return insuranceClaim.getFiteredDiseases(status, age);
	}

	public List<InsurancePackage> getPackagesByStatus(String status) {

		return insuranceClaim.getPackagesByStatus(status);
	}

	public List<InsurancePackage> getAllInsurancePackagesByAge(int age) {

		return insuranceClaim.getAllInsurancePackagesByAge(age);
	}

	// Login
	public int sendmail(String to_mail) {
		return insuranceClaim.sendmail(to_mail);
	}

	public int resetpwd(String email, String pwd) {
		return insuranceClaim.resetpwd(email, pwd);
	}

	public int checkCredentials(LoginClass lc) {
		// TODO Auto-generated method stub
		return insuranceClaim.checkCredentials(lc);
	}
	// LIstClaims

	public ArrayList<Claims> getAllClaims() {
		// TODO Auto-generated method stub
		return (ArrayList<Claims>) insuranceClaim.getAllClaims();
	}

	public ArrayList<Claims> getFilteredClaims(String status) {
		// TODO Auto-generated method stub
		return (ArrayList<Claims>) insuranceClaim.getFilteredClaims(status);
	}

	public Claims getClaimById(int clamId) {
		// TODO Auto-generated method stub
		return insuranceClaim.getClaimById(clamId);
	}
}
