package com.artur.spring.boot.controller;

import com.artur.spring.boot.model.entity.Document;
import com.artur.spring.boot.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/all")
    public List<Document> getDocuments(){
       return documentService.getDocuments();
    }

    @PostMapping
    public void addDocument(@RequestBody Document document){
        documentService.addDocuments(document);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDocument(@PathVariable Long id){
        documentService.deleteDocument(id);
    }
}
