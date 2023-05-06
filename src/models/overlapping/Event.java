package models.overlapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Event {
    private EnumSet<EventType> types;

    private String eventName, location;

    private LocalDateTime eventStartTime;

    // Concert
    private String concertName;
    private Set<String> artists;

    // Sports game
    private String gameName;
    private Set<String> teams; // at least 2

    // Party
    private String partyName;

    public Event(EnumSet<EventType> types,
                 String eventName, String location, LocalDateTime eventStartTime, // common
                 String concertName, Set<String> artists, // concert
                 String gameName, Set<String> teams,  // sports game
                 String partyName) // party
    {
        setTypes(types);

        setEventName(eventName);
        setLocation(location);
        setEventStartTime(eventStartTime);

        if(types.contains(EventType.CONCERT)) {
            setConcertName(concertName);
            setArtists(artists);
        }
        if(types.contains(EventType.SPORTSGAME)) {
            setGameName(gameName);
            setTeams(teams);
        }
        if(types.contains(EventType.PARTY)) {
            setPartyName(partyName);
        }
    }




    public Set<EventType> getTypes() {
        return Collections.unmodifiableSet(types); // returns a Set, not EnumSet
    }

    private void setTypes(EnumSet<EventType> types) { // private, can't change types after initialization
        if(types == null) throw new IllegalArgumentException("Event needs types to be created");
        if(types.size() < 1) throw new IllegalArgumentException("Event needs at least one event type");
        if(types.size() > 3) throw new IllegalArgumentException("There are only 3 types of events, more has been selected");

        this.types = types;
    }



    // COMMON
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        if(eventName == null || eventName.isBlank()) throw new IllegalArgumentException("Event's name is required");

        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if(location == null || location.isBlank()) throw new IllegalArgumentException("Event's location is required");

        this.location = location;
    }

    public LocalDateTime getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(LocalDateTime eventStartTime) {
        if(eventStartTime == null) throw new IllegalArgumentException("Event's start time is required");
        if(eventStartTime.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("A new event cannot start in the past, choose a later time");

        this.eventStartTime = eventStartTime;
    }



    // CONCERT

    public String getConcertName() {
        if(!this.types.contains(EventType.CONCERT)) throw new IllegalArgumentException("Selected event doesn't contain a concert event");

        return concertName;
    }

    public void setConcertName(String concertName) {
        if(!this.types.contains(EventType.CONCERT)) throw new IllegalArgumentException("Selected event doesn't contain a concert event");

        if(concertName == null || concertName.isBlank()) throw new IllegalArgumentException("Concert's name is required");

        this.concertName = concertName;
    }

    public Set<String> getArtists() {
        if(!this.types.contains(EventType.CONCERT)) throw new IllegalArgumentException("Selected event doesn't contain a concert event");

        return Collections.unmodifiableSet(artists);
    }

    private void setArtists(Set<String> artists) { // private, cannot set a list
        if(!this.types.contains(EventType.CONCERT)) throw new IllegalArgumentException("Selected event doesn't contain a concert event");

        if(artists == null) throw new IllegalArgumentException("Artist list is required for concert");
        if(artists.size() < 1) throw new IllegalStateException("At least one artist is required for a concert");

        this.artists = new HashSet<>(artists);
    }

    public void addArtist(String artist) {
        if(!this.types.contains(EventType.CONCERT)) throw new IllegalArgumentException("Selected event doesn't contain a concert event");

        if(artist == null || artist.isBlank()) throw new IllegalArgumentException("Artist's name is required");
        if(artists.contains(artist)) throw new IllegalArgumentException("This event already has this artist listed");

        artists.add(artist);
    }

    public void removeArtist(String artist) {
        if(!this.types.contains(EventType.CONCERT)) throw new IllegalArgumentException("Selected event doesn't contain a concert event");

        if(artist == null || artist.isBlank()) throw new IllegalArgumentException("Artist's name is required");
        if(!artists.contains(artist)) throw new IllegalArgumentException("Selected artist isn't listed in this event");
        if(artists.size() == 1) throw new IllegalStateException("Cannot remove the last artist from the artists list");

        artists.remove(artist);
    }



    // SPORTS GAME

    public String getGameName() {
        if(!this.types.contains(EventType.SPORTSGAME)) throw new IllegalArgumentException("Selected event doesn't contain a sports game event");

        return gameName;
    }

    public void setGameName(String gameName) {
        if(!this.types.contains(EventType.SPORTSGAME)) throw new IllegalArgumentException("Selected event doesn't contain a sports game event");

        if(gameName == null || gameName.isBlank()) throw new IllegalArgumentException("Game's name is required");

        this.gameName = gameName;
    }

    public Set<String> getTeams() {
        if(!this.types.contains(EventType.SPORTSGAME)) throw new IllegalArgumentException("Selected event doesn't contain a sports game event");

        return Collections.unmodifiableSet(teams);
    }

    private void setTeams(Set<String> teams) {
        if(!this.types.contains(EventType.SPORTSGAME)) throw new IllegalArgumentException("Selected event doesn't contain a sports game event");

        if(teams == null) throw new IllegalArgumentException("Teams list is required for sports game");
        if(teams.size() < 2) throw new IllegalStateException("At least two teams are required for a sports game");

        this.teams = new HashSet<>(teams);
    }

    public void addTeam(String team) {
        if(!this.types.contains(EventType.SPORTSGAME)) throw new IllegalArgumentException("Selected event doesn't contain a sports game event");

        if(team == null || team.isBlank()) throw new IllegalArgumentException("Team's name is required");
        if(teams.contains(team)) throw new IllegalArgumentException("This event already has this team listed");

        teams.add(team);
    }

    public void removeTeam(String team) {
        if(!this.types.contains(EventType.SPORTSGAME)) throw new IllegalArgumentException("Selected event doesn't contain a sports game event");

        if(team == null || team.isBlank()) throw new IllegalArgumentException("Team's name is required");
        if(!teams.contains(team)) throw new IllegalArgumentException("Selected team isn't listed in this event");
        if(teams.size() == 2) throw new IllegalStateException("Cannot remove the last two teams from the list");

        teams.remove(team);
    }



    // PARTY

    public String getPartyName() {
        if(!this.types.contains(EventType.PARTY)) throw new IllegalArgumentException("Selected event doesn't contain a party event");

        return partyName;
    }

    public void setPartyName(String partyName) {
        if(!this.types.contains(EventType.PARTY)) throw new IllegalArgumentException("Selected event doesn't contain a party event");

        if(partyName == null || partyName.isBlank()) throw new IllegalArgumentException("Party's name is required");

        this.partyName = partyName;
    }
}
