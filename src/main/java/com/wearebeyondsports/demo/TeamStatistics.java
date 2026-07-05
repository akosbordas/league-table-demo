package com.wearebeyondsports.demo;

/**
 * Holds accumulated statistics for a single football team.
 *
 * <p>
 * This class is used while building the league table. It represents mutable
 * aggregation state, whereas {@link LeagueTableEntry} represents the final
 * read-only table row exposed to callers.
 * </p>
 */
public final class TeamStatistics {

    private static final int POINTS_FOR_WIN = 3;
    private static final int POINTS_FOR_DRAW = 1;

    private final String teamName;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;

    /**
     * Creates an empty statistics record for the supplied team.
     *
     * @param teamName name of the team
     */
    public TeamStatistics(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Records a completed match result from this team's perspective.
     *
     * <p>
     * The first argument is always the number of goals scored by this team,
     * and the second argument is always the number of goals conceded by this team.
     * For example, a 2-1 home win is recorded as {@code 2, 1} for the home team
     * and {@code 1, 2} for the away team.
     * </p>
     *
     * @param goalsScored   goals scored by this team
     * @param goalsConceded goals conceded by this team
     */
    public void recordResult(int goalsScored, int goalsConceded) {
        played++;
        goalsFor += goalsScored;
        goalsAgainst += goalsConceded;

        if (goalsScored > goalsConceded) {
            won++;
        } else if (goalsScored < goalsConceded) {
            lost++;
        } else {
            drawn++;
        }
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
     * Calculates goal difference.
     *
     * @return goals scored minus goals conceded
     */
    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    /**
     * Calculates league points according to the football scoring rules.
     *
     * @return total points
     */
    public int getPoints() {
        return won * POINTS_FOR_WIN + drawn * POINTS_FOR_DRAW;
    }
}