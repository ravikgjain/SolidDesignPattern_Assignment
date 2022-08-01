package StreamAPI.casestudy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

	public static void main(String[] args) {

		List<Candidate> candidateList = InterviewRepository.getCandidateList();

		// list candidate names from Pune city
		System.out.println("List of Pune Candidates:");
		candidateList.stream().filter(a -> a.getCity().equalsIgnoreCase("Pune")).forEach(System.out::println);
		System.out.println("--------------------------------");

		
		// list city and count of candidates per city
		System.out.println("Candidate count per city--->");
		Map<String, Long> countPerCity = candidateList.stream()
				.collect(Collectors.groupingBy(Candidate::getCity, Collectors.counting()));

		countPerCity.forEach((x, y) -> System.out.println(x + " -- " + y + "  time"));
		System.out.println("--------------------------------");

		
		// list technical expertise and count of candidates
		System.out.println("Candidate count by Technical Expertise-->");
		candidateList.stream().collect(Collectors.groupingBy(Candidate::getTechnicalExpertise, Collectors.counting()))
				.forEach((x, y) -> System.out.println(x + " -- " + y));
		System.out.println("--------------------------------");
		

		// list fresher candidates
		System.out.println("Fresher Candidate list-->");
		candidateList.stream().filter(a -> a.getYearsOfExperience() == 0).forEach(System.out::println);
		System.out.println("--------------------------------");

		// listing candidates with highest experience
		System.out.println("Sorted List of Candidates by Experience-->");
		candidateList.stream().sorted((a1, b1) -> (a1.getYearsOfExperience() - b1.getYearsOfExperience()))
				.forEach(System.out::println);
		System.out.println("--------------------------------");
		

		// sort the candidates by city name
		printLine();
		System.out.println("Sorted List of Candidates by City Name");
		candidateList.stream().sorted((a1, b1) -> a1.getCity().compareTo(b1.getCity())).forEach(System.out::println);
		System.out.println("--------------------------------");
	}

	private static void printLine() {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
	}
}