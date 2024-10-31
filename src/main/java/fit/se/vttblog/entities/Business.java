package fit.se.vttblog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Business extends User {
   @Column(name = "company_name")
   private String companyName;

   private String address;

   @Column(unique = true)
   private String phone;

   @Column(unique = true)
   private String website;
}