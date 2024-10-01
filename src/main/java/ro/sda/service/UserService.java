package ro.sda.service;

import org.springframework.stereotype.Service;
import ro.sda.entity.UserAccount;
import ro.sda.repository.UserAccountRepository;

@Service
public class UserService {

    private UserAccountRepository userAccountRepository;

    public UserService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public void createAccount(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }
}
