package bankmanagmentsystem.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity   //annotations to make table at backend
@Table(name="customer")
public class Customer {
    //annotation for FK to declare foreign key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cusId;
    @Column
    private String cusName;
    @Column
    private String cusAddress;
    @Column
    private String cusPhoneNumber;
    @CreationTimestamp
    private LocalDateTime createdAt;
    //https://stackoverflow.com/questions/49954812/how-can-you-make-a-created-at-column-generate-the-creation-date-time-automatical
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    //default constructor is neccessary if creating more parametrised constructr else gives error
    public Customer() {
    }

    /* //not a good practice, use onl getters and setters to set and get values
    public Customer(Integer cus_id, String cus_name,String cus_phone_no) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_phone_no = cus_phone_no;
    }*/

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusPhoneNumber() {
        return cusPhoneNumber;
    }

    public void setCusPhoneNumber(String cusPhoneNumber) {
        this.cusPhoneNumber = cusPhoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusPhoneNumber='" + cusPhoneNumber + '\'' +
                '}';
    }
}
