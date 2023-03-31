package pl.agh.edu.restapihw.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.agh.edu.restapihw.analytics.Comparator;
import pl.agh.edu.restapihw.api.model.PlayerData;

@Controller
@Validated
@AllArgsConstructor
public class FormController{

     private Comparator comparator;

    @GetMapping("/playerForm")
    public String showForm(Model model) {
        PlayerData playerData = new PlayerData();
        model.addAttribute("playerData", playerData);
        return "form";
    }

    @PostMapping("/playerForm")
    public String submitForm(@ModelAttribute("playerData") @RequestBody @Validated PlayerData playerData, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "form";
        }
        else {
            String result = comparator.comparePlayerSeasons(playerData.getFirstName(), playerData.getLastName(), playerData.getSeason1(), playerData.getSeason2());
            playerData.setResult(result);
            return "success";
        }
    }

}