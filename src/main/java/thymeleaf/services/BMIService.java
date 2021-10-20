package thymeleaf.services;

public class BMIService {
    private double BMI;

    public void calculateBMI(double weight, double height) {
        this.BMI = weight/ (height * height);
    }

    public double getBMI() {
        return this.BMI;
    }
}
