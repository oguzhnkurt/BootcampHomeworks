package com.oguzhan.homework.servicempl;

import com.oguzhan.homework.dto.response.CountryDtoResponse;
import com.oguzhan.homework.dto.request.CountryDtoRequest;
import com.oguzhan.homework.entity.Country;
import com.oguzhan.homework.mapper.CountryMapper;
import org.springframework.stereotype.Service;
import com.oguzhan.homework.repository.CountryRepository;
import com.oguzhan.homework.service.CountryService;
import java.util.List;

@Service

public class CountryServicelmpl implements CountryService {

    private CountryRepository countryRepository;
    private CountryMapper countryMapper;

    public CountryServicelmpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public Country saveCountry(CountryDtoRequest countryDtoRequest) {
        Country country = countryMapper.countryDtoRequestToCountry(countryDtoRequest);
        return countryRepository.save(country);
    }

    @Override
    public List<CountryDtoResponse> getAllCountries() {
        List<Country> countriesInDb = countryRepository.findAll();
        return countryMapper.countriesToCountryDtoResponses(countriesInDb);
    }

    @Override
    public CountryDtoResponse getCountryById(Long id) {
        Country country = countryRepository.findById(id).orElseThrow();
        return countryMapper.countryToCountryDtoResponse(country);
    }

    @Override
    public CountryDtoResponse updatePresident(Long id, String president) {
        Country country = countryRepository.findById(id).orElseThrow();
        country.setPresident(president);
        countryRepository.save(country);
        return countryMapper.countryToCountryDtoResponse(country);
    }

    @Override
    public void deleteCountry(Long id) {
        Country country = countryMapper.countryDtoResponseToCountry(getCountryById(id));
        countryRepository.delete(country);
    }
}
