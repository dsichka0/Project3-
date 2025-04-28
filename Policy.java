// Policy.java
public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;
    private static int policyCount = 0; // static field to track number of Policies

    // Constructor
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(policyHolder); // Defensive copy
        policyCount++;
    }

    // Getters
    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public PolicyHolder getPolicyHolder() {
        return new PolicyHolder(policyHolder); // Return a copy (security)
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        if (policyHolder.getAge() > 50) {
            baseFee += 75.0;
        }
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            baseFee += 100.0;
        }
        double bmi = policyHolder.calculateBMI();
        if (bmi > 35) {
            baseFee += 75.0;
        }
        return baseFee;
    }

    // toString method
    public String toString() {
        return String.format("Policy Number: %d%n" +
                             "Provider Name: %s%n" +
                             "%s" + // policyholder's toString
                             "Policy Price: $%.2f%n",
                             policyNumber, providerName, policyHolder.toString(), calculatePolicyPrice());
    }
}