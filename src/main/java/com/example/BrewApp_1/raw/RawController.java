package com.example.BrewApp_1.raw;

import com.example.BrewApp_1.recipe.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class RawController {

    @Autowired
    private RawRepository rawRepository;

    @GetMapping({"/raws"})
    public String getRaws(Model model){
        List<Raw> raws = rawRepository.findAll();
        model.addAttribute("raws", raws);
        return "raw_list";
    }

    @GetMapping("/addRaw")
    public ModelAndView addRaw(){
        ModelAndView mav = new ModelAndView("raw_add");
        Raw newRaw = new Raw();
        mav.addObject("raw", newRaw);
        return mav;
    }

    @PostMapping({"/saveRaw"})
    public String saveRaw(@ModelAttribute Raw raw){
        rawRepository.save(raw);
        return "redirect:/raws";
    }

    @GetMapping("/raws/{rawId}")
    public String getSingleRaws(@PathVariable("rawId") Long rawId, Model model){
        Raw raw = rawRepository.findByRawId(rawId);
        model.addAttribute("raw", raw);
        return "raw_update";
    }

    @GetMapping({"/deleteRaw/{rawId}"})
    public String deleteRaw(@PathVariable("rawId") Long rawId){
        rawRepository.deleteById(rawId);
        return "redirect:/raws";
    }

}
