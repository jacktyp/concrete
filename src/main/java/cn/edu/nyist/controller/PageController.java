package cn.edu.nyist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/concrete/page")
public class PageController {


    @RequestMapping("/Functionalpage")
    public String Functionalpage(){
        return "Functionalpage";
    }

    @RequestMapping("/Contractadd")
    public String Contractadd(){
        return "Contractadd";
    }

    @RequestMapping("/Contractlist")
    public String Contractlist(){
        return "Contractlist";
    }

    @RequestMapping("/Noticeadd")
    public String Noticeadd(){
        return "Noticeadd";
    }

    @RequestMapping("/Noticelist")
    public String Noticelist(){
        return "Noticelist";
    }

    @RequestMapping("/Mixproportion")
    public String Mixproportion(){
        return "Mixproportion";
    }

    @RequestMapping("/Mixproportionlist")
    public String Mixproportionlist(){
        return "Mixproportionlist";
    }

    @RequestMapping("/Mixproportionadd")
    public String Mixproportionadd(){
        return "Mixproportionadd";
    }

    @RequestMapping("/Procurement")
    public String Procurement(){
        return "Procurement";
    }

    @RequestMapping("/Procurementadd")
    public String Procurementadd(){
        return "Procurementadd";
    }

    @RequestMapping("/Vehicle")
    public String Vehicle(){
        return "Vehicle";
    }

    @RequestMapping("/Vehicleadd")
    public String Vehicleadd(){
        return "Vehicleadd";
    }

    @RequestMapping("/Schedule")
    public String Schedule(){
        return "Schedule";
    }

    @RequestMapping("/Scheduleadd")
    public String Scheduleadd(){
        return "Scheduleadd";
    }

    @RequestMapping("/Shedulelist")
    public String Shedulelist(){
        return "Shedulelist";
    }

    @RequestMapping("/Actualpro")
    public String Actualpro(){
        return "Actualpro";
    }

    @RequestMapping("/Actualproadd")
    public String Actualproadd(){
        return "Actualproadd";
    }

    @RequestMapping("/Transportation")
    public String Transportation(){
        return "Transportation";
    }

    @RequestMapping("/Transportationadd")
    public String Transportationadd(){
        return "Transportationadd";
    }

    @RequestMapping("/First")
    public String First(){
        return "First";
    }

    @RequestMapping("/Actualschelist")
    public String Actualschelist(){
        return "Actualschelist";
    }

    @RequestMapping("/Finance1")
    public String Finance1(){
        return "Finance1";
    }

    @RequestMapping("/Finance2")
    public String Finance2(){
        return "Finance2";
    }
}
