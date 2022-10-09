package com.swapi.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapiDaoTest {

    @Test
    void getPlanetSuccess() {
        SwapiDao dao = new SwapiDao();
        assertEquals("Tatooine", dao.getPlanet().getName());
    }
}