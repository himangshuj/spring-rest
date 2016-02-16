package application.repositories;

import application.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by himangshu on 15/2/16.
 */
public interface CompanyRepository extends JpaRepository<Company,Long>{

    /**
     * get specific company, it joins with owners
     * @param id the id of the company
     * @return the company object
     */
    @Query("SELECT c FROM Company c JOIN FETCH c.owners WHERE c.companyId= (:id)")
    Company getCompany(@Param("id") Long id);

    /**
     * updates the company entry in db
     * @param companyId the id of company, the query will be made on this key
     * @param name the new name of the company
     * @param address the new address
     * @param city the new city
     * @param country the new country name
     * @param email the new email
     * @param phoneNumber the new phone number
     * @return the number of rows updated
     */
    @Query("UPDATE Company c SET c.name=(:name),c.address = (:address),c.city=(:city),c.country=(:country)," +
            "c.email=(:email),c.phoneNumber=(:phoneNumber) where c.companyId=(:companyId)")
    @Modifying(clearAutomatically = true)
    int updateCompany(@Param("companyId") Long companyId,
                       @Param("name") String name,
                       @Param("address") String address,
                       @Param("city") String city,
                       @Param("country") String country,
                       @Param("email") String email,
                       @Param("phoneNumber") String phoneNumber);

    /**
     * Adds a new owner in an efficient way, if we do not use native queries entire join table is recreated
     * @param companyId the id of the company
     * @param owner the name of the owner
     * @return number of rows updated
     */
    @Query(value = "insert into owners(company,owners) values((:companyId),(:owner))",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    int addOwner(@Param("companyId") Long companyId,@Param("owner") String owner);

}
