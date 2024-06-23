package com.youtube.jwt.service;

import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.dao.AdminDao;
import com.youtube.jwt.dao.ClientDao;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Admin;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.JwtRequest;
import com.youtube.jwt.entity.JwtResponse;
import com.youtube.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ClientDao clientDao;
    
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String email = jwtRequest.getEmail();
        String password = jwtRequest.getPassword();

        authenticate(email, password);

        UserDetails userDetails = loadUserByUsername(email);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        Object user = employeeDao.findByEmail(email) != null ? employeeDao.findByEmail(email) : clientDao.findByEmail(email);
        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employee> employeeOptional = Optional.ofNullable(employeeDao.findByEmail(email));
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return new org.springframework.security.core.userdetails.User(
                    employee.getEmail(),
                    employee.getPassword(),
                    getAuthority(employee.getRole())
            );
        }

        Optional<Client> clientOptional = Optional.ofNullable(clientDao.findByEmail(email));
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return new org.springframework.security.core.userdetails.User(
                    client.getEmail(),
                    client.getPassword(),
                    getAuthority(client.getRole())
            );
        }
        
        Optional<Admin> adminOptional = Optional.ofNullable(adminDao.findByEmail(email));
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            return new org.springframework.security.core.userdetails.User(
                    admin.getEmail(),
                    admin.getPassword(),
                    getAuthority(admin.getRole())
            );
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }

    private Set<SimpleGrantedAuthority> getAuthority(String role) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
