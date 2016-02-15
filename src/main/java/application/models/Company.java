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
    @GeneratedValue
    private Long companyId;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String Country;

    private String email;

    private String phoneNumber;

    @ElementCollection
    @CollectionTable(name="owners")
    private List<String> owners;
}
