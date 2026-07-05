package com.wearebeyondsports.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeagueTableTest {

    @Test
    void shouldReturnEmptyTableWhenThereAreNoMatches() {
        LeagueTable leagueTable = new LeagueTable(List.of());

        assertTrue(leagueTable.getTableEntries().isEmpty());
    }

    @Test
    void shouldBuildLeagueTableEntriesForAllTeams() {
        List<Match> matches = List.of(
            new Match("Arsenal", "Chelsea", 2, 1),
            new Match("Chelsea", "Liverpool", 1, 1),
            new Match("Liverpool", "Arsenal", 3, 0)
        );

        LeagueTable leagueTable = new LeagueTable(matches);
        List<LeagueTableEntry> entries = leagueTable.getTableEntries();

        assertEquals(3, entries.size());

        LeagueTableEntry liverpool = entries.get(0);
        assertEquals("Liverpool", liverpool.getTeamName());
        assertEquals(2, liverpool.getPlayed());
        assertEquals(1, liverpool.getWon());
        assertEquals(1, liverpool.getDrawn());
        assertEquals(0, liverpool.getLost());
        assertEquals(4, liverpool.getGoalsFor());
        assertEquals(1, liverpool.getGoalsAgainst());
        assertEquals(3, liverpool.getGoalDifference());
        assertEquals(4, liverpool.getPoints());
    }

    @Test
    void shouldSortByPointsDescending() {
        List<Match> matches = List.of(
            new Match("Arsenal", "Chelsea", 2, 0),
            new Match("Liverpool", "Chelsea", 1, 1)
        );

        LeagueTable leagueTable = new LeagueTable(matches);
        List<LeagueTableEntry> entries = leagueTable.getTableEntries();

        assertEquals("Arsenal", entries.get(0).getTeamName());
        assertEquals("Liverpool", entries.get(1).getTeamName());
        assertEquals("Chelsea", entries.get(2).getTeamName());
    }

    @Test
    void shouldSortByGoalDifferenceWhenPointsAreEqual() {
        List<Match> matches = List.of(
            new Match("Arsenal", "Chelsea", 3, 0),
            new Match("Liverpool", "Tottenham", 2, 0)
        );

        LeagueTable leagueTable = new LeagueTable(matches);
        List<LeagueTableEntry> entries = leagueTable.getTableEntries();

        assertEquals("Arsenal", entries.get(0).getTeamName());
        assertEquals("Liverpool", entries.get(1).getTeamName());
    }

    @Test
    void shouldSortByGoalsForWhenPointsAndGoalDifferenceAreEqual() {
        List<Match> matches = List.of(
            new Match("Arsenal", "Chelsea", 3, 1),
            new Match("Liverpool", "Tottenham", 2, 0)
        );

        LeagueTable leagueTable = new LeagueTable(matches);
        List<LeagueTableEntry> entries = leagueTable.getTableEntries();

        assertEquals("Arsenal", entries.get(0).getTeamName());
        assertEquals("Liverpool", entries.get(1).getTeamName());
    }

    @Test
    void shouldSortByTeamNameWhenPointsGoalDifferenceAndGoalsForAreEqual() {
        List<Match> matches = List.of(
            new Match("Arsenal", "Chelsea", 1, 0),
            new Match("Liverpool", "Tottenham", 1, 0)
        );

        LeagueTable leagueTable = new LeagueTable(matches);
        List<LeagueTableEntry> entries = leagueTable.getTableEntries();

        assertEquals("Arsenal", entries.get(0).getTeamName());
        assertEquals("Liverpool", entries.get(1).getTeamName());
    }
}