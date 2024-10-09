package com.nsworld.serviceimpl;

import com.nsworld.entity.NewRegister;
import com.nsworld.repository.NewRegisterRepository;
import com.nsworld.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import java.io.File;
@Service
public class XmlServiceImpl implements XmlService {
    @Autowired
    NewRegisterRepository newRegisterRepository;
    @Override
    public String saveStudentsFromXml(NewRegister newRegister) {
        // Create JAXB context and unmarshaller
//            JAXBContext context = JAXBContext.newInstance(NewRegister.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//
//            // Read and unmarshal XML file to Java object
//            File xmlFile = new File(filePath);
//            NewRegister student = (NewRegister) unmarshaller.unmarshal(xmlFile);

        // Save the student data to the database
        newRegisterRepository.save(newRegister);

        return "Data Saved Successfually !!";
    }
}
