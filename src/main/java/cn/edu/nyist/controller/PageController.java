package cn.edu.nyist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/concrete/page")
public class PageController {

    //功能界面一具有全部功能
    @RequestMapping("/Functionalpage")
    public String Functionalpage(){
        return "Functionalpage";
    }
    //功能界面二合同统计功能
    @RequestMapping("/Functionalpage1")
    public String Functionalpage1(){
        return "Functionalpage1";
    }
    //功能界面二生产管理功能
    @RequestMapping("/Functionalpage2")
    public String Functionalpage2(){
        return "Functionalpage2";
    }
    //功能界面二实验
    @RequestMapping("/Functionalpage3")
    public String Functionalpage3(){
        return "Functionalpage3";
    }
    //功能界面二管理
    @RequestMapping("/Functionalpage4")
    public String Functionalpage4(){
        return "Functionalpage4";
    }
    //添加合同页面
    @RequestMapping("/Contractadd")
    public String Contractadd(){
        return "Contractadd";
    }
    //合同列表
    @RequestMapping("/Contractlist")
    public String Contractlist(){
        return "Contractlist";
    }
    //通知单的添加
    @RequestMapping("/Noticeadd")
    public String Noticeadd(){
        return "Noticeadd";
    }
    //通知单列表
    @RequestMapping("/Noticelist")
    public String Noticelist(){
        return "Noticelist";
    }
    //实验列表
    @RequestMapping("/Mixproportion")
    public String Mixproportion(){
        return "Mixproportion";
    }
    //配合比列表
    @RequestMapping("/Mixproportionlist")
    public String Mixproportionlist(){
        return "Mixproportionlist";
    }
    //实验添加
    @RequestMapping("/Mixproportionadd")
    public String Mixproportionadd(){
        return "Mixproportionadd";
    }
    //采购单列表界面
    @RequestMapping("/Procurement")
    public String Procurement(){
        return "Procurement";
    }
    //采购单添加
    @RequestMapping("/Procurementadd")
    public String Procurementadd(){
        return "Procurementadd";
    }
    //车辆列表
    @RequestMapping("/Vehicle")
    public String Vehicle(){
        return "Vehicle";
    }
    //车辆添加
    @RequestMapping("/Vehicleadd")
    public String Vehicleadd(){
        return "Vehicleadd";
    }
    //添加计划表的界面，但是为未添加的通知单列表
    @RequestMapping("/Schedule")
    public String Schedule(){
        return "Schedule";
    }
    //添加计划
    @RequestMapping("/Scheduleadd")
    public String Scheduleadd(){
        return "Scheduleadd";
    }
    //计划列表
    @RequestMapping("/Shedulelist")
    public String Shedulelist(){
        return "Shedulelist";
    }
    //实际生产列表
    @RequestMapping("/Actualpro")
    public String Actualpro(){
        return "Actualpro";
    }
    //添加实际生产
    @RequestMapping("/Actualproadd")
    public String Actualproadd(){
        return "Actualproadd";
    }
    //运输单
    @RequestMapping("/Transportation")
    public String Transportation(){
        return "Transportation";
    }
    //添加运输单
    @RequestMapping("/Transportationadd")
    public String Transportationadd(){
        return "Transportationadd";
    }
    //首页界面
    @RequestMapping("/First")
    public String First(){
        return "First";
    }
    //列表为未添加的计划列表，但是为添加实际生产的界面
    @RequestMapping("/Actualschelist")
    public String Actualschelist(){
        return "Actualschelist";
    }
    //财务统计图
    @RequestMapping("/Finance1")
    public String Finance1(){
        return "Finance1";
    }
    //财务表格
    @RequestMapping("/Finance2")
    public String Finance2(){
        return "Finance2";
    }
    //合同修改
    @RequestMapping("/Contractmodify")
    public String Contractmodify(){
        return "Contractmodify";
    }
    //通知单修改
    @RequestMapping("/Noticemodify")
    public String Noticemodify(){
        return "Noticemodify";
    }
    //计划表修改
    @RequestMapping("/Schedulemodify")
    public String Schedulemodify(){
        return "Schedulemodify";
    }
    //实际生产修改
    @RequestMapping("/Actualpromodify")
    public String Actualpromodify(){
        return "Actualpromodify";
    }
    //运输单修改
    @RequestMapping("/Transportationmodify")
    public String Transportationmodify(){
        return "Transportationmodify";
    }
    //实验修改
    @RequestMapping("/Mixproportionmodify")
    public String Mixproportionmodify(){
        return "Mixproportionmodify";
    }
    //车辆修改
    @RequestMapping("/Vehiclemodify")
    public String Vehiclemodify(){
        return "Vehiclemodify";
    }
    //账户
    @RequestMapping("/Account")
    public String Account(){
        return "Account";
    }
    //账户添加
    @RequestMapping("/Accountadd")
    public String Accountadd(){
        return "Accountadd";
    }
    //账户修改
    @RequestMapping("/Accountmodify")
    public String Accountmodify(){
        return "Accountmodify";
    }
}
