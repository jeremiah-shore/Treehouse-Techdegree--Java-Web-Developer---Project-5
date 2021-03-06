package net.jeremiahshore.cotw.model;

import java.text.NumberFormat;

/**
 * Created by Jeremiah on 7/30/2016.
 */

public class Country {
    private String name;
    private int population;
    private String capital;
    private String[] languages;

    public Country(String name, int population, String capital, String[] languages) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public String getPopulationText() {
        return NumberFormat.getIntegerInstance().format(population);
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
