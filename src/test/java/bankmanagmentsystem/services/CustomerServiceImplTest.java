package bankmanagmentsystem.services;

import bankmanagmentsystem.daos.CustomerDao;
import bankmanagmentsystem.enums.Gender;
import bankmanagmentsystem.exceptions.ResourceNotfoundException;
import bankmanagmentsystem.models.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import javax.swing.text.JTextComponent;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class) //differnece between these two?
class CustomerServiceImplTest {

    @Mock
    private CustomerDao customerDao;
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;
    private Customer testCustomer1;
    private Customer testCustomer2;
    private Customer testCustomer3;
    private List<Customer> customerslist;
    @BeforeEach
    public void populate(){
        customerslist=new ArrayList<>();
        testCustomer1=new Customer();
        testCustomer1.setId(1L);
        testCustomer1.setName("Rj");
        testCustomer1.setAddress("2/447, subhash nagar");
        testCustomer1.setPhoneNumber("9560366178");
        testCustomer1.setGender(Gender.FEMALE);
        testCustomer2=new Customer();
        testCustomer2.setId(2L);
        testCustomer2.setName("Mohan");
        testCustomer2.setAddress("2/447,kirti nagar");
        testCustomer2.setPhoneNumber("9560365578");
        testCustomer2.setGender(Gender.MALE);
        testCustomer3=null;
        customerslist.add(testCustomer1);
        customerslist.add(testCustomer2);

    }
    @AfterEach
    public void tearDown(){
        testCustomer1=testCustomer2=null;
        customerslist=null;
    }
    @Test
    void getAllCustomers() {
        Mockito.when(customerDao.readAll()).thenReturn(customerslist);
        List<Customer> expectedList=customerServiceImpl.getAllCustomers();
        Assertions.assertThat(expectedList).isEqualTo(customerslist);
    }

   /* @Rule
    public ExpectedException rule= ExpectedException.none(); //resource
    @Test
    void getCustomerifNull() throws ResourceNotfoundException {
        rule.expect(ResourceNotfoundException.class); //msg after insertion in db
       // rule.expectMess
        //rule.expectMessage(String.valueOf(equals(customerServiceImpl.getCustomerById(1L))));

    }*/
    //doubt below test??
    @Test
    public void saveCalledVerified() {
        CustomerServiceImpl customerService= mock(CustomerServiceImpl.class);
        doNothing().when(customerService).save(isA(Customer.class));
        customerService.save(testCustomer1);
        verify(customerService,times(1)).save(testCustomer1);
    }
    @Test
    public void updateCalledVerified() {
        CustomerServiceImpl customerService= mock(CustomerServiceImpl.class);
        doNothing().when(customerService).update(isA(Customer.class));
        customerService.update(testCustomer1);
        verify(customerService,times(1)).update(testCustomer1);
    }
    @Test
    public void deleteCalledVerified() {
        CustomerServiceImpl customerService= mock(CustomerServiceImpl.class);
        doNothing().when(customerService).deleteById(1L);
        customerService.deleteById(1L);
        verify(customerService,times(1)).deleteById(1L);
    }
    @Test
    public void checkCustomerIfNullById(){
        Mockito.when(customerDao.read(any())).thenReturn(null);
        assertThrows(ResourceNotfoundException.class,()->{
            customerServiceImpl.getCustomerById(4L);
        });
    }
    @Test
    public void checkCustomerIfNullByName(){
        Mockito.when(customerDao.findByName(any())).thenReturn(null);
        assertThrows(ResourceNotfoundException.class,()->{
            customerServiceImpl.getCustomerByName("Riya");
        });
    }
    /*@org.junit.Test(expected = ResourceNotfoundException.class)
    public void check(){
        customerServiceImpl.getCustomerById(1L);

    }*/

    @Test
    void getCustomerById() throws ResourceNotfoundException {
        Mockito.when(customerDao.read(any())).thenReturn(testCustomer1);
        Customer expected=customerServiceImpl.getCustomerById(1L);
        Assertions.assertThat(expected).isEqualTo(testCustomer1);

    }


    @Test
    void getCustomerByName() throws ResourceNotfoundException {
        Mockito.when(customerDao.findByName(any())).thenReturn(testCustomer2);
        Customer expected=customerServiceImpl.getCustomerByName("Mohan");
        Assertions.assertThat(expected).isEqualTo(testCustomer2);
    }
}