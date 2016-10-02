package com.crossover.trial.weather.services;

import java.util.List;
import java.util.Set;

import com.crossover.trial.weather.models.Airport;
import com.crossover.trial.weather.models.Atmosphereinfo;
import com.crossover.trial.weather.models.DataPoint;

/**
 * DAO for business objects
 */
public interface AirportDao {

    /**
     * Given an iataCode find the airport data
     *
     * @param iataCode as a string
     * @return airport data or null if not found
     */
    Airport findAirportData(String iataCode);

    /**
     * Given an iataCode and radius find airports within the radius
     *
     * @param iataCode as a string
     * @param radius   as a double
     * @return set of airports or empty collection if not found
     */
    Set<Airport> findNearbyAirports(String iataCode, double radius);

    /**
     * Get all IATA codes of the airports stored in the database
     *
     * @return set of airport IATA codes
     */
    Set<String> getAllAirportCodes();

    /**
     * Save airport data to the database
     *
     * @param ad as an AirportData
     */
    void saveAirport(Airport ad);

    /**
     * Delete airport data and it's atmospheric information from the database
     *
     * @param iataCode as a string
     */
    void deleteAirport(String iataCode);

    /**
     * Given an iataCode find atmospheric information around the airport
     *
     * @param iataCode as a string
     * @return atmospheric information or null if not found
     */
    Atmosphereinfo findAtmosphericInformation(String iataCode);

    /**
     * Given an iataCode and radius find atmospheric information around the airports within the radius
     *
     * @param iataCode as a string
     * @param radius   as a double
     * @return list of objects or empty collection if not found
     */
    List<Atmosphereinfo> findAtmosphericInformationNearbyAirport(String iataCode, double radius);

    /**
     * Update atmospheric information with the given data point for the given point type
     *
     * @param iataCode  airport iata code
     * @param pointType the data point type as a string
     * @param dp        the actual data point
     */
    void updateAtmosphericInformation(String iataCode, String pointType, DataPoint dp);

    /**
     * Delete atmospheric information of particular airport from the database
     *
     * @param iataCode as a string
     */
    void deleteAtmosphericInformation(String iataCode);

}
