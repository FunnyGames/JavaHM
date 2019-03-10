package game.arenas;

import game.sportsmen.OldTimer;
import utilities.Point;

import java.util.ArrayList;

/**
 * Class Arena
 * It will run all valid racers till finish line.
 */
public class FreeSkiingArena {
    /**
     * The friction of the arena.
     */
    private static final double FRICTION = 0.7;

    /**
     * Maximum racers allowed in this arena.
     */
    private static final int MAX_RACERS = 8;

    private ArrayList<OldTimer> skiers;
    private Point start;
    private Point finish;
    private ArrayList<Object> finished;
    private String surface;
    private String condition;
    private String discipline;

    /**
     * Arena's information
     * @param start the start point of arena
     * @param finish the end point the arena
     * @param surface the surface of arena
     * @param condition the condition of arena
     * @param discipline the discipline of arena
     */
    public FreeSkiingArena(Point start, Point finish, String surface, String condition, String discipline) {
        this.start = new Point(start);
        this.finish = new Point(finish);
        this.surface = surface;
        this.condition = condition;
        this.discipline = discipline;
        this.skiers = new ArrayList<>();
        this.finished = new ArrayList<>();
    }

    /**
     * Adds a new racers to arena if there's space.
     * @param skier the sportsman to add
     * @return true if racer was added, false otherwise
     */
    public boolean add(OldTimer skier) {
        if (skiers.size() < MAX_RACERS) {
            skiers.add(skier);
            return true;
        }
        return false;
    }

    /**
     * This crosses the finish line for the racers.
     * It will remove the racer from the active and move them to finished.
     * @param skier the racer that crossed the finish line
     * @return the place of the racer
     */
    public int crossFinishLine(OldTimer skier) {
        skiers.remove(skier);
        finished.add(skier);
        return finished.size();
    }

    /**
     * Will initialize all the racers.
     */
    public void initRace() {
        for (OldTimer skier : skiers) {
            skier.initRace(start);
        }
    }

    /**
     * Will run through all racers and move them.
     * When the racer crosses the finish line he will be removed.
     * @return true if there are still racers racing, false otherwise
     */
    public boolean playTurn() {
        if (skiers.size() == 0) {
            return false;
        }
        ArrayList<OldTimer> finTimers = new ArrayList<>();
        for (OldTimer skier : skiers) {
            if (skier.move(finish, FRICTION)) {
                finTimers.add(skier);
            } else {
                System.out.println(skier);
            }
        }
        for (OldTimer skier : finTimers) {
            crossFinishLine(skier);
        }
        return true;
    }

    @Override
    public String toString() {
        return "FreeSkiingArea(" + start + "," + finish + "," + surface + "," + condition + "," + discipline + ")";
    }

    public Point getStart() {
        return start;
    }

    public Point getFinish() {
        return finish;
    }

    public String getSurface() {
        return surface;
    }

    public String getCondition() {
        return condition;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setFinish(Point finish) {
        this.finish = finish;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
