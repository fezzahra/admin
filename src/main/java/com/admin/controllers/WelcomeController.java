package com.admin.controllers;


import com.admin.Repository.ActivityRepository;
import com.admin.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class WelcomeController {


    @Autowired
    public ActivityRepository activityRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        List<Activity> list=activityRepository.findFirst20ByOrderByIdDesc();
        Map<Date,String> nouvlist = new HashMap<Date,String>();
        for(Activity l : list) {
            int type = l.getTypeAction();
            switch (type) {
                case 1:
                    nouvlist.put(l.getDate(),"Admin ID: " + l.getId_acteur() + " a ajouté l'agence Num: " + l.getId_objet());
                    break;
                case 2:
                    nouvlist.put(l.getDate(),"Admin ID: " + l.getId_acteur() + " a modifié l'agence Num: " + l.getId_objet());
                    break;
                case 3:
                    nouvlist.put(l.getDate(),"Admin ID: " + l.getId_acteur() + " a supprimé l'agence Num: " + l.getId_objet());
                    break;
                case 4:
                    nouvlist.put(l.getDate(),"Admin ID: " + l.getId_acteur() + " a ajouté l'agent ID: " + l.getId_objet());
                    break;
                case 5:
                    nouvlist.put(l.getDate(),"Admin ID: " + l.getId_acteur() + " a modifié l'agent ID: " + l.getId_objet());
                    break;
                case 6:
                    nouvlist.put(l.getDate(),"Admin ID: " + l.getId_acteur() + " a supprimé l'agent ID: " + l.getId_objet());
                    break;
                case 7:
                    nouvlist.put(l.getDate(),"Agent ID: " + l.getId_acteur() + " a désactivé le compte Num: " + l.getId_objet());
                    break;
                case 8:
                    nouvlist.put(l.getDate(),"Agent ID: " + l.getId_acteur() + " a supprimé le client ID: " + l.getId_objet());
                    break;
            }
        }
        model.addAttribute("activities",nouvlist);
        return "home";
    }


    @Controller
    public class LogoutController {

        @RequestMapping(value="/logout",method = RequestMethod.GET)
        public String logout(HttpServletRequest request){
            HttpSession httpSession = request.getSession();
            ((HttpSession) httpSession).invalidate();
            return "redirect:/";
        }

    }




}
