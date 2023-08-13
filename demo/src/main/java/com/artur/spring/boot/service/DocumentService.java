package com.artur.spring.boot.service;

import com.artur.spring.boot.model.entity.Document;
import com.artur.spring.boot.model.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    public void addDocuments(Document document){
        if(documentRepository.findBySeriesAndNumber(document.getSeries(), document.getNumber()) != null){
            System.out.println("Такой документ уже существует");
        }
        documentRepository.save(document);
        System.out.println("Документ успешно сохранен");
    }

    public void deleteDocument(Long id) {
        boolean exists = documentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Документа с таким " + id + " не существует");
        }
        documentRepository.deleteById(id);
    }
}
