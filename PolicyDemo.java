import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PolicyDemo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            File inputFile = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(inputFile);

            while (fileScanner.hasNext()) {
                int policyNumber = Integer.parseInt(fileScanner.nextLine());
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine());
                double weight = Double.parseDouble(fileScanner.nextLine());

                Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                           age, smokingStatus, height, weight);
                policies.add(policy);

                // Count smokers and non-smokers
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }

                // If there's an empty line between entries, skip it
                if (fileScanner.hasNextLine()) {
                    fileScanner.nextLine();
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt file not found.");
            return;
        }

        // Display policy info
        for (Policy p : policies) {
            System.out.printf("Policy Number: %d%n", p.getPolicyNumber());
            System.out.printf("Provider Name: %s%n", p.getProviderName());
            System.out.printf("Policyholder's First Name: %s%n", p.getPolicyholderFirstName());
            System.out.printf("Policyholder's Last Name: %s%n", p.getPolicyholderLastName());
            System.out.printf("Policyholder's Age: %d%n", p.getPolicyholderAge());
            System.out.printf("Policyholder's Smoking Status (smoker/non-smoker): %s%n", p.getPolicyholderSmokingStatus());
            System.out.printf("Policyholder's Height: %.1f inches%n", p.getPolicyholderHeight());
            System.out.printf("Policyholder's Weight: %.1f pounds%n", p.getPolicyholderWeight());
            System.out.printf("Policyholder's BMI: %.2f%n", p.calculateBMI());
            System.out.printf("Policy Price: $%.2f%n", p.calculatePolicyPrice());
            System.out.println();
        }

        // Display totals
        System.out.printf("The number of policies with a smoker is: %d%n", smokerCount);
        System.out.printf("The number of policies with a non-smoker is: %d%n", nonSmokerCount);
    }
}