package application.service;


import application.TestContext;
import application.models.Company;
import application.repositories.CompanyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by himangshu on 15/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(classes = TestContext.class)
@ActiveProfiles("dev")
public class CompanyServiceImplTest {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;

    private List<Long> companyIdList = new ArrayList<>();


    private Company createCompany(Integer suffix){
        final Company company = new Company();
        company.setAddress("ADDRESS"+suffix);
        company.setCity("City"+suffix);
        company.setName("NAME"+suffix);
        company.setCountry("COUNTRY"+suffix);
        company.setEmail("EMAIL"+suffix);
        company.setPhoneNumber("PHONENUMBER"+suffix);
        company.setOwners(Arrays.asList("OWNER" + suffix));
        return  company;
    }

    @Before
    public void setData(){
        for(int i =0 ;i <15;i++){
           companyIdList.add(companyService.saveCompany(createCompany(i)).getCompanyId());
        }
    }



    @Test
    public void testGetAllCompanies() throws Exception {
        final List<Company> companyProjectionList = companyService.getAllCompanies(0);
        assertEquals(companyProjectionList.size(),10);
        assertEquals(companyService.getAllCompanies(1).size(),5);

    }

    @Test
    public void getCompanyTest() {
        assertEquals(companyService.getCompany(companyIdList.get(0)).getCompanyId(),new Long(companyIdList.get(0)));
    }

    @Test
    public void updateTest(){
        final Company companyToChange = companyService.getCompany(companyIdList.get(5));
        assertNotEquals(companyToChange.getName(),"changedName");
        companyToChange.setName("changedName");
        assertEquals(companyService.updateCompany(companyToChange.getCompanyId(),companyToChange),new Integer(1));
        companyService.updateCompany(companyToChange.getCompanyId(),companyToChange);
        companyRepository.flush();
        assertEquals( companyService.getCompany(companyIdList.get(5)).getName(),"changedName");
    }

    @Test
    public void addOwner(){
        final Company companyToChange = companyService.getCompany(companyIdList.get(5));
        assertEquals(companyToChange.getOwners().size(),1);
        assertNotEquals(companyToChange.getOwners().size(),2);
        companyService.insertOwner(companyToChange.getCompanyId(),"NEW OWNER");
        companyRepository.flush();
        final Company changedCompany = companyService.getCompany(companyIdList.get(5));
        assertEquals(changedCompany.getOwners().size(),2);


    }
}