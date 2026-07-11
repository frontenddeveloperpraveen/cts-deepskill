package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        // Run verification test cases
        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testFindCountriesByNameContaining();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start testFindCountryByCode");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Found Country: {}", country);
            
            // Test lookup with invalid code
            countryService.findCountryByCode("XX");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Expected exception caught successfully: {}", e.getMessage());
        }
        LOGGER.info("End testFindCountryByCode");
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        try {
            Country country = new Country("ZZ", "Zombieland");
            countryService.addCountry(country);
            
            Country retrieved = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Successfully added: {}", retrieved);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to add country: {}", e.getMessage());
        }
        LOGGER.info("End testAddCountry");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        try {
            countryService.updateCountry("ZZ", "Zombieland Updated");
            Country retrieved = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Successfully updated: {}", retrieved);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to update country: {}", e.getMessage());
        }
        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        try {
            countryService.deleteCountry("ZZ");
            countryService.findCountryByCode("ZZ");
            LOGGER.error("Country ZZ was not deleted successfully!");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Successfully deleted ZZ (CountryNotFoundException thrown as expected: {})", e.getMessage());
        }
        LOGGER.info("End testDeleteCountry");
    }

    private static void testFindCountriesByNameContaining() {
        LOGGER.info("Start testFindCountriesByNameContaining");
        List<Country> results = countryService.findCountriesByNameContaining("In");
        LOGGER.debug("Matching partial name 'In': {}", results);
        LOGGER.info("End testFindCountriesByNameContaining");
    }
}
