package com.oguzhan.homework.service;

import com.oguzhan.homework.entity.Country;
import com.oguzhan.homework.dto.request.CountryDtoRequest;
import com.oguzhan.homework.dto.response.CountryDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CountryService {
    Country saveCountry(CountryDtoRequest countryDtoRequest);
    List<CountryDtoResponse> getAllCountries();
    CountryDtoResponse getCountryById(Long id);
    CountryDtoResponse updatePresident(Long id, String president);
    void deleteCountry(Long id);

}
