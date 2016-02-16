package application.service;

import application.models.Company;

import java.util.List;

/**
 * Defines methods used by api to do data manipulation
 */
public interface CompanyService {
    /**
     * fetches list of all companies from db
     * @param pageNo the pageNumber of results to be fetched
     * @return the list of companies in db
     */
    List<Company> getAllCompanies(Integer pageNo);

    /**
     * creates a new company in db
     * @param company the company java object
     * @return the company saved in db
     */
    Company saveCompany(Company company);


    /**
     * Fetches all the details of a company for the given companyId
     * @param id the primary key
     * @return the company in db
     */
    Company  getCompany(Long id);

    /**
     * Updates the company table with new columns this does not touch the owners
     * @param companyId the companyId of company to change
     * @param company
     * @return the number of rows updated
     */
    Integer updateCompany(Long companyId, Company company);

    /**
     * Adds an owner to the company. I am assuming that you cannot remove or edit an owner
     * @param companyId the id of the company
     * @param owner  the name of the beneficial owner
     * @return the number of rows added
     */
    Integer insertOwner(Long companyId,String owner);

    /**
     * queries the db to find out total number of companies
     * @return the number of companies in db
     */
    Long getCompaniesCount();

}
