package com.nsworld.controller;

import com.nsworld.entity.NewRegister;
import com.nsworld.service.NewRegisterService;
import com.nsworld.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
@RequestMapping("/xmlfile")
@RestController

public class ReadAndSaveDataXMLController {
    @Autowired
    XmlService xmlService;
    @PostMapping("/upload-xml")
    public String uploadXml(@RequestParam("file") MultipartFile file) throws IOException, JAXBException {
        InputStream inputStream = file.getInputStream();
        JAXBContext context = JAXBContext.newInstance(NewRegister.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        NewRegister student = (NewRegister) unmarshaller.unmarshal(inputStream);
        xmlService.saveStudentsFromXml(student);
        return "Students saved from XML!";
    }
}
