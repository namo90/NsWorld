package com.nsworld.serviceimpl;

import com.nsworld.entity.NewRegister;
import com.nsworld.globalexception.UserNotFoundException;
import com.nsworld.repository.NewRegisterRepository;
import com.nsworld.service.NewRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewRegisterServiceImpl implements NewRegisterService {
    @Autowired
    NewRegisterRepository newRegisterRepository;
    @Override
    public NewRegister registerStudent(NewRegister newRegister) {
        return newRegisterRepository.save(newRegister);
    }

    @Override
    public List<NewRegister> getAllStudentDetails() {
        return newRegisterRepository.findAll();
    }

    @Override
    public List<NewRegister> serachUser(String userName) {
        List<NewRegister> byName = newRegisterRepository.findByName(userName);
        if(byName.isEmpty()){
            throw new UserNotFoundException("No users found with the name: " + userName);
        }
        return byName;
    }
}
