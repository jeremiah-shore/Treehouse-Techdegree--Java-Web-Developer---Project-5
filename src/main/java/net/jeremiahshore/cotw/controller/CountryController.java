package net.jeremiahshore.cotw.controller;

import net.jeremiahshore.cotw.data.CountryRepository;
import net.jeremiahshore.cotw.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Jeremiah on 7/30/2016.
 */

@Controller
public class CountryController {
    @Autowired private CountryRepository countryRepository;

    // TODO: enable "/" to redirect to "/countries

    @RequestMapping("/")
    public String listCountries(ModelMap modelMap) {
        List<Country> countries = countryRepository.getAllCountries();
        modelMap.put("countries", countries);
        return "home";
    }

    @RequestMapping("/countries/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap) {
        Country country = countryRepository.findByName(name);
        modelMap.put("country", country);
        return "country-detail";
    }
}
