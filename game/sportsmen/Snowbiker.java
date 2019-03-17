package game.sportsmen;

import utilities.Point;

/**
 * A racer.
 * Contains name, gender, qualification, age and league.
 * Also has speed limit and acceleration.
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class Snowbiker {
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
    public Snowbiker(String name, double maxSpeed, double age, double acceleration, String qualification, String gender, String league) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.age = age;
        this.acceleration = acceleration;
        this.qualification = qualification;
        this.gender = gender;
        this.league = league;
        this.currentSpeed = 0;
    }

    /**
     * Sets the start point and initial speed for the racer.
     * @param start start point for the racer
     */
    public void initRace(Point start) {
        currentLocation = new Point(start);
    }

    /**
     * Moves the the racer and also accelerates.
     * @param finish the finish line point
     * @param friction the friction of the arena
     * @return true if crossed the finish line, false otherwise
     */
    public boolean move(Point finish, double friction) {
        if (getCurrentSpeed() < getMaxSpeed()) {
            setCurrentSpeed(getCurrentSpeed() + getAcceleration() * friction);
            if (getCurrentSpeed() > getMaxSpeed()) {
                setCurrentSpeed(getMaxSpeed());
            }
        }

        currentLocation.setX(currentLocation.getX() + getCurrentSpeed());
        System.out.println(this);
        return currentLocation.getX() < finish.getX();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    /**
     * Returns a string contains name of racer, their location and speed.
     * @return name, location and speed
     */
    @Override
    public String toString() {
        return name + " My Location is " + currentLocation + " My speed is " + currentSpeed;
    }

    /**
     * Returns weather the object is a racer and has the same racer details.
     * @param other the object to compare with
     * @return true if the details are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Snowbiker))
            return false;

        Snowbiker o = (Snowbiker) other;

        return name.equals(o.name) && age == o.age && maxSpeed == o.maxSpeed && acceleration == o.acceleration &&
                qualification.equals(o.qualification) && league.equals(o.league) && gender.equals(o.gender);
    }
}
