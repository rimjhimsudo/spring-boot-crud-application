package bankmanagmentsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
@Getter
@Setter
@NoArgsConstructor
public class DebitCard {
    @Id
    @Column
    private Integer debitNum;
    @Column
    private Integer debitCvv;   //must be encypted
    @Column
    private String debitHolderName;   // only in years for now  i.e. 1,2,3,n
    @Column //fk
    private String debitAccountNumber;   //debit card associated to




}
