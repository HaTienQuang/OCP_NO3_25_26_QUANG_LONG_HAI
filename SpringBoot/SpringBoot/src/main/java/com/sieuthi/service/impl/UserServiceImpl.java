package com.sieuthi.service.impl;
import com.sieuthi.model.User;
import com.sieuthi.repository.UserRepository;
import com.sieuthi.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    public UserServiceImpl(UserRepository repo){this.repo=repo;}
    public List<User> findAll(){return repo.findAll();}
    public User findById(Long id){return repo.findById(id).orElse(null);}
    public User save(User u){return repo.save(u);}
    public void delete(Long id){repo.deleteById(id);}
}
