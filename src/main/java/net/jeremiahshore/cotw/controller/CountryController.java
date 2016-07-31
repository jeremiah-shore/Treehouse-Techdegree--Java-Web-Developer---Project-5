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

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        return listCountries(modelMap);
    }

    @RequestMapping("/countries")
    public String listCountries(ModelMap modelMap) {
        if(modelMap.get("countries") == null) {
            List<Country> countries = countryRepository.getAllCountries();
            modelMap.put("countries", countries);
        }
        return "home";
    }

    @RequestMapping("/countries/sort/{sortMethod}")
    public String listSortedCountries(@PathVariable String sortMethod, ModelMap modelMap) {
        List<Country> countries = countryRepository.getAllCountries();
        switch (sortMethod) {
            case "name":
                countries.sort((Country o1, Country o2) -> o1.getName().compareTo(o2.getName()));
                break;
            case "population":
                countries.sort((Country o1, Country o2) -> o2.getPopulation() - o1.getPopulation()); //o2 first to sort descending (greatest population)
                break;
        }
        modelMap.put("countries", countries);
        modelMap.put("sortmethod", sortMethod);
        return listCountries(modelMap);
    }

    @RequestMapping("/countries/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap) {
        Country country = countryRepository.findByName(name);
        modelMap.put("country", country);
        return "country-detail";
    }
}
