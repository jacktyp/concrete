package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.ContractMapper;
import cn.edu.nyist.model.Contract;
import cn.edu.nyist.model.ContractDTO;
import cn.edu.nyist.model.ContractExample;
import cn.edu.nyist.service.ContractService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ContractServiceImpl
 * @Description 合同管理
 * @Date 2020/2/10 9:08
 * @Created by typ
 */
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public ContractDTO getContract(Integer id) throws Exception {
        Contract contract = contractMapper.selectByPrimaryKey(id);
        ContractDTO contractDTO = new ContractDTO().transfer(contract);
        return contractDTO;
    }

    @Override
    public List<ContractDTO> findAllContract() throws Exception {
        ContractExample contractExample = new ContractExample();
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        //转换DTO
        List<ContractDTO> contractDTOList = Lists.newArrayList();
        contractList.forEach(p->contractDTOList.add(new ContractDTO().transfer(p)));
        return contractDTOList;
    }

    @Override
    public void addContract(ContractDTO contractDTO) throws Exception {
        Contract contract = new ContractDTO().transferBack(contractDTO);
        contractMapper.insert(contract);
    }

    @Override
    public void updateContract(ContractDTO contractDTO) throws Exception {
        Contract contract = new ContractDTO().transferBack(contractDTO);
        ContractExample contractExample = new ContractExample();
        ContractExample.Criteria criteria = contractExample.createCriteria();
        criteria.andIdEqualTo(contract.getId());
        contractMapper.updateByExample(contract,contractExample);
    }

    @Override
    public void deleteContract(Integer id) throws Exception {
        contractMapper.deleteByPrimaryKey(id);
    }
}
