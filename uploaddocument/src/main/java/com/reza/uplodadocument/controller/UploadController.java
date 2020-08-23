package com.reza.uplodadocument.controller;

import com.reza.uplodadocument.entity.Document;
import com.reza.uplodadocument.repo.DocumentRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.print.Doc;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {

    @Autowired
    DocumentRepository documentRepository;

    @RequestMapping("/showUpload")
    public String uploadPage(Model model){
        List<Document> documents = documentRepository.findAll();
        model.addAttribute("documents", documents);
        return "uploadpage";
    }

    @RequestMapping(value = "/uploadDoc", method = RequestMethod.POST)
    public String uploadPage(@RequestParam("document")MultipartFile multipartFile,
                             @RequestParam("id") long id,
                             Model model){
        Document document = new Document();
        document.setId(id);
        document.setName(multipartFile.getOriginalFilename());
        try {
            document.setData(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        documentRepository.save(document);
        List<Document> documents = documentRepository.findAll();
        model.addAttribute("documents", documents);
        return "uploadpage";
    }

    @RequestMapping("/download")
    public StreamingResponseBody download(@RequestParam long id, HttpServletResponse response){
        Document document = documentRepository.getOne(id);
        byte[] data = document.getData();

        response.setHeader("Content-Disposition", "attchment;filename="+document.getName());
        return outputStream -> {
            outputStream.write(data);
        };
    }


}
