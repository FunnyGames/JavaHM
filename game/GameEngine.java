package game;

/**
 * A singleton class
 * Contains 1 field of competition.
 * Used to generate a race and run it, add racers and change arenas.
 */
public class GameEngine {
    /**
     * Sets the competition to play.
     */
    private Competition competition;

    /**
     * The single instance of the engine.
     */
    private static GameEngine instance;

    /**
     * Private constructor to prevent making copies of GameEngine.
     */
    private GameEngine() {
    }

    /**
     * Returns the singleton instance of GameEngine.
     * @return the singleton instance of GameEngine
     */
    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    /**
     * Sets the competition.
     * @param comp the competition
     */
    public void setComp(Competition comp) {
        this.competition = comp;
    }

    /**
     * Returns the competition.
     * @return the competition
     */
    public Competition getCompetition() {
        return competition;
    }

    /**
     * Updates the competition`s arena.
     * @param arena the arena to set in competition
     * @return true if succeed or false if failed
     */
    public boolean setArena(Object arena) {
        return competition.setArena(arena);
    }

    /**
     * Initialize the race in competition.
     */
    public void initRace() {
        competition.initRace();
    }

    /**
     * Begins the race loop.
     */
    public void startRace() {
        for (int i = 0; true; i++) {
            if (!competition.playTurn()) {
                break;
            }
            System.out.println("Step " + i);
        }
        System.out.println("race finished!!!");
    }

    /**
     * Adds new racer to the competition.
     * The competition will check if the racers is a valid racer before adding.
     * @param newRacer the sportsman to add to competition
     * @return true if succeed, false otherwise
     */
    public boolean addRacer(Object newRacer) {
        return competition.add(newRacer);
    }

    /**
     * Returns the competition string.
     * @return the competition string
     */
    @Override
    public String toString() {
        return competition.toString();
    }

}
