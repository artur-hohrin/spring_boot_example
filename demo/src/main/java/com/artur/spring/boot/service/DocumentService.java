package com.artur.spring.boot.service;

import com.artur.spring.boot.dto.request.DocumentCreateDto;
import com.artur.spring.boot.dto.response.DocumentResponseDto;
import com.artur.spring.boot.exception.DocumentAddException;
import com.artur.spring.boot.model.entity.Document;
import com.artur.spring.boot.model.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    public List<DocumentResponseDto> getDocuments() {
        return documentRepository.findAll().stream().map(DocumentResponseDto::createDocumentDto).collect(Collectors.toList());
    }

    public void addDocuments(DocumentCreateDto document) throws DocumentAddException {
        if(documentRepository.findBySeriesAndNumber(document.getSeries(), document.getNumber()) != null){
            throw new DocumentAddException("Такой документ уже существует");
        }
        Document modelDocument = Document.createModelDocument(document);
        documentRepository.save(modelDocument);
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
