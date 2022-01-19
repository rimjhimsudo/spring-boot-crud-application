package bankmanagmentsystem.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class DebitCard {
    @Id
    @Column
    private int debit_num;
    @Column
    private int debit_cvv;   //must be encypted
    @Column
    private int debit_holder_name;   // only in years for now  i.e. 1,2,3,n
    @Column //fk
    private int debit_acct_num;   //debit card associated to

    public DebitCard(int debit_num, int debit_cvv, int debit_holder_name, int debit_acct_num) {
        this.debit_num = debit_num;
        this.debit_cvv = debit_cvv;
        this.debit_holder_name = debit_holder_name;
        this.debit_acct_num = debit_acct_num;
    }

    public int getDebit_num() {
        return debit_num;
    }

    public void setDebit_num(int debit_num) {
        this.debit_num = debit_num;
    }

    public int getDebit_cvv() {
        return debit_cvv;
    }

    public void setDebit_cvv(int debit_cvv) {
        this.debit_cvv = debit_cvv;
    }

    public int getDebit_holder_name() {
        return debit_holder_name;
    }

    public void setDebit_holder_name(int debit_holder_name) {
        this.debit_holder_name = debit_holder_name;
    }

    public int getDebit_acct_num() {
        return debit_acct_num;
    }

    public void setDebit_acct_num(int debit_acct_num) {
        this.debit_acct_num = debit_acct_num;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "debit_num=" + debit_num +
                ", debit_cvv=" + debit_cvv +
                ", debit_holder_name=" + debit_holder_name +
                ", debit_acct_num=" + debit_acct_num +
                '}';
    }
}
