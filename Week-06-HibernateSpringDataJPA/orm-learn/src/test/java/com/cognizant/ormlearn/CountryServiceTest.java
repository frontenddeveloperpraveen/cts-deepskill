package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void testGetAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
    }

    @Test
    public void testFindCountryByCodeSuccess() throws CountryNotFoundException {
        Country country = countryService.findCountryByCode("IN");
        assertNotNull(country);
        assertEquals("India", country.getName());
    }

    @Test
    public void testFindCountryByCodeNotFound() {
        assertThrows(CountryNotFoundException.class, () -> {
            countryService.findCountryByCode("XX");
        });
    }

    @Test
    public void testAddUpdateDeleteCountry() throws CountryNotFoundException {
        // Add
        Country newCountry = new Country("ZZ", "Zombieland");
        countryService.addCountry(newCountry);
        
        Country retrieved = countryService.findCountryByCode("ZZ");
        assertNotNull(retrieved);
        assertEquals("Zombieland", retrieved.getName());

        // Update
        countryService.updateCountry("ZZ", "Zombieland Updated");
        Country updated = countryService.findCountryByCode("ZZ");
        assertEquals("Zombieland Updated", updated.getName());

        // Delete
        countryService.deleteCountry("ZZ");
        assertThrows(CountryNotFoundException.class, () -> {
            countryService.findCountryByCode("ZZ");
        });
    }

    @Test
    public void testFindCountriesByNameContaining() {
        List<Country> results = countryService.findCountriesByNameContaining("In");
        assertNotNull(results);
        assertTrue(results.size() > 0);
        // Verify that India is in the results list
        boolean hasIndia = results.stream().anyMatch(c -> c.getCode().equalsIgnoreCase("IN"));
        assertTrue(hasIndia);
    }
}
