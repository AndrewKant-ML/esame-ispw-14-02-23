import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccountService {

    @Test
    void testLoginAfterRegistration() {
        String username = "Andrew";
        String email = "ac@gmail.com";
        String password = "aaa";
        Integer age = 21;

        AccountService accountService = new AccountService();

        Account account = accountService.register(username, email, password, age);
        assertNotNull(account);
        assertEquals(username, account.getUsername());
        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
        assertEquals(age, account.getAge());

        Account logged = accountService.login(email, password);
        assertNotNull(logged);
        assertEquals(username, logged.getUsername());
        assertEquals(email, logged.getEmail());
        assertEquals(password, logged.getPassword());
        assertEquals(age, logged.getAge());

        Account wrongPassword = accountService.login(email, "abc");
        assertNull(wrongPassword);
    }
}
