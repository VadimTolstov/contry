//package ru.tolstov.contry.controller.qraphql;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import ru.tolstov.contry.domain.Country;
//import ru.tolstov.contry.domain.qraphql.CountryGql;
//import ru.tolstov.contry.domain.qraphql.CountryInputGql;
//import ru.tolstov.contry.service.CountryGqlService;
//import ru.tolstov.contry.service.CountryService;
//
//import java.util.List;
//
//@Controller
//public class CountryMutationController {
//
//    private final CountryGqlService countryGqlService;
//
//    @Autowired
//    public CountryMutationController(CountryGqlService countryGqlService) {
//        this.countryGqlService = countryGqlService;
//    }
//
//    @MutationMapping()
//    @ResponseStatus(HttpStatus.CREATED)
//    public CountryGql addCountry(@Argument CountryInputGql input) {
//        return countryGqlService.addCountry(country);
//    }
//
//    @MutationMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public Country update(@Argument String countryCode, @Argument String countryName) {
//        return countryGqlService.updateCountryName(inputGql);
//    }
//}
