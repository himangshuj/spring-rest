package application.service;

import application.models.Company;
import application.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by himangshu on 15/2/16.
 */

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.getCompany(id);
    }

    @Override
    public Integer updateCompany(Long companyId, Company company) {
        return companyRepository.updateCompany(companyId,company.getName(),company.getAddress(),company.getCity(),
                company.getCountry(),company.getEmail(),company.getPhoneNumber());
    }

    @Override
    public Integer insertOwner(Long companyId, String owner) {
        return companyRepository.addOwner(companyId,owner);
    }


}

