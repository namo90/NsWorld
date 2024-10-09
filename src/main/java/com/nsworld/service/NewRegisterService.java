package com.nsworld.service;

import com.nsworld.entity.NewRegister;

import java.util.List;

public interface NewRegisterService {
    public NewRegister registerStudent(NewRegister newRegister);
    public List<NewRegister> getAllStudentDetails();
    public List<NewRegister> serachUser(String userName);
}
