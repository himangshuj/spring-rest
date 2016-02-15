package application.repositories;

import application.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by himangshu on 15/2/16.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{
}
