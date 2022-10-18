package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.model.Cho;
import rikkei.academy.service.IChoService;

@Controller
public class AppController {
    @Autowired
    private IChoService choService;

    @RequestMapping( "/" )
    public String abb(Model model) {
        model.addAttribute("listcho", choService.findAll());
        return "list";
    }

    @GetMapping( "/showform" )
    public String show(Model model) {
        Cho cho = new Cho();
        model.addAttribute("showform", cho);
        return "create";
    }

    @PostMapping( "/create" )
    public String cho(Cho cho) {
        int lastIndex = choService.findAll().size() - 1;
        int lastId = choService.findAll().get(lastIndex).getId();
        cho.setId(lastId + 1);
        choService.save(cho);
        return "redirect:/";
    }
    @GetMapping("/showedit")
    public String showEdit(@RequestParam int id ,Model model ){
        choService.findById(id);
        Cho cho = choService.findById(id);
        model.addAttribute("editcho", cho);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Cho cho){
        choService.save(cho);
        return "redirect:/";
    }
    @GetMapping("/showdelete")
    public String delete(@RequestParam int id , Model model){
        choService.findById(id);
        Cho cho = choService.findById(id);
        model.addAttribute("delete",cho);
        return "delete";
    }
    @PostMapping("/delete")
    public String actionDelete(Cho cho){
        choService.delete(cho.getId());
        return "redirect:/";
    }
}
