package bankmanagmentsystem.services;

import bankmanagmentsystem.daos.AccountDao;
import bankmanagmentsystem.daos.CustomerDao;
import bankmanagmentsystem.enums.Gender;
import bankmanagmentsystem.models.Account;
import bankmanagmentsystem.models.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)

class AccountServiceImplTest {

    @Mock
    private AccountDao accountDao;
    @Mock
    private CustomerDao customerDao;
    @InjectMocks
    private AccountServiceImpl accountServiceImpl;
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;
    private Customer testCustomer1;
    private Customer testCustomer2;
    private Account testacc1;
    private Account testacc2;
    private List<Account> accountslist;
    @BeforeEach
    void setUp() {
        testCustomer1=new Customer();
        testCustomer1.setId(1L);
        testCustomer1.setName("Rj");
        testCustomer1.setAddress("2/447, subhash nagar");
        testCustomer1.setPhoneNumber("9560366178");
        testCustomer1.setGender(Gender.FEMALE);

        testacc1=new Account();
        testacc1.setHolderName("Rj");
        testacc1.setBalance(1000);
        testacc1.setBranch(null);
        testacc1.setNumber("1001");
        testacc1.setCustomer(testCustomer1);

        testCustomer2=new Customer();
        testCustomer2.setId(2L);
        testCustomer2.setName("Riya");
        testCustomer2.setAddress("2/447, kirti nagar");
        testCustomer2.setPhoneNumber("9566366178");
        testCustomer2.setGender(Gender.FEMALE);

        testacc2=new Account();
        testacc2.setHolderName("Riya");
        testacc2.setBalance(100);
        testacc2.setBranch(null);
        testacc2.setNumber("1002");
        testacc2.setCustomer(testCustomer2);
        accountslist=new ArrayList<>();
        accountslist.add(testacc1);
        accountslist.add(testacc2);
    }

    @AfterEach
    void tearDown() {
        testacc1=testacc2=null;
        testCustomer1=testCustomer2=null;
        accountslist=null;
    }

    @Test
    void getAllAccounts() {
        Mockito.when(accountDao.readAll()).thenReturn(accountslist);
        List<Account> expectedList=accountServiceImpl.getAllAccounts();
        Assertions.assertThat(expectedList).isEqualTo(accountslist);
    }
    /*
    //other way of testing this method
    @Test
    void getAllAccounts() {
        //Mockito.when(accountDao.readAll()).thenReturn(accountslist);
        AccountDao accountDaomock=mock(AccountDao.class);
        CustomerDao customerDaomock=mock(CustomerDao.class);
        when(accountDaomock.readAll()).thenReturn(accountslist);
        //AccountService accountServicemock=mock(AccountService.class);
        AccountServiceImpl accountService=new AccountServiceImpl(accountDaomock,customerDaomock);
        List<Account> expectedList=accountService.getAllAccounts();
        //List<Account> expectedList=accountServiceImpl.getAllAccounts();
        Assertions.assertThat(expectedList).isEqualTo(accountslist);
    }
     */

    @Test
    void getByAccNumber() {
        Mockito.when(accountDao.read(any())).thenReturn(testacc1);
        Account expected=accountServiceImpl.getByAccNumber("1001");
        Assertions.assertThat(expected).isEqualTo(testacc1);
    }
    @Test
    void saveAccount(){
        Mockito.when(customerDao.read(any())).thenReturn(testCustomer1);
        Mockito.when(accountDao.create(any())).thenReturn(testacc1.getNumber());
        //Mockito.when(accountDao.create(any())).thenReturn(String.valueOf(testacc1));
        String expected=accountServiceImpl.saveAccount(testacc1,1L);
        Assertions.assertThat(expected).isEqualTo(testacc1.getNumber());
        //
        Mockito.when(customerDao.read(any())).thenReturn(null);
        Assertions.assertThat(accountServiceImpl.saveAccount(testacc1,9L)).isEqualTo("customer does not exist");
    }

    /*@Test
    void update() {

    }*/

    @Test
    void debitIfPart() {
        Mockito.when(accountDao.read(any())).thenReturn(testacc2);
        String answer="Your balance is : "+ (testacc2.getBalance()-12);
        String expected=accountServiceImpl.debit("1002",12);
        Assertions.assertThat(expected).isEqualTo(answer);
    }
    @Test
    void debitElsePart() {
        Mockito.when(accountDao.read(any())).thenReturn(testacc2);
        String answer="You dont have sufficient balance to withdraw";
        String expected=accountServiceImpl.debit("1002",12000);
        Assertions.assertThat(expected).isEqualTo(answer);
    }

    @Test
    void credit() {
        //this any() is argument matcher and it means irrespective of the argument we want it to return whtever is given in thenReturn(...).
        Mockito.when(accountDao.read(any())).thenReturn(testacc1);
        String answer="Your balance is : "+ (testacc1.getBalance()+12);
        String expected=accountServiceImpl.credit("1001",12);
        Assertions.assertThat(expected).isEqualTo(answer);

    }
    @Test
    public void deleteCalledVerified() {
        AccountServiceImpl accountService= mock(AccountServiceImpl.class);
        doNothing().when(accountService).deleteByByAccNumber(testacc1.getNumber());
        accountService.deleteByByAccNumber(testacc1.getNumber());
        verify(accountService,times(1)).deleteByByAccNumber(testacc1.getNumber());
    }
    @Test
    public void updateCalledVerified() {
        AccountServiceImpl accountService= mock(AccountServiceImpl.class);
        doNothing().when(accountService).update(testacc1);
        accountService.update(testacc1);
        verify(accountService,times(1)).update(testacc1);
    }
    //practice tests-in28minutes channel
    @Test
    public void mockListSize_ReturnMultipleValues(){
        List listmck=mock(List.class);
        when(listmck.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listmck.size());
        assertEquals(3,listmck.size());

        //acccessing list elements
        when(listmck.get(0)).thenReturn("Hello");
        assertEquals("Hello",listmck.get(0));
        assertEquals(null,listmck.get(1));

    }
    //junit4
    @org.junit.Test(expected=RuntimeException.class)
    public void mockListSize_ThrowException() {
        List listmck = mock(List.class);
        when(listmck.get(anyInt())).thenThrow(new RuntimeException("dummy msg-went wrong"));
        listmck.get(0);

    }




}