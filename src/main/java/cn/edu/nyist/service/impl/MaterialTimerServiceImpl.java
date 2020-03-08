package cn.edu.nyist.service.impl;

import cn.edu.nyist.model.Actualpro;
import cn.edu.nyist.model.Material;
import cn.edu.nyist.model.Procurement;
import cn.edu.nyist.service.ActualproService;
import cn.edu.nyist.service.MaterialService;
import cn.edu.nyist.service.MaterialTimerService;
import cn.edu.nyist.service.ProcureService;
import cn.edu.nyist.util.DateUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName MaterialTimerServiceImpl
 * @Description TODO
 * @Date 2020/3/8 10:56
 * @Created by typ
 */
@Service("materialTimerServiceImpl")
public class MaterialTimerServiceImpl implements MaterialTimerService {

    //石头剩余量
    private static final String STONE_TYPE = "1";
    //沙子剩余量
    private static final String SAND_TYPE = "2";
    //水泥剩余量
    private static final String CEMENT_TYPE = "3";
    //添加剂剩余量
    private static final String ADDITIVE_TYPE = "4";

    @Autowired
    private ProcureService procureService;
    @Autowired
    private ActualproService actualproService;
    @Autowired
    private MaterialService materialService;

    @Override
    public void steDataToDB() {
        Long lastDayStartMillis = DateUtil.lastDayStartMillis();
        Long lastDayEndMillis = DateUtil.lastDayEndMillis();

        //采购的数量
        Integer stoneNumAdd = 0;
        Integer sandNumAdd = 0;
        Integer cementNumAdd = 0;
        Integer additiveNumAdd = 0;

        //实际使用数量
        Integer stoneNumCut = 0;
        Integer sandNumCut = 0;
        Integer cementNumCut = 0;
        Integer additiveNumCut = 0;

        List<Material> materialList = materialService.findOne();
        Material material = null;
        if (CollectionUtils.isEmpty(materialList)){
            material = new Material();
            material.setStone(0);
            material.setSand(0);
            material.setCement(0);
            material.setAdditive(0);
        }else {
            material = materialList.get(0);
        }
        List<Procurement> procureInDate = procureService.findProcureInDate(lastDayStartMillis, lastDayEndMillis);
        if (!CollectionUtils.isEmpty(procureInDate)){
            Map<String, List<Procurement>> procurementMap = procureInDate.stream()
                    .collect(Collectors.groupingBy(Procurement::getType));

            for (Map.Entry<String, List<Procurement>> entry : procurementMap.entrySet()){
                String type = entry.getKey();
                List<Procurement> procurementList = entry.getValue();
                Integer allCount = procurementList.stream().collect(Collectors.summingInt(Procurement::getAmount));
                if (STONE_TYPE.equals(type)){
                    stoneNumAdd += allCount;
                }else if (SAND_TYPE.equals(type)){
                    sandNumAdd += allCount;
                }else if (CEMENT_TYPE.equals(type)){
                    cementNumAdd += allCount;
                }else if (ADDITIVE_TYPE.equals(type)){
                    additiveNumAdd += allCount;
                }
            }
        }

        List<Actualpro> actualproInDate = actualproService.getActualproInDate(lastDayStartMillis, lastDayEndMillis);
        if (!CollectionUtils.isEmpty(actualproInDate)){
            stoneNumCut = actualproInDate.stream().collect(Collectors.summingInt(Actualpro::getStoneamount));
            sandNumCut = actualproInDate.stream().collect(Collectors.summingInt(Actualpro::getSandamount));
            cementNumCut = actualproInDate.stream().collect(Collectors.summingInt(Actualpro::getCementamount));
            additiveNumCut = actualproInDate.stream().collect(Collectors.summingInt(Actualpro::getAdditiveamount));
        }

        Integer stoneNow = material.getStone();
        Integer sandNow = material.getSand();
        Integer cementNow = material.getCement();
        Integer additiveNow = material.getAdditive();

        material.setStone(stoneNow + (stoneNumAdd - stoneNumCut));
        material.setSand(sandNow + (sandNumAdd - sandNumCut));
        material.setCement(cementNow + (cementNumAdd - cementNumCut));
        material.setAdditive(additiveNow + (additiveNumAdd - additiveNumCut));

        materialService.addMaterial(material);

    }

}
