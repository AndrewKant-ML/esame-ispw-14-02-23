import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private final List<Account> registeredAccounts;

    public AccountService() {
        this.registeredAccounts = new ArrayList<>();
    }

    public Account register(String username, String email, String password, Integer age) {
        // Edge case: no check on null values
        Account account = new Account(username, email, password, age);
        registeredAccounts.add(account);
        System.out.printf("Welcome %s!%n", account.getUsername());
        return account;
    }

    public Account login(String email, String password) {
        for (Account account : registeredAccounts)
            // Next line fails if user registered a null email or password, throwing NullPointerException
            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                System.out.printf("Welcome back %s!%n", account.getUsername());
                return account;
            }
        return null;
    }
}
