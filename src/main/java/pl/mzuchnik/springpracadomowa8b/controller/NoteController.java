package pl.mzuchnik.springpracadomowa8b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mzuchnik.springpracadomowa8b.entity.NoteEntity;
import pl.mzuchnik.springpracadomowa8b.repository.NoteRepo;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private NoteRepo noteRepo;

    @Autowired
    public NoteController(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    @GetMapping
    public String showAllNotes(Model model)
    {
        model.addAttribute("notes",noteRepo.findAll());
        return "notes";
    }


    @GetMapping("/add-note")
    public String showMainPage(Model model)
    {
        model.addAttribute("note",new NoteEntity());
        return "noteForm";
    }

    @PostMapping("/save-note")
    public String saveNote(@ModelAttribute("note") NoteEntity noteEntity)
    {
        if(noteEntity.getCreateDate() == null) {
            noteEntity.setCreateDate(LocalDate.now());
        }
        noteEntity.setModificationDate(LocalDate.now());
        noteRepo.save(noteEntity);
        return "redirect:/notes";
    }

    @GetMapping("/{id}")
    public String viewNote(@PathVariable("id") Long id, Model model)
    {
        Optional<NoteEntity> noteById = noteRepo.findById(id);
        model.addAttribute("note",noteRepo.findById(id).get());
        return "note";
    }

    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("note",noteRepo.findById(id).get());
        return "noteEdit";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id)
    {
        noteRepo.deleteById(id);
        return "redirect:/notes";
    }

    /*@EventListener(ApplicationReadyEvent.class)
    public void addSomeExampleNotes()
    {
        noteRepo.save(new NoteEntity("Harry Potter","Bardzo długa cześć", LocalDate.now(),LocalDate.now()));
        noteRepo.save(new NoteEntity("Smerfy","dgsfdhdfgjhsf", LocalDate.now(),LocalDate.now()));
        noteRepo.save(new NoteEntity("Władcy much","Bardzo długa cześć", LocalDate.now(),LocalDate.now()));
        noteRepo.save(new NoteEntity("Koń rafal","Bardzo długa cześć", LocalDate.now(),LocalDate.now()));
    }*/
}
