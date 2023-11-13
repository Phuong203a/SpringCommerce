//package com.tdtu.SpringCommerce.service;
//
//import com.tdtu.SpringCommerce.domain.User;
//import com.tdtu.SpringCommerce.repository.UserRepository;
//import com.tdtu.SpringCommerce.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    UserRepository userRepository;
//    PasswordEncoder passwordEncoder;
//    public UserServiceImpl( PasswordEncoder passwordEncoder){
//        this.passwordEncoder=  passwordEncoder;
//    }
//
//    @Override
//    public User findUserByName(String userName) {
//        User user = userRepository.findByUserName(userName);
//        return user;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        try {
//            User user1 = new User();
//            user1.setUserName("test");
//            user1.setPassword(passwordEncoder.encode("123123"));
//
//            List<String> authoritiesList = new ArrayList<>();
//            authoritiesList.add("ROLE_USER");
//            authoritiesList.add("ROLE_ADMIN");
//
//            User user = new User(1L,user1.getUserName(),user1.getPassword(),"email");
//            if(user==null){
//                System.out.println("null here");
//                throw new UsernameNotFoundException("User not found");
//            }
//            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                    authoritiesList.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }
//}
