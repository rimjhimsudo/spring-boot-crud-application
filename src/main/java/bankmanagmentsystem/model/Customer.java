package bankmanagmentsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column
    private int cus_id;
    @Column
    private String cus_name;
    @Column
    private String cus_address;
    @Column
    private long cus_phone_no;
    //default constructor is necesar when creatiing more parametrised constructr else gives error
    public Customer() {
    }

    public Customer(int cus_id, String cus_name, long cus_phone_no) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_phone_no = cus_phone_no;
    }

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_address() {
        return cus_address;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public long getCus_phone_no() {
        return cus_phone_no;
    }

    public void setCus_phone_no(long cus_phone_no) {
        this.cus_phone_no = cus_phone_no;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", cus_name='" + cus_name + '\'' +
                ", cus_address='" + cus_address + '\'' +
                ", cus_phone_no=" + cus_phone_no +
                '}';
    }
}
