package com.artur.spring.boot.controller;

import com.artur.spring.boot.dto.request.DocumentCreateDto;
import com.artur.spring.boot.dto.response.DocumentResponseDto;
import com.artur.spring.boot.exception.DocumentAddException;
import com.artur.spring.boot.service.DocumentService;
import com.artur.spring.boot.service.PeopleService;
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
    public List<DocumentResponseDto> getDocuments(){
       return documentService.getDocuments();
    }

    @PostMapping
    public void addDocument(@RequestBody DocumentCreateDto document) throws DocumentAddException {
        documentService.addDocuments(document);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDocument(@PathVariable Long id){
        documentService.deleteDocument(id);
    }
}
