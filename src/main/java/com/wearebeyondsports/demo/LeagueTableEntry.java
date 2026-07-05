package com.wearebeyondsports.demo;

/**
 * Represents a single row in the generated football league table.
 *
 * <p>
 * This class is a read-only result object. It contains already calculated
 * table values for one team.
 * </p>
 */
public final class LeagueTableEntry {

    private final String teamName;
    private final int played;
    private final int won;
    private final int drawn;
    private final int lost;
    private final int goalsFor;
    private final int goalsAgainst;
    private final int goalDifference;
    private final int points;

    /**
     * Creates a league table entry.
     *
     * @param teamName       name of the team
     * @param played         number of matches played
     * @param won            number of matches won
     * @param drawn          number of matches drawn
     * @param lost           number of matches lost
     * @param goalsFor       total goals scored
     * @param goalsAgainst   total goals conceded
     * @param goalDifference goals for minus goals against
     * @param points         total league points
     */
    public LeagueTableEntry(
            String teamName,
            int played,
            int won,
            int drawn,
            int lost,
            int goalsFor,
            int goalsAgainst,
            int goalDifference,
            int points) {
        this.teamName = teamName;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    /**
     * @return team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @return number of matches played
     */
    public int getPlayed() {
        return played;
    }

    /**
     * @return number of matches won
     */
    public int getWon() {
        return won;
    }

    /**
     * @return number of matches drawn
     */
    public int getDrawn() {
        return drawn;
    }

    /**
     * @return number of matches lost
     */
    public int getLost() {
        return lost;
    }

    /**
     * @return total goals scored
     */
    public int getGoalsFor() {
        return goalsFor;
    }

    /**
     * @return total goals conceded
     */
    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    /**
     * @return goal difference
     */
    public int getGoalDifference() {
        return goalDifference;
    }

    /**
     * @return total league points
     */
    public int getPoints() {
        return points;
    }
}