package hellospringboot.demo.controller;

import hellospringboot.demo.entity.Billrecord;
import hellospringboot.demo.service.BillService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class BillController {

    @Resource
    private BillService service;

    @RequestMapping("/bill/index")
    private String index(Model model,HttpServletRequest httpServletRequest){
        List<Billrecord> result = service.GetBillList(GetCheckParam(httpServletRequest));
        for (Billrecord item :result) {
            item.setUserid("");
        }
        model.addAttribute("result",result);
        return "bill/index";
    }

    @RequestMapping("/bill/add")
    private String add(Model model) {
        model.addAttribute("bill", new Billrecord());
        return "bill/add";
    }

    @PostMapping("/bill/add")
    private String addsubmit(@ModelAttribute Billrecord bill,HttpServletRequest httpServletRequest) {
        try {
            bill.setUserid(Long.toString(System.currentTimeMillis()));
            bill.setCreatetime(new Date());
            bill.setUserid(GetUserid(httpServletRequest));
            bill.setSn(Long.toString(System.currentTimeMillis()));
            boolean result = service.AddBillRecord(bill);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/bill/index";
    }

    @RequestMapping("/bill/loginfo")
    private String loginfo()
    {
        return "bill/loginfo";
    }

    @RequestMapping("/bill/getPrevMonth")
    private String getPrevMonth(Date month,Model model,HttpServletRequest httpServletRequest)
    {
        List<Billrecord> result = service.GetBillList(GetCheckParam(httpServletRequest));
        model.addAttribute("result",result);
        return "bill/_billList";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    private String GetUserid(HttpServletRequest httpServletRequest)
    {
        String userID = "";
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")){
                    userID =cookie.getValue();
                }
            }
        }
        return userID;
    }

    private Billrecord GetCheckParam(HttpServletRequest httpServletRequest) {
        Billrecord model = new Billrecord();
        model.setUserid(GetUserid(httpServletRequest));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            model.setStartTime(formatter.parse("2019-08-01"));
            model.setEndTime(formatter.parse("2019-09-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return model;
    }
}
