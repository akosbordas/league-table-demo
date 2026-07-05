package com.wearebeyondsports.demo;

/**
 * Factory responsible for converting accumulated team statistics into league table entries.
 *
 * <p>The factory is stateless, therefore a single shared instance is sufficient.
 * Keeping this mapping in a dedicated factory makes the conversion explicit and
 * easy to test independently from league table aggregation and sorting.</p>
 */
public final class LeagueTableEntryFactory {

    /**
     * Shared singleton instance.
     */
    public static final LeagueTableEntryFactory INSTANCE = new LeagueTableEntryFactory();

    private LeagueTableEntryFactory() {
    }

    /**
     * Creates a league table entry from the supplied team statistics.
     *
     * @param statistics accumulated statistics for a team
     * @return league table entry representing the supplied statistics
     */
    public LeagueTableEntry createFrom(TeamStatistics statistics) {
        return new LeagueTableEntry(
            statistics.getTeamName(),
            statistics.getPlayed(),
            statistics.getWon(),
            statistics.getDrawn(),
            statistics.getLost(),
            statistics.getGoalsFor(),
            statistics.getGoalsAgainst(),
            statistics.getGoalDifference(),
            statistics.getPoints()
        );
    }
}