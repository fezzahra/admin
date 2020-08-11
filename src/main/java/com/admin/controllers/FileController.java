package com.admin.controllers;


import com.admin.Repository.ActivityRepository;
import com.admin.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class FileController {


@Autowired
ActivityRepository activityRepository;

    @RequestMapping(value = "/downloadhistorique", method = RequestMethod.GET)
    public void write(HttpServletRequest request, HttpServletResponse servletResponse) throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
       // List<Activity> list=activityRepository.findAllByTypeAction(1);
         List<Activity> list=activityRepository.findAll();
        BufferedWriter writer = new BufferedWriter(new FileWriter("historique.txt"));
        for(Activity l : list){
            String strDate = dateFormat.format(l.getDate());
           // String act=l.getAction();
           // writer.write(strDate+ "    "+act);
            int type = l.getTypeAction();
            switch (type) {
                case 1:
                    writer.write(strDate+"\t \t"+"Admin ID: " + l.getId_acteur() + " a ajouté l'agence Num: " + l.getId_objet());
                    break;
                case 2:
                    writer.write(strDate+"\t \t"+"Admin ID: " + l.getId_acteur() + " a modifié l'agence Num: " + l.getId_objet());
                    break;
                case 3:
                    writer.write(strDate+"\t \t"+"Admin ID: " + l.getId_acteur() + " a supprimé l'agence Num: " + l.getId_objet());
                    break;
                case 4:
                    writer.write(strDate+"\t \t"+"Admin ID: " + l.getId_acteur() + " a ajouté l'agent ID: " + l.getId_objet());
                    break;
                case 5:
                    writer.write(strDate+"\t \t"+"Admin ID: " + l.getId_acteur() + " a modifié l'agent ID: " + l.getId_objet());
                    break;
                case 6:
                    writer.write(strDate+"\t \t"+"Admin ID: " + l.getId_acteur() + " a supprimé l'agent ID: " + l.getId_objet());
                    break;
                case 7:
                    writer.write(strDate+"\t \t"+"Agent ID: " + l.getId_acteur() + " a désactivé le compte Num: " + l.getId_objet());
                    break;
                case 8:
                    writer.write(strDate+"\t \t"+"Agent ID: " + l.getId_acteur() + " a supprimé le client ID: " + l.getId_objet());
                    break;
            }
            writer.write("\r\n\n");
        }
        writer.close();

        File file = new File("historique.txt");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"" + file.getName() + "\"");
        servletResponse.setHeader(headerKey, headerValue);
        servletResponse.setContentLength((int) file.length());
        servletResponse.setContentType("text/plain");

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        OutputStream outputStream= servletResponse.getOutputStream();
        FileCopyUtils.copy(inputStream, outputStream);
        servletResponse.flushBuffer();
        outputStream.close();

    }


}
