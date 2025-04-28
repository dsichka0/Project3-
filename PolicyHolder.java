// PolicyHolder.java
public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height; // in inches
    private double weight; // in pounds

    // Constructor
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Copy Constructor (for security issues with aggregate classes)
    public PolicyHolder(PolicyHolder other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.age = other.age;
        this.smokingStatus = other.smokingStatus;
        this.height = other.height;
        this.weight = other.weight;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    // toString method
    public String toString() {
        return String.format("Policyholder's First Name: %s%n" +
                             "Policyholder's Last Name: %s%n" +
                             "Policyholder's Age: %d%n" +
                             "Policyholder's Smoking Status (smoker/non-smoker): %s%n" +
                             "Policyholder's Height: %.1f inches%n" +
                             "Policyholder's Weight: %.1f pounds%n" +
                             "Policyholder's BMI: %.2f%n",
                             firstName, lastName, age, smokingStatus, height, weight, calculateBMI());
    }
}