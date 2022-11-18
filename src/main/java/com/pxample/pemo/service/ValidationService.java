package com.pxample.pemo.service;

import com.pxample.pemo.exception.CityScoreException;
import com.pxample.api.CityScore.CityScoreErrorCode;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void validateCityCode(Integer cityCode) {
        checkIfNull(cityCode);
        checkIfValid(cityCode);
    }

    private void checkIfNull (Integer cityCode) {
        if (null == cityCode) {
            throw new CityScoreException(CityScoreErrorCode.CITY_CODE_CANNOT_BE_NULL);
        }
    }

    private void checkIfValid (Integer cityCode) {
        if (cityCode < 1 || cityCode > 81) {
            throw new CityScoreException(CityScoreErrorCode.INVALID_CITY_CODE_VALUE);
        }
    }
}