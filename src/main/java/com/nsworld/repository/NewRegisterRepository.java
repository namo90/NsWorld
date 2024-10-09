package com.nsworld.repository;

import com.nsworld.entity.NewRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewRegisterRepository extends JpaRepository<NewRegister, Long> {

    public List<NewRegister> findByName(String userName);
}
