package bankmanagmentsystem.services;
//https://www.youtube.com/watch?v=_PQd6aZ-ANk
import bankmanagmentsystem.daos.DebitCardDao;
import bankmanagmentsystem.exceptions.ResourceNotfoundException;
import bankmanagmentsystem.models.Customer;
import bankmanagmentsystem.models.DebitCard;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class DebitCardServiceImplTest {
    @Mock
    private DebitCardDao debitCardDao;
    @InjectMocks
    private DebitCardServiceImpl debitCardServiceImpl;
    private DebitCard db1;
    private DebitCard db2;
    private List<DebitCard> debitCardList;
    @BeforeEach
    void setUp() {
        //initilaising
        debitCardList=new ArrayList<>();
        db1=new DebitCard();
        db2=new DebitCard();
        //setting properties
        db1.setNumber("12345");
        db1.setHolderName("Riya");
        db1.setCvv("121");
        //adding debitcards to lists
        debitCardList.add(db1);
    }

    @AfterEach
    void tearDown() {
        db1=null;
        debitCardList=null;
    }

    @Test
    void getAll() {
        Mockito.when(debitCardDao.readAll()).thenReturn(debitCardList);
        List<DebitCard> expectedList=debitCardServiceImpl.getAll();
        Assertions.assertThat(expectedList).isEqualTo(debitCardList);
    }

    @Test
    void getByNumber() throws ResourceNotfoundException {
        Mockito.when(debitCardDao.read(any())).thenReturn(db1);
        DebitCard expected=debitCardServiceImpl.getByNumber("12345");;
        Assertions.assertThat(expected).isEqualTo(db1);
    }

    @Test
    void save() {
        Mockito.when(debitCardDao.create(any())).thenReturn(db1);
        DebitCard expected=debitCardServiceImpl.save(db1);
        //Assertions.assertThat(expected).isEqualTo(db1);
        assertEquals(expected,db1);
    }
    @Test
    public void updateCalledVerified() {
        DebitCardServiceImpl debitCardService=mock(DebitCardServiceImpl.class);
        doNothing().when(debitCardService).update(isA(DebitCard.class));
        debitCardService.update(db1);
        verify(debitCardService,times(1)).update(db1);

    }
    @Test
    public void deletebyNumberCalledVerified() {
        DebitCardServiceImpl debitCardService=mock(DebitCardServiceImpl.class);
        doNothing().when(debitCardService).deleteByNumber(db1.getNumber());
        debitCardService.deleteByNumber(db1.getNumber());
        verify(debitCardService,times(1)).deleteByNumber(db1.getNumber());

    }
    @Test
    public void checkDebitCardIfNullByNumber(){
        Mockito.when(debitCardDao.read(any())).thenReturn(null);
        assertThrows(ResourceNotfoundException.class,()->{
            debitCardServiceImpl.getByNumber("5989");
        });
    }
}