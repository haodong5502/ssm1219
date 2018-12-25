package com.newer.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;



@Controller
@RequestMapping("/img")
public class FileController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MultipartFile myPic, HttpSession session) throws IOException {
        String path=session.getServletContext().getRealPath("images");
        String fileName=myPic.getOriginalFilename();
        File file=new File(path,fileName);
        myPic.transferTo(file);
        session.setAttribute("fileName",fileName);
        return "index";
    }
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String fileName, HttpSession session) throws IOException {
        String path=session.getServletContext().getRealPath("images");
        File file=new File(path,fileName);
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",fileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.OK);
    }

}
