package ro.sda.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.sda.entity.UserAccount;
import ro.sda.repository.UserAccountRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    public CustomUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> userOptional = userAccountRepository.findByAccountName(username);
        if (userOptional.isPresent()) {
            UserAccount userAccount = userOptional.get();
            return new UserDetailsImpl(userAccount);
        } else {
            throw new UsernameNotFoundException("Invalid account name");
        }
    }
}
