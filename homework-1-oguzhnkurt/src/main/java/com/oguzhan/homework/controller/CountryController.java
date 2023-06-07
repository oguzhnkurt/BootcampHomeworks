package com.oguzhan.homework.controller;

import com.oguzhan.homework.dto.request.CountryDtoRequest;
import com.oguzhan.homework.dto.response.CountryDtoResponse;
import com.oguzhan.homework.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oguzhan.homework.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/countries")

public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryDtoResponse>> getAllCountries() {
        List<CountryDtoResponse> countryDtoResponseList = countryService.getAllCountries();
        return ResponseEntity.ok(countryDtoResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDtoResponse> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok((countryService.getCountryById(id)));
    }

    @PostMapping
    public ResponseEntity<CountryDtoResponse> createCountry(@RequestBody CountryDtoRequest countryDtoRequest) {
        Country country = countryService.saveCountry(countryDtoRequest);
        return ResponseEntity.ok(countryService.getCountryById(country.getId()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id){
        return ResponseEntity.ok(( "Deleted"));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CountryDtoResponse> updatePresident(@PathVariable Long id, @RequestBody String president){
        CountryDtoResponse countryDtoResponse = countryService.updatePresident(id, president);
        return ResponseEntity.ok(countryDtoResponse);
    }
}
