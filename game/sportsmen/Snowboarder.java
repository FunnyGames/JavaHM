package game.sportsmen;

import utilities.Point;

/**
 * A racer.
 * Contains name, gender, qualification, age and league.
 * Also has speed limit and acceleration.
 */
public class Snowboarder {
    private String name;
    private double acceleration;
    private double maxSpeed;
    private Point currentLocation;
    private double currentSpeed;
    private String qualification;
    private String gender;
    private double age;
    private String league;

    /**
     * Racer's information
     * @param name racer's name
     * @param maxSpeed maximum speed
     * @param age racer's age
     * @param acceleration acceleration
     * @param qualification racer's qualification
     * @param gender racer's gender
     * @param league racer's league
     */
    public Snowboarder(String name, double maxSpeed, double age, double acceleration, String qualification, String gender, String league) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.age = age;
        this.acceleration = acceleration;
        this.qualification = qualification;
        this.gender = gender;
        this.league = league;
    }

    /**
     * Sets the start point and initial speed for the racer.
     * @param start start point for the racer
     */
    public void initRace(Point start) {
        currentLocation = new Point(start);
        currentSpeed = 0;
    }

    /**
     * Moves the the racer and also accelerates.
     * @param finish the finish line point
     * @param friction the friction of the arena
     * @return true if crossed the finish line, false otherwise
     */
    public boolean move(Point finish, double friction) {
        if (currentSpeed < maxSpeed) {
            currentSpeed += acceleration * friction;
            if (currentSpeed > maxSpeed) {
                currentSpeed = maxSpeed;
            }
        }

        currentLocation.setX(currentLocation.getX() + currentSpeed);
        return currentLocation.getX() >= finish.getX();
    }

    public double getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getQualification() {
        return qualification;
    }

    public String getLeague() {
        return league;
    }

    @Override
    public String toString() {
        return name + " My Location is " + currentLocation + " My speed is " + currentSpeed;
    }

}
