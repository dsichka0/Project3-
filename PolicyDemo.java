// PolicyDemo.java
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

                PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                Policy policy = new Policy(policyNumber, providerName, policyHolder);
                policies.add(policy);

                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }

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
            System.out.println(p); // Calls toString() automatically
            System.out.println(); // Empty line
        }

        // Display totals
        System.out.printf("The number of policies with a smoker is: %d%n", smokerCount);
        System.out.printf("The number of policies with a non-smoker is: %d%n", nonSmokerCount);
        System.out.printf("The number of Policy objects created is: %d%n", Policy.getPolicyCount());
    }
}