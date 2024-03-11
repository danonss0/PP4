package pl.ldoniec.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void itAssignCredit(){
        //Arrange
        var card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000).equals(card.getBalance());
    }
    @Test
    void itAssignCredit2(){
        //Arrange
        var card = new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1500));
        //Assert
        assertEquals(BigDecimal.valueOf(1500),
                card.getBalance());

    }
    @Test
    void itDenyCreditBelowThreshold(){
        var card = new CreditCard();
        try{
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        } catch (CreditCardBelowThresholdException e){
            assertTrue(true);
        }
    }
    @Test
    void itDenyCreditBelowThresholdV2(){

        CreditCard card = new CreditCard();

        assertThrows(
                CreditCardBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10))
        );


    }
    @Test
    void itDenyCreditReassignment(){
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        assertThrows(
                CreditAlreadyAssignedException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1200))
        );
    }

    @Test
    void itAllowsToPayForSomething(){
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));

        card.pay(BigDecimal.valueOf(900));

        assertEquals(
                BigDecimal.valueOf(100),
                card.getBalance()
        );
    }

    @Test
    void itDenyWhenNotSufficientFounds(){
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        card.pay(BigDecimal.valueOf(900));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.pay(BigDecimal.valueOf(200))
        );
    }
}
