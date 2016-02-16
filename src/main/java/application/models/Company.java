
package application.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by himangshu on 15/2/16.
 */

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "company_seq_gen")
    @SequenceGenerator(name = "company_seq_gen", sequenceName = "company_id_seq")
    private Long companyId;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    private String email;

    private String phoneNumber;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="owners")
    private List<String> owners;
}
