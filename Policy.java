/**
 * Represents an insurance policy with details about the policyholder and methods
 * to calculate BMI and the policy price.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus;
    private double policyholderHeight;
    private double policyholderWeight;

    /**
     * No-argument constructor that initializes all fields to default values.
     */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyholderFirstName = "";
        policyholderLastName = "";
        policyholderAge = 0;
        policyholderSmokingStatus = "non-smoker";
        policyholderHeight = 0.0;
        policyholderWeight = 0.0;
    }

    /**
     * Constructor that sets all fields of the Policy.
     * 
     * @param policyNumber The policy number.
     * @param providerName The name of the insurance provider.
     * @param firstName The first name of the policyholder.
     * @param lastName The last name of the policyholder.
     * @param age The age of the policyholder.
     * @param smokingStatus The smoking status of the policyholder.
     * @param height The height of the policyholder in inches.
     * @param weight The weight of the policyholder in pounds.
     */
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = firstName;
        this.policyholderLastName = lastName;
        this.policyholderAge = age;
        this.policyholderSmokingStatus = smokingStatus;
        this.policyholderHeight = height;
        this.policyholderWeight = weight;
    }

    /**
     * Gets the policy number.
     * 
     * @return The policy number.
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     * 
     * @param policyNumber The new policy number.
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets the provider name.
     * 
     * @return The provider name.
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the provider name.
     * 
     * @param providerName The new provider name.
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Gets the policyholder's first name.
     * 
     * @return The policyholder's first name.
     */
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    /**
     * Sets the policyholder's first name.
     * 
     * @param firstName The new first name of the policyholder.
     */
    public void setPolicyholderFirstName(String firstName) {
        this.policyholderFirstName = firstName;
    }

    /**
     * Gets the policyholder's last name.
     * 
     * @return The policyholder's last name.
     */
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    /**
     * Sets the policyholder's last name.
     * 
     * @param lastName The new last name of the policyholder.
     */
    public void setPolicyholderLastName(String lastName) {
        this.policyholderLastName = lastName;
    }

    /**
     * Gets the policyholder's age.
     * 
     * @return The policyholder's age.
     */
    public int getPolicyholderAge() {
        return policyholderAge;
    }

    /**
     * Sets the policyholder's age.
     * 
     * @param age The new age of the policyholder.
     */
    public void setPolicyholderAge(int age) {
        this.policyholderAge = age;
    }

    /**
     * Gets the smoking status of the policyholder.
     * 
     * @return The smoking status ("smoker" or "non-smoker").
     */
    public String getPolicyholderSmokingStatus() {
        return policyholderSmokingStatus;
    }

    /**
     * Sets the smoking status of the policyholder.
     * 
     * @param smokingStatus The new smoking status ("smoker" or "non-smoker").
     */
    public void setPolicyholderSmokingStatus(String smokingStatus) {
        this.policyholderSmokingStatus = smokingStatus;
    }

    /**
     * Gets the height of the policyholder in inches.
     * 
     * @return The policyholder's height.
     */
    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    /**
     * Sets the height of the policyholder.
     * 
     * @param height The new height in inches.
     */
    public void setPolicyholderHeight(double height) {
        this.policyholderHeight = height;
    }

    /**
     * Gets the weight of the policyholder in pounds.
     * 
     * @return The policyholder's weight.
     */
    public double getPolicyholderWeight() {
        return policyholderWeight;
    }

    /**
     * Sets the weight of the policyholder.
     * 
     * @param weight The new weight in pounds.
     */
    public void setPolicyholderWeight(double weight) {
        this.policyholderWeight = weight;
    }

    /**
     * Calculates the Body Mass Index (BMI) of the policyholder.
     * 
     * @return The BMI calculated using height and weight.
     */
    public double calculateBMI() {
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    /**
     * Calculates the total cost of the policy based on the policyholder's
     * age, smoking status, and BMI.
     * 
     * @return The total price of the policy.
     */
    public double calculatePolicyPrice() {
        double price = 600.0;

        if (policyholderAge > 50) {
            price += 75;
        }

        if (policyholderSmokingStatus.equalsIgnoreCase("smoker")) {
            price += 100;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }
}