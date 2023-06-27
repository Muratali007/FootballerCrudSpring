package main.Controller;

import jakarta.validation.Valid;
import main.Dao.FootballPersonDao;
import main.model.FootballPerson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

@Controller
@RequestMapping("/home/footballer")
public class FootballPersonController {
    private FootballPersonDao footballPersonDao;

    public FootballPersonController(FootballPersonDao footballPersonDao) {
        this.footballPersonDao = footballPersonDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("footballer", footballPersonDao.index());
        return "index.html";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid FootballPerson footballPerson, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        footballPersonDao.create(footballPerson);
        return "redirect:/home/footballer";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", footballPersonDao.show(id));
        return "show.html";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", footballPersonDao.show(id));
        return "edit.html";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") FootballPerson footballPerson) {
        return "new.html";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("person") @Valid FootballPerson footballPerson, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";
        footballPersonDao.update(id, footballPerson);
        return "redirect:/home/footballer";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        footballPersonDao.delete(id);
        return "redirect:/home/footballer";
    }
}
