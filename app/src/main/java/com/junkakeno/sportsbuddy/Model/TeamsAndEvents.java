package com.junkakeno.sportsbuddy.Model;

import java.util.ArrayList;

public class TeamsAndEvents {

    Teams teams;
    Events events;

    public TeamsAndEvents(Teams teams, Events events) {
        this.teams = teams;
        this.events = events;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }
}
