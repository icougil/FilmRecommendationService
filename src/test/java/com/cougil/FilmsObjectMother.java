package com.cougil;

import java.util.Arrays;

public class FilmsObjectMother {
    public static final Film MATRIX = new Film(12345, "The Matrix", 1999,
            Arrays.asList("artificial reality", "computers", "technology", "hacker", "post apocalypse"),
            Arrays.asList("science-fiction", "thriller", "action"));
    public static final Film STAR_WARS_EPISODE_IV = new Film(45678,
            "Star Wars. Episode IV: A new hope", 1977,
            Arrays.asList("space", "galactic war", "droids", "rebellion"),
            Arrays.asList("science-fiction", "adventures", "fantasy"));
}
