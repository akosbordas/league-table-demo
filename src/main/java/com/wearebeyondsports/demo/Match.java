package com.wearebeyondsports.demo;

/**
 * Represents a completed football match between two teams.
 *
 * <p>
 * The match contains the participating team names and the final score.
 * Instances are immutable after creation.
 * </p>
 */
public final class Match {

    private final String homeTeam;
    private final String awayTeam;
    private final int homeScore;
    private final int awayScore;

    /**
     * Creates a completed football match.
     *
     * @param homeTeam  name of the home team
     * @param awayTeam  name of the away team
     * @param homeScore goals scored by the home team
     * @param awayScore goals scored by the away team
     */
    public Match(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    /**
     * @return name of the home team
     */
    public String getHomeTeam() {
        return homeTeam;
    }

    /**
     * @return name of the away team
     */
    public String getAwayTeam() {
        return awayTeam;
    }

    /**
     * @return goals scored by the home team
     */
    public int getHomeScore() {
        return homeScore;
    }

    /**
     * @return goals scored by the away team
     */
    public int getAwayScore() {
        return awayScore;
    }
}