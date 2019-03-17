package game;

import game.arenas.AlpineSkiingArena;
import game.arenas.ArenaType;
import game.arenas.ExtremeSkiingArena;
import game.arenas.FreeSkiingArena;
import game.sportsmen.*;

/**
 * Competition Class
 * Sets the arena, minimum age to enter, gender, league and qualification.
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class Competition {
    private ArenaType arenaType;
    private Object currentArena;
    private double minAge;
    private String gender;
    private String league;
    private String qualification;

    /**
     * Sets the details about the competition.
     * @param minAge minimum age to enter
     * @param league the league to join
     * @param gender the gender to join
     * @param qualification the qualification to join
     */
    public Competition(double minAge, String league, String gender, String qualification) {
        this.minAge = minAge;
        this.league = league;
        this.gender = gender;
        this.qualification = qualification;
    }

    /**
     * Copies the details about the competition from another competition.
     * @param comp the competition to make a copy from
     */
    public Competition(Competition comp) {
        this(comp.minAge, comp.league, comp.gender, comp.qualification);
    }

    /**
     * Initializes the arena.
     */
    public void initRace() {
        if (arenaType == ArenaType.AlpineSkiingArena) {
            AlpineSkiingArena arena = (AlpineSkiingArena) currentArena;
            arena.initRace();
        }
        if (arenaType == ArenaType.ExtremeSkiingArena) {
            ExtremeSkiingArena arena = (ExtremeSkiingArena) currentArena;
            arena.initRace();
        }
        if (arenaType == ArenaType.FreeSkiingArena) {
            FreeSkiingArena arena = (FreeSkiingArena) currentArena;
            arena.initRace();
        }
    }

    /**
     * Sets the arena instance and type.
     * @param arena the arena object
     * @return true if a valid arena, false otherwise
     */
    public boolean setArena(Object arena) {
        if (arena instanceof AlpineSkiingArena) {
            arenaType = ArenaType.AlpineSkiingArena;
            currentArena = arena;
            return true;
        }
        if (arena instanceof ExtremeSkiingArena) {
            arenaType = ArenaType.ExtremeSkiingArena;
            currentArena = arena;
            return true;
        }
        if (arena instanceof FreeSkiingArena) {
            arenaType = ArenaType.FreeSkiingArena;
            currentArena = arena;
            return true;
        }
        return false;
    }

    /**
     * Checks if the racers is a valid competitor.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean validCompetitor(Skier comp) {
        if (comp.getAge() < getMinAge()) return false;
        if (!comp.getGender().equals(getGender())) return false;
        return true;
    }

    /**
     * Checks if the racers is a valid competitor.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean validCompetitor(Snowbiker comp) {
        if (comp.getAge() < getMinAge()) return false;
        if (!comp.getGender().equals(getGender())) return false;
        return true;
    }

    /**
     * Checks if the racers is a valid competitor.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean validCompetitor(Showboarder comp) {
        if (comp.getAge() < getMinAge()) return false;
        if (!comp.getGender().equals(getGender())) return false;
        return true;
    }

    /**
     * Checks if the racers is a valid competitor.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean validCompetitor(SnowBunny comp) {
        if (comp.getAge() < getMinAge()) return false;
        if (!comp.getGender().equals(getGender())) return false;
        return true;
    }

    /**
     * Checks if the racers is a valid competitor.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean validCompetitor(OldTimer comp) {
        if (comp.getAge() < getMinAge()) return false;
        if (!comp.getGender().equals(getGender())) return false;
        return true;
    }

    /**
     * Checks if the racers is a valid competitor.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean validCompetitor(SunshineSkier comp) {
        if (comp.getAge() < getMinAge()) return false;
        if (!comp.getGender().equals(getGender())) return false;
        return true;
    }

    /**
     * Adds the racer to competition if is a valid racer.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean add(Skier comp) {
        if (validCompetitor(comp)) {
            switch (arenaType) {
                case ExtremeSkiingArena:
                    ExtremeSkiingArena arena = (ExtremeSkiingArena) currentArena;
                    return arena.add(comp);
                case AlpineSkiingArena:
                case FreeSkiingArena:
                    System.out.println("Not a proper arena!!");
                    return false;
            }
        }
        System.out.println("No valid competitor");
        return false;
    }

    /**
     * Adds the racer to competition if is a valid racer.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean add(OldTimer comp) {
        if (validCompetitor(comp)) {
            switch (arenaType) {
                case ExtremeSkiingArena:
                case AlpineSkiingArena:
                    System.out.println("Not a proper arena!!");
                    return false;
                case FreeSkiingArena:
                    FreeSkiingArena arena = (FreeSkiingArena) currentArena;
                    return arena.add(comp);
            }
        }
        System.out.println("No valid competitor");
        return false;
    }

    /**
     * Adds the racer to competition if is a valid racer.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean add(Snowbiker comp) {
        if (validCompetitor(comp)) {
            switch (arenaType) {
                case ExtremeSkiingArena:
                case FreeSkiingArena:
                    System.out.println("Not a proper arena!!");
                    return false;
                case AlpineSkiingArena:
                    AlpineSkiingArena arena = (AlpineSkiingArena) currentArena;
                    return arena.add(comp);
            }
        }
        System.out.println("No valid competitor");
        return false;
    }

    /**
     * Adds the racer to competition if is a valid racer.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean add(Showboarder comp) {
        if (validCompetitor(comp)) {
            switch (arenaType) {
                case ExtremeSkiingArena:
                    ExtremeSkiingArena arena = (ExtremeSkiingArena) currentArena;
                    return arena.add(comp);
                case AlpineSkiingArena:
                case FreeSkiingArena:
                    System.out.println("Not a proper arena!!");
                    return false;
            }
        }
        System.out.println("No valid competitor");
        return false;
    }

    /**
     * Adds the racer to competition if is a valid racer.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean add(SnowBunny comp) {
        if (validCompetitor(comp)) {
            switch (arenaType) {
                case ExtremeSkiingArena:
                case FreeSkiingArena:
                    System.out.println("Not a proper arena!!");
                    return false;
                case AlpineSkiingArena:
                    AlpineSkiingArena arena = (AlpineSkiingArena) currentArena;
                    return arena.add(comp);
            }
        }
        System.out.println("No valid competitor");
        return false;
    }

    /**
     * Adds the racer to competition if is a valid racer.
     * @param comp the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean add(SunshineSkier comp) {
        if (validCompetitor(comp)) {
            switch (arenaType) {
                case ExtremeSkiingArena:
                    ExtremeSkiingArena exArena = (ExtremeSkiingArena) currentArena;
                    return exArena.add(comp);
                case AlpineSkiingArena:
                    AlpineSkiingArena alArena = (AlpineSkiingArena) currentArena;
                    return alArena.add(comp);
                case FreeSkiingArena:
                    System.out.println("Not a proper arena!!");
                    return false;
            }
        }
        System.out.println("No valid competitor");
        return false;
    }

    /**
     * Plays one turn in arena.
     * @return true if all racers crossed the finish line, false otherwise
     */
    public boolean playTurn() {
        switch (arenaType) {
            case ExtremeSkiingArena:
                ExtremeSkiingArena exArena = (ExtremeSkiingArena) currentArena;
                return exArena.playTurn();
            case AlpineSkiingArena:
                AlpineSkiingArena alArena = (AlpineSkiingArena) currentArena;
                return alArena.playTurn();
            case FreeSkiingArena:
                FreeSkiingArena frArena = (FreeSkiingArena) currentArena;
                return frArena.playTurn();
        }
        return false;
    }

    public double getMinAge() {
        return minAge;
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

    /**
     * Adds the racer to competition if is a valid racer.
     * @param object the racer
     * @return true if valid for the arena, false otherwise
     */
    public boolean add(Object object) {
        if (object instanceof Skier) {
            return add((Skier) object);
        }
        if (object instanceof OldTimer) {
            return add((OldTimer) object);
        }
        if (object instanceof Snowbiker) {
            return add((Snowbiker) object);
        }
        if (object instanceof Showboarder) {
            return add((Showboarder) object);
        }
        if (object instanceof SnowBunny) {
            return add((SnowBunny) object);
        }
        if (object instanceof SunshineSkier) {
            return add((SunshineSkier) object);
        }
        return false;
    }

    /**
     * Returns the details of the competition.
     * @return details of the competition
     */
    @Override
    public String toString() {
        return "Competition(" + arenaType + "," + minAge + "," + league + "," + gender + "," + qualification + ")";
    }

    /**
     * Returns weather the object is competition and has the same details.
     * @param other the object to compare with
     * @return true if all details of competition are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Competition))
            return false;

        Competition c = (Competition) other;

        return minAge == c.minAge && arenaType == c.arenaType && league.equals(c.league) &&
                gender.equals(c.gender) && qualification.equals(c.qualification);
    }

}
