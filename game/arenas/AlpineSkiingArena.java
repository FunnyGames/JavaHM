package game.arenas;

import game.sportsmen.SnowBunny;
import game.sportsmen.Snowbiker;
import game.sportsmen.SunshineSkier;
import utilities.Point;

import java.util.ArrayList;

/**
 * Class Arena
 * It will run all valid racers till finish line.
 */
public class AlpineSkiingArena {
    /**
     * The friction of the arena.
     */
    private static final double FRICTION = 0.7;

    /**
     * Maximum racers allowed in this arena.
     */
    private static final int MAX_RACERS = 5;

    private ArrayList<SunshineSkier> shSkiers;
    private ArrayList<SnowBunny> snowBunnies;
    private ArrayList<Snowbiker> snowbikers;
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
    public AlpineSkiingArena(Point start, Point finish, String surface, String condition, String discipline) {
        this.start = new Point(start);
        this.finish = new Point(finish);
        this.surface = surface;
        this.condition = condition;
        this.discipline = discipline;
        this.shSkiers = new ArrayList<>();
        this.snowbikers = new ArrayList<>();
        this.snowBunnies = new ArrayList<>();
        this.finished = new ArrayList<>();
    }

    /**
     * Adds a new racers to arena if there's space.
     * @param skier the sportsman to add
     * @return true if racer was added, false otherwise
     */
    public boolean add(SunshineSkier skier) {
        if (snowBunnies.size() + shSkiers.size() + snowbikers.size() < MAX_RACERS) {
            shSkiers.add(skier);
            return true;
        }
        return false;
    }

    /**
     * Adds a new racers to arena if there's space.
     * @param skier the sportsman to add
     * @return true if racer was added, false otherwise
     */
    public boolean add(SnowBunny skier) {
        if (snowBunnies.size() + shSkiers.size() + snowbikers.size() < MAX_RACERS) {
            snowBunnies.add(skier);
            return true;
        }
        return false;
    }

    /**
     * Adds a new racers to arena if there's space.
     * @param skier the sportsman to add
     * @return true if racer was added, false otherwise
     */
    public boolean add(Snowbiker skier) {
        if (snowBunnies.size() + shSkiers.size() + snowbikers.size() < MAX_RACERS) {
            snowbikers.add(skier);
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
    public int crossFinishLine(SunshineSkier skier) {
        shSkiers.remove(skier);
        finished.add(skier);
        return finished.size();
    }

    /**
     * This crosses the finish line for the racers.
     * It will remove the racer from the active and move them to finished.
     * @param skier the racer that crossed the finish line
     * @return the place of the racer
     */
    public int crossFinishLine(SnowBunny skier) {
        snowBunnies.remove(skier);
        finished.add(skier);
        return finished.size();
    }

    /**
     * This crosses the finish line for the racers.
     * It will remove the racer from the active and move them to finished.
     * @param skier the racer that crossed the finish line
     * @return the place of the racer
     */
    public int crossFinishLine(Snowbiker skier) {
        snowbikers.remove(skier);
        finished.add(skier);
        return finished.size();
    }

    /**
     * Will initialize all the racers.
     */
    public void initRace() {
        for (SunshineSkier skier : shSkiers) {
            skier.initRace(start);
        }
        for (SnowBunny skier : snowBunnies) {
            skier.initRace(start);
        }
        for (Snowbiker skier : snowbikers) {
            skier.initRace(start);
        }
    }

    /**
     * Will run through all racers and move them.
     * When the racer crosses the finish line he will be removed.
     * @return true if there are still racers racing, false otherwise
     */
    public boolean playTurn() {
        if (snowBunnies.size() == 0 && shSkiers.size() == 0 && snowbikers.size() == 0) {
            return false;
        }
        ArrayList<SnowBunny> finBunny = new ArrayList<>();
        ArrayList<SunshineSkier> finSkier = new ArrayList<>();
        ArrayList<Snowbiker> finBiker = new ArrayList<>();
        for (SnowBunny skier : snowBunnies) {
            if (!skier.move(finish, FRICTION)) {
                System.out.println("Yaaay " + skier.getName() + " crossed finish line!");
                finBunny.add(skier);
            }
        }
        for (SunshineSkier skier : shSkiers) {
            if (!skier.move(finish, FRICTION)) {
                System.out.println("Yaaay " + skier.getName() + " crossed finish line!");
                finSkier.add(skier);
            }
        }
        for (Snowbiker skier : snowbikers) {
            if (!skier.move(finish, FRICTION)) {
                System.out.println("Yaaay " + skier.getName() + " crossed finish line!");
                finBiker.add(skier);
            }
        }
        for (SnowBunny skier : finBunny) {
            crossFinishLine(skier);
        }
        for (SunshineSkier skier : finSkier) {
            crossFinishLine(skier);
        }
        for (Snowbiker skier : finBiker) {
            crossFinishLine(skier);
        }
        return true;
    }

    /**
     * Returns the details of the arena.
     * @return details of the arena
     */
    @Override
    public String toString() {
        return "AlpineSkiingArea(" + start + "," + finish + "," + surface + "," + condition + "," + discipline + ")";
    }

    /**
     * Returns weather the object is arena and has the same details.
     * @param other the object to compare with
     * @return true if all details are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof AlpineSkiingArena))
            return false;

        AlpineSkiingArena a = (AlpineSkiingArena) other;

        return start == a.start && finish == a.finish && surface.equals(a.surface) && condition.equals(a.condition) &&
                discipline.equals(a.discipline);
    }

    public ArrayList<Object> getFinished() {
        return finished;
    }

    public Point getFinish() {
        return finish;
    }

    public Point getStart() {
        return start;
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
