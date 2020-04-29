package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.MixproportionMapper;
import cn.edu.nyist.model.Mixproportion;
import cn.edu.nyist.model.MixproportionDTO;
import cn.edu.nyist.model.MixproportionExample;
import cn.edu.nyist.service.MixproportionService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname MixproportionServiceImpl
 * @Description 配合比
 * @Date 2020/2/10 10:52
 * @Created by typ
 */
@Service
public class MixproportionServiceImpl implements MixproportionService {

    @Autowired
    private MixproportionMapper mixproportionMapper;

    @Override
    public List<MixproportionDTO> getMixproportion() throws Exception {
        MixproportionExample mixproportionExample = new MixproportionExample();
        MixproportionExample.Criteria criteria = mixproportionExample.createCriteria();
        criteria.andStateEqualTo("1");
        List<Mixproportion> mixproportions = mixproportionMapper.selectByExample(mixproportionExample);
        List<MixproportionDTO> mixproportionList = Lists.newArrayList();
        mixproportions.forEach(p->mixproportionList.add(new MixproportionDTO().transfer(p)));

        return mixproportionList;
    }

    @Override
    public List<MixproportionDTO> findAllMixproportion() throws Exception {
        MixproportionExample mixproportionExample = new MixproportionExample();
        List<Mixproportion> mixproportionList = mixproportionMapper.selectByExample(mixproportionExample);
        //转换DTO
        List<MixproportionDTO> mixproportionDTOList = Lists.newArrayList();
        mixproportionList.forEach(p->mixproportionDTOList.add(new MixproportionDTO().transfer(p)));
        return mixproportionDTOList;
    }

    @Override
    public void addMixproportion(MixproportionDTO mixproportionDTO) throws Exception {
        Mixproportion mixproportion = new MixproportionDTO().transferBack(mixproportionDTO);
        mixproportion.setState("0");
        mixproportionMapper.insert(mixproportion);
    }

    @Override
    public void updateMixproportion(MixproportionDTO mixproportionDTO) throws Exception {
        Mixproportion mixproportion = new MixproportionDTO().transferBack(mixproportionDTO);
        MixproportionExample mixproportionExample = new MixproportionExample();
        MixproportionExample.Criteria criteria = mixproportionExample.createCriteria();
        criteria.andIdEqualTo(mixproportion.getId());
        mixproportionMapper.updateByExample(mixproportion,mixproportionExample);
    }

    @Override
    public void deleteMixproportion(Integer id) throws Exception {
        mixproportionMapper.deleteByPrimaryKey(id);
    }
}
