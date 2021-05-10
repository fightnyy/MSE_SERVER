package mse.exam.tutorial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

import lombok.*;
import mse.exam.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

   @JsonIgnore
   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long userId;

   @Column(name = "username", length = 50, unique = true)
   private String username;

   @JsonIgnore
   @Column(name = "password", length = 100)
   private String password;

   @Column(name = "nickname", length = 50)
   private String nickname;

   @JsonIgnore
   @Column(name = "activated")
   private boolean activated;

   @Embedded
   private Chito chito;

   @ManyToMany
   @JoinTable(
      name = "user_authority",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
   private Set<Authority> authorities;


   @PrePersist
   public void createChito() {
      Iterator<Authority> iterator = authorities.iterator();
      Authority next = iterator.next();
      if (next.getAuthorityName().equals("ROLE_USER")) {
         chito = Chito.builder()
                 .timePoint(10)
                 .grade(0.0)
                 .intelligence(50)
                 .health(50)
                 .speech(50)
                 .build();
      }
      else {
         List<Authority> auth = new ArrayList<>();
         Authority au = new Authority();
         au.setAuthorityName("ROLE_USER");
         auth.add(au);
         Authority au1 = new Authority();
         au1.setAuthorityName("ROLE_ADMIN");
         auth.add(au1);
         authorities = new HashSet<>(auth);
         System.out.println("authorities = " + authorities);
         Iterator<Authority> iterator1 = authorities.iterator();
         while(iterator1.hasNext())
         {
            System.out.println(iterator1.next().getAuthorityName());
         }
      }
   }
}
