package com.citiustech.userInterface;

import java.util.List;

import com.citiustech.model.CandidateReport;
import com.citiustech.service.CandidateService;
import com.citiustech.service.CandidateServiceImpl;


public class CandidateTester {

	private static CandidateService candidateService = new CandidateServiceImpl();

	public static void main(String[] args) throws Exception {
		CandidateReport candidateReport =  new CandidateReport(101, "Madhura", 88, 66, 68, 'P', "B");

		System.out.println(candidateService.addCandidate(candidateReport));
		
		List<CandidateReport> candidatereport = candidateService.getGradesForAllCandidates();
		for(CandidateReport candidatereport2 : candidatereport) {
			System.out.println("CandidateID \t Result");
			System.out.println(candidatereport2.getCandidateId() +"\t\t "+ candidateService.calculateGrade(candidatereport2));
		}
	}
}