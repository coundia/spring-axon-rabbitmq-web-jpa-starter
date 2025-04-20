package com.groupe2cs.bizyhub.security.application.service;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	return userRepository
					.findByUsername(username)
					.map(UserPrincipal::new)
					.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
	}
}
