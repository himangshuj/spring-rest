package application.controller;

import application.models.Company;
import application.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by himangshu on 15/2/16.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/ping")
    public String ping(){
        return "pong";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Company addCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }

    @RequestMapping(value="/getAll")
    public List<Company> getCompanies(){
        return companyService.getAllCompanies();
    }

    @RequestMapping(value = "/details/{id}")
    public Company getDetails(@PathVariable("id") Long id){
        return companyService.getCompany(id);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public Integer updateCompany(@RequestBody Company company,@PathVariable("id") Long id){
        return companyService.updateCompany(id,company);
    }

    @RequestMapping(value = "/{id}/addOwner")
    public Integer addOwner(@PathVariable("id") Long companyId, @RequestParam("owner") String owner){
        return companyService.insertOwner(companyId,owner);
    }



}
