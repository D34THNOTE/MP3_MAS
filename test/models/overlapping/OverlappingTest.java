package models.overlapping;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class OverlappingTest {

    Event concertOnly;
    Event concert_sportsGame;

    @Before
    public void setup() {
        concertOnly = new Event(EnumSet.of(EventType.CONCERT), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", Set.of("Palisades", "Sum 41"),
                null, null, null);
        concert_sportsGame = new Event(EnumSet.of(EventType.CONCERT, EventType.SPORTSGAME), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", Set.of("Palisades", "Sum 41"),
                "Championship of spaghetti", Set.of("Kluchas", "Pieluchas"), null);
    }

    @Test
    public void testInheritance() {
        assertEquals(1, concertOnly.getTypes().size());
        assertEquals(2, concert_sportsGame.getTypes().size());

        assertEquals("Championship of spaghetti", concert_sportsGame.getGameName());
        assertEquals("Fun concerts", concertOnly.getEventName());

        assertThrows(IllegalArgumentException.class, () -> concertOnly.getGameName());
        assertThrows(IllegalArgumentException.class, () -> concertOnly.getPartyName());
        assertThrows(IllegalArgumentException.class, () -> concertOnly.getTeams());
        assertThrows(IllegalArgumentException.class, () -> concertOnly.addTeam("Legit name"));
        assertThrows(IllegalArgumentException.class, () -> concertOnly.removeTeam("Legit name"));
        assertThrows(IllegalArgumentException.class, () -> concertOnly.setPartyName("Legit name"));
        assertThrows(IllegalArgumentException.class, () -> concertOnly.setGameName("Legit name"));
        assertThrows(IllegalArgumentException.class, () -> concert_sportsGame.getPartyName());

        assertEquals(2, concertOnly.getArtists().size());
        concertOnly.addArtist("Beata Szydlo");
        assertEquals(3, concertOnly.getArtists().size());
        concertOnly.removeArtist("Beata Szydlo");
        assertEquals(2, concertOnly.getArtists().size());

        // same / existing / non-existing names test
        assertThrows(IllegalArgumentException.class, () -> concertOnly.addArtist("Sum 41"));
        assertThrows(IllegalArgumentException.class, () -> concertOnly.removeArtist("this doesn't exist"));

        assertThrows(IllegalArgumentException.class, () -> concert_sportsGame.addTeam("Pieluchas"));
        assertThrows(IllegalArgumentException.class, () -> concert_sportsGame.removeTeam("this doesn't exist"));


        // passing arguments for event types which weren't assigned - they don't exist
        Event partyOnly = new Event(EnumSet.of(EventType.PARTY), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Non-existent", Set.of("Palisades", "Sum 41"),
                "Championship of spaghetti", Set.of("Kluchas", "Pieluchas"), "Fun times");
        assertThrows(IllegalArgumentException.class, () -> partyOnly.getGameName());
        assertThrows(IllegalArgumentException.class, () -> partyOnly.setGameName("Legit name"));
        assertThrows(IllegalArgumentException.class, () -> partyOnly.getTeams());
        assertThrows(IllegalArgumentException.class, () -> partyOnly.addTeam("Legit name"));
        assertThrows(IllegalArgumentException.class, () -> partyOnly.removeTeam("Legit name"));
        assertThrows(IllegalArgumentException.class, () -> partyOnly.getConcertName());
        assertThrows(IllegalArgumentException.class, () -> partyOnly.getArtists());
        assertThrows(IllegalArgumentException.class, () -> partyOnly.addArtist("Legit name"));
        assertThrows(IllegalArgumentException.class, () -> partyOnly.removeArtist("Legit name"));

        // creating illegitimate instances
        EnumSet<EventType> emptySet = EnumSet.noneOf(EventType.class);
        assertThrows(IllegalArgumentException.class, () -> new Event(emptySet, "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), null, null,
                null, null, null));

        // wrong date
        assertThrows(IllegalArgumentException.class, () -> new Event(EnumSet.of(EventType.CONCERT, EventType.SPORTSGAME),
                "Fun concerts", "some address",
                LocalDateTime.of(1992, 2, 3, 5, 6), null, null,
                null, null, null));

        // lacking arguments
        assertThrows(IllegalArgumentException.class, () -> new Event(EnumSet.of(EventType.CONCERT, EventType.SPORTSGAME), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", Set.of("Palisades", "Sum 41"),
                "Championship of spaghetti", null, null));
        assertThrows(IllegalArgumentException.class, () -> new Event(EnumSet.of(EventType.CONCERT, EventType.SPORTSGAME), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", Set.of("Palisades", "Sum 41"),
                null, Set.of("Kluchas", "Pieluchas"), null));
        assertThrows(IllegalArgumentException.class, () -> new Event(EnumSet.of(EventType.CONCERT, EventType.SPORTSGAME), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", null,
                "Championship of spaghetti", Set.of("Kluchas", "Pieluchas"), null));
        assertThrows(IllegalArgumentException.class, () -> new Event(EnumSet.of(EventType.CONCERT, EventType.SPORTSGAME), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), null, Set.of("Palisades", "Sum 41"),
                "Championship of spaghetti", Set.of("Kluchas", "Pieluchas"), null));
        assertThrows(IllegalArgumentException.class, () -> new Event(EnumSet.of(EventType.PARTY), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", Set.of("Palisades", "Sum 41"),
                "Championship of spaghetti", Set.of("Kluchas", "Pieluchas"), null));
        assertThrows(IllegalArgumentException.class, () -> new Event(EnumSet.of(EventType.PARTY), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", Set.of("Palisades", "Sum 41"),
                "Championship of spaghetti", Set.of("Kluchas", "Pieluchas"), "")); // empty String
        // too small set of Teams
        assertThrows(IllegalStateException.class, () -> new Event(EnumSet.of(EventType.CONCERT, EventType.SPORTSGAME), "Fun concerts", "some address",
                LocalDateTime.now().plusDays(2), "Fun concerts", Set.of("Palisades", "Sum 41"),
                "Helo", Set.of("Kluchas"), null));

        concertOnly.setConcertName("Test");
        assertEquals("Test", concertOnly.getConcertName());

        concertOnly.setEventName("Testing");
        assertEquals("Testing", concertOnly.getEventName());

        assertEquals(2, concert_sportsGame.getTeams().size());
        concert_sportsGame.addTeam("Beata Szydlo");
        assertEquals(3, concert_sportsGame.getTeams().size());
        concert_sportsGame.removeTeam("Beata Szydlo");
        assertEquals(2, concert_sportsGame.getTeams().size());

        // can't remove a team because there has to be at least 2
        assertEquals(2, concert_sportsGame.getTeams().size());
        assertThrows(IllegalStateException.class, () -> concert_sportsGame.removeTeam("Pieluchas"));
        assertEquals(2, concert_sportsGame.getTeams().size());

        assertEquals(2, concertOnly.getArtists().size());
        concertOnly.removeArtist("Sum 41");
        assertEquals(1, concertOnly.getArtists().size());
        assertThrows(IllegalStateException.class, () -> concertOnly.removeArtist("Palisades"));
    }
}
