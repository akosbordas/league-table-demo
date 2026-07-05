package com.wearebeyondsports.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamStatisticsTest {

    @Test
    void shouldRecordWin() {
        TeamStatistics statistics = new TeamStatistics("Arsenal");

        statistics.recordResult(2, 1);

        assertEquals(1, statistics.getPlayed());
        assertEquals(1, statistics.getWon());
        assertEquals(0, statistics.getDrawn());
        assertEquals(0, statistics.getLost());
        assertEquals(2, statistics.getGoalsFor());
        assertEquals(1, statistics.getGoalsAgainst());
        assertEquals(1, statistics.getGoalDifference());
        assertEquals(3, statistics.getPoints());
    }

    @Test
    void shouldRecordDraw() {
        TeamStatistics statistics = new TeamStatistics("Chelsea");

        statistics.recordResult(1, 1);

        assertEquals(1, statistics.getPlayed());
        assertEquals(0, statistics.getWon());
        assertEquals(1, statistics.getDrawn());
        assertEquals(0, statistics.getLost());
        assertEquals(1, statistics.getGoalsFor());
        assertEquals(1, statistics.getGoalsAgainst());
        assertEquals(0, statistics.getGoalDifference());
        assertEquals(1, statistics.getPoints());
    }

    @Test
    void shouldRecordLoss() {
        TeamStatistics statistics = new TeamStatistics("Liverpool");

        statistics.recordResult(0, 3);

        assertEquals(1, statistics.getPlayed());
        assertEquals(0, statistics.getWon());
        assertEquals(0, statistics.getDrawn());
        assertEquals(1, statistics.getLost());
        assertEquals(0, statistics.getGoalsFor());
        assertEquals(3, statistics.getGoalsAgainst());
        assertEquals(-3, statistics.getGoalDifference());
        assertEquals(0, statistics.getPoints());
    }
}