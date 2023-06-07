package com.oguzhan.homework.mapper;

import com.oguzhan.homework.entity.Country;
import com.oguzhan.homework.dto.request.CountryDtoRequest;
import com.oguzhan.homework.dto.response.CountryDtoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CountryMapper {

    List<CountryDtoResponse> countriesToCountryDtoResponses(List<Country> countries);

    CountryDtoResponse countryToCountryDtoResponse(Country country);

    Country countryDtoRequestToCountry(CountryDtoRequest countryDtoRequest);

    Country countryDtoResponseToCountry(CountryDtoResponse countryDtoResponse);

}
