package com.subhajit.Medicare.Controllers.UI;

import com.subhajit.Medicare.Services.MyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
@Autowired
private MyDataService myDataService;

    @RequestMapping("/home")
    public String Home(){
        return "home";
    }
//    @RequestMapping("/")
//    public String HomeMedicines(Model model){
//        Product[] medicines= myDataService.fetchDataFromJson();
//        for(int i=0;i<medicines.length;i++)
//        {
//            System.out.println(medicines[i]);
//        }
//        model.addAttribute("data", medicines);
//        return "medicinelist";}
}
