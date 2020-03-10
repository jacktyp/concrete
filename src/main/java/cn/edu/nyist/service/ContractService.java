package cn.edu.nyist.service;

import cn.edu.nyist.model.Contract;
import cn.edu.nyist.model.ContractDTO;

import java.util.List;

/**
 * @Classname ContractService
 * @Description TODO
 * @Date 2020/2/10 9:06
 * @Created by typ
 */
public interface ContractService {

    /**
     * 根据ID获取合同信息
     * @param id
     * @return
     */
    ContractDTO getContract(Integer id) throws Exception;

    /**
     * 查询所有合同
     * @return
     */
    List<ContractDTO> findAllContract() throws Exception;

    /**
     * 增加合同
     * @param contract
     */
    void addContract(ContractDTO contract) throws Exception;

    /**
     * 更新合同
     * @param contract
     */
    void updateContract(ContractDTO contract) throws Exception;

    /**
     * 删除合同
     * @param id
     * @throws Exception
     */
    void deleteContract(Integer id) throws Exception;

    /**
     * 获取未生产的和
     * @param dayContractIdList
     * @return
     */
    Integer getContractByIds(List<Integer> dayContractIdList);

    /**
     * 根据ID获取
     * @param dayContractIdList
     * @return
     */
    List<Contract> getContractByIdList(List<Integer> dayContractIdList);
    /**
     * 当天
     * @return
     */
    Integer getDayContractProduction();

    /**
     * 当月 近一个月
     * @return
     */
    Integer getMonthContractProduction();

    /**
     * 根据时间查询数据
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    List<Contract> getContractInDate(Long startTime,Long endTime);


    List<ContractDTO> findAllContractByState();

}
