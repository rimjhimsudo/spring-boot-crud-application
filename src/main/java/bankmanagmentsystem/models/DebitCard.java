package bankmanagmentsystem.models;

import bankmanagmentsystem.encryption.StringAttributeConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="debitcard")
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class DebitCard {
    @Id
    private String number;
    @Column
    @Convert(converter = StringAttributeConverter.class)
    private String cvv;   //must be encypted
    @Column
    private String holderName;
    /*@Column //fk
    private String debitAccountNumber;*/   //debit card associated to
    @CreationTimestamp
    public LocalDateTime createdAt;

    @UpdateTimestamp
    public LocalDateTime updatedAt;
}
