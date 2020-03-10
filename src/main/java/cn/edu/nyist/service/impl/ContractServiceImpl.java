package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.ContractMapper;
import cn.edu.nyist.model.Contract;
import cn.edu.nyist.model.ContractDTO;
import cn.edu.nyist.model.ContractExample;
import cn.edu.nyist.service.ContractService;
import cn.edu.nyist.util.DateUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Integer getContractByIds(List<Integer> dayContractIdList) {
        ContractExample contractExample = new ContractExample();
        ContractExample.Criteria criteria = contractExample.createCriteria();
        criteria.andIdIn(dayContractIdList);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        Integer amountNum = 0;
        if (!CollectionUtils.isEmpty(contractList)){
            amountNum = contractList.stream()
                    .filter(p->p.getAmount() != null)
                    .collect(Collectors.summingInt(Contract::getAmount));
            return amountNum;
        }else {
            return amountNum;
        }
    }

    @Override
    public List<Contract> getContractByIdList(List<Integer> dayContractIdList) {
        ContractExample contractExample = new ContractExample();
        ContractExample.Criteria criteria = contractExample.createCriteria();
        criteria.andIdIn(dayContractIdList);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        return contractList;
    }

    @Override
    public Integer getDayContractProduction() {
        Long dayTimeInMillis = DateUtil.dayTimeInMillis();
        Long nextDayTimeInMillis = DateUtil.nextDayTimeInMillis();
        ContractExample contractExample = new ContractExample();
        ContractExample.Criteria criteria = contractExample.createCriteria();
        criteria.andRegistranttimeGreaterThanOrEqualTo(dayTimeInMillis);
        criteria.andRegistranttimeLessThan(nextDayTimeInMillis);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        Integer dayNum = 0;
        if (!CollectionUtils.isEmpty(contractList)){
            dayNum = contractList.stream()
                    .filter(p->p.getAmount() != 0)
                    .collect(Collectors.summingInt(Contract::getAmount));
        }

        return dayNum;
    }

    @Override
    public Integer getMonthContractProduction() {
        Long monthStartTime = DateUtil.getDateStampCutDay(30);
        Long monthEndTime = DateUtil.nextDayTimeInMillis();
        ContractExample contractExample = new ContractExample();
        ContractExample.Criteria criteria = contractExample.createCriteria();
        criteria.andRegistranttimeGreaterThan(monthStartTime);
        criteria.andRegistranttimeLessThan(monthEndTime);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        Integer monthNum = 0;
        if (!CollectionUtils.isEmpty(contractList)){
            monthNum = contractList.stream()
                    .filter(p->p.getAmount() != 0)
                    .collect(Collectors.summingInt(Contract::getAmount));
        }

        return monthNum;
    }

    @Override
    public List<Contract> getContractInDate(Long startTime, Long endTime) {
        ContractExample contractExample = new ContractExample();
        ContractExample.Criteria criteria = contractExample.createCriteria();
        criteria.andRegistranttimeGreaterThanOrEqualTo(startTime);
        criteria.andRegistranttimeLessThanOrEqualTo(endTime);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        return contractList;
    }

    @Override
    public List<ContractDTO> findAllContractByState() {
        ContractExample contractExample = new ContractExample();
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        //转换DTO
        List<ContractDTO> contractDTOList = Lists.newArrayList();
        contractList.forEach(p->contractDTOList.add(new ContractDTO().transfer(p)));
        return contractDTOList.stream().filter(p->"0".equals(p.getRemark())).collect(Collectors.toList());
    }

}
