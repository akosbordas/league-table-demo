package com.wearebeyondsports.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeagueTableEntryFactoryTest {

    @Test
    void shouldCreateLeagueTableEntryFromTeamStatistics() {
        TeamStatistics statistics = new TeamStatistics("Arsenal");

        statistics.recordResult(2, 1);
        statistics.recordResult(1, 1);

        LeagueTableEntry entry = LeagueTableEntryFactory.INSTANCE.createFrom(statistics);

        assertEquals("Arsenal", entry.getTeamName());
        assertEquals(2, entry.getPlayed());
        assertEquals(1, entry.getWon());
        assertEquals(1, entry.getDrawn());
        assertEquals(0, entry.getLost());
        assertEquals(3, entry.getGoalsFor());
        assertEquals(2, entry.getGoalsAgainst());
        assertEquals(1, entry.getGoalDifference());
        assertEquals(4, entry.getPoints());
    }
}