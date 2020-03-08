package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.FinancesticMapper;
import cn.edu.nyist.model.Financestic;
import cn.edu.nyist.service.FinancesticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName FinancesticServiceImpl
 * @Description TODO
 * @Date 2020/3/8 10:31
 * @Created by typ
 */
@Service
public class FinancesticServiceImpl implements FinancesticService {
    @Autowired
    private FinancesticMapper financesticMapper;

    @Override
    public void addFinancestic(Financestic financestic) {
        financesticMapper.insert(financestic);
    }
}
