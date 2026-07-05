package com.wearebeyondsports.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generates a sorted football league table from a list of completed matches.
 *
 * <p>The table is calculated once during construction. Calling
 * {@link #getTableEntries()} returns the already calculated and sorted table.</p>
 *
 * <p>Entries are sorted by the following rules:</p>
 * <ol>
 *     <li>Total points, descending</li>
 *     <li>Goal difference, descending</li>
 *     <li>Goals scored, descending</li>
 *     <li>Team name, ascending</li>
 * </ol>
 */
public final class LeagueTable {

    private static final Comparator<LeagueTableEntry> LEAGUE_TABLE_ORDER =
        Comparator.comparingInt(LeagueTableEntry::getPoints).reversed()
            .thenComparing(Comparator.comparingInt(LeagueTableEntry::getGoalDifference).reversed())
            .thenComparing(Comparator.comparingInt(LeagueTableEntry::getGoalsFor).reversed())
            .thenComparing(LeagueTableEntry::getTeamName);

    private final List<LeagueTableEntry> tableEntries;

    /**
     * Creates a league table from the supplied completed matches.
     *
     * @param matches completed matches used to build the table
     */
    public LeagueTable(List<Match> matches) {
        this.tableEntries = buildTableEntries(matches);
    }

    /**
     * Returns the calculated league table entries sorted according to the league rules.
     *
     * @return sorted league table entries
     */
    public List<LeagueTableEntry> getTableEntries() {
        return tableEntries;
    }

    private List<LeagueTableEntry> buildTableEntries(List<Match> matches) {
        Map<String, TeamStatistics> statisticsByTeam = new HashMap<>();

        for (Match match : matches) {
            processMatch(statisticsByTeam, match);
        }

        return statisticsByTeam.values().stream()
            .map(LeagueTableEntryFactory.INSTANCE::createFrom)
            .sorted(LEAGUE_TABLE_ORDER)
            .toList();
    }

    private void processMatch(Map<String, TeamStatistics> statisticsByTeam, Match match) {
        String homeTeam = match.getHomeTeam();
        String awayTeam = match.getAwayTeam();

        int homeScore = match.getHomeScore();
        int awayScore = match.getAwayScore();

        TeamStatistics homeStatistics = statisticsByTeam.computeIfAbsent(homeTeam, TeamStatistics::new);
        TeamStatistics awayStatistics = statisticsByTeam.computeIfAbsent(awayTeam, TeamStatistics::new);

        homeStatistics.recordResult(homeScore, awayScore);
        awayStatistics.recordResult(awayScore, homeScore);
    }
}