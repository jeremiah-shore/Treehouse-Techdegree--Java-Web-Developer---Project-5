package net.jeremiahshore.cotw.data;

import net.jeremiahshore.cotw.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeremiah on 7/30/2016.
 */

@Component
public class CountryRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("Germany", 80970700, "Berlin", new String[] {"German"}),
            new Country("India", 1293057000, "New Delhi", new String[] {"Hindi", "English"}),
            new Country("England", 54786300, "London", new String[] {"English"}),
            new Country("Brazil", 205338000, "Brasília", new String[] {"Portuguese"}),
            new Country("France", 66217500, "Paris", new String[] {"French"})
    );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country findByName(String name) {
        return ALL_COUNTRIES
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
