package bankmanagmentsystem.services;

import bankmanagmentsystem.daos.AccountDao;
import bankmanagmentsystem.models.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class AccountServiceImplTest {

    @Mock
    private AccountDao accountDao;
    @InjectMocks
    private AccountServiceImpl accountServiceImpl;
    private Account testacc1;
    private Account testacc2;
    private List<Account> accountslist;
    @BeforeEach
    void setUp() {
        accountslist=new ArrayList<>();
        testacc1=new Account();
        testacc2=new Account();
        testacc1.setHolderName("Rj");
        testacc1.setBalance(1000);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllAccounts() {
    }

    @Test
    void getByAccNumber() {
    }

    @Test
    void update() {
    }

    @Test
    void debit() {
    }

    @Test
    void credit() {
    }
}