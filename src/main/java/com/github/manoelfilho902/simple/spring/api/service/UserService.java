/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.manoelfilho902.simple.spring.api.service;

import com.github.manoelfilho902.simple.spring.api.model.entity.Profile;
import com.github.manoelfilho902.simple.spring.api.model.entity.User;
import com.github.manoelfilho902.simple.spring.api.model.entity.UserProfile;
import com.github.manoelfilho902.simple.spring.api.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import com.github.manoelfilho902.simple.spring.api.repository.ProfileRepository;
import java.util.ArrayList;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    protected UserRepository repository;
    @Autowired
    protected ProfileRepository profileRepository;
    private static final System.Logger LOG = System.getLogger(UserService.class.getName());

    
    /**
     *
     * @param user a valid user to save.
     */
    @Transactional()
    public void save(@Validated User user) {
        repository.save(user);
    }

    /**
     *
     * @param user
     * @return a optional user object
     */
    public Optional<User> get(User user) {
        return repository.findOne(Example.of(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findOne(Example.of(new User(username)));
        if (user.isPresent()) {
            var profiles = new ArrayList<Profile>();
            for (UserProfile object : user.get().getProfilesRef()) {
                Optional<Profile> findById = profileRepository.findById(object.getIdProfile());
                if(findById.isPresent()){
                    profiles.add(findById.get());
                    LOG.log(System.Logger.Level.WARNING, () -> "Profile ---->"+findById.get().getName());
                }
            }
            user.get().setProfiles(profiles);
            
            
            return user.get();
        }
        throw UsernameNotFoundException.fromUsername(username);
    }
}
