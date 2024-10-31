package fit.se.vttblog.entities;

import fit.se.vttblog.enums.PaymentStatus;
import fit.se.vttblog.enums.PaymentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
   @Id
   @Column(name = "id", nullable = false, length = 12)
   private String id;

   @Column(name = "transaction_id", nullable = false, length = 50)
   private String transactionId;

   @Column(name = "create_at")
   private Instant createAt;

   private String duration;

   @Enumerated(EnumType.ORDINAL)
   private PaymentStatus status;

   @Enumerated(EnumType.ORDINAL)
   private PaymentType type;

   private Double amount;

   @Column(name = "payment_method")
   private String method;

   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;

}