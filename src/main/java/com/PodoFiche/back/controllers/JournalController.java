package com.podofiche.back.controllers;

import com.podofiche.back.bo.Journal;
import com.podofiche.back.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/journaux")
public class JournalController {

    private final JournalRepository journalRepository;

    @Autowired
    public JournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @GetMapping
    public List<Journal> getAllJournaux() {
        return journalRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journal> getJournalById(@PathVariable Long id) {
        return journalRepository.findById(id)
                .map(journal -> ResponseEntity.ok().body(journal))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Journal createJournal(@RequestBody Journal journal) {
        return journalRepository.save(journal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Journal> updateJournal(@PathVariable Long id, @RequestBody Journal journalDetails) {
        return journalRepository.findById(id)
                .map(journal -> {
                    journal.setDateJournal(journalDetails.getDateJournal());
                    journal.setLibelleJournal(journalDetails.getLibelleJournal());
                    Journal updatedJournal = journalRepository.save(journal);
                    return ResponseEntity.ok().body(updatedJournal);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJournal(@PathVariable Long id) {
        return journalRepository.findById(id)
                .map(journal -> {
                    journalRepository.delete(journal);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
