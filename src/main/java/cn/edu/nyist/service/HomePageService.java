package cn.edu.nyist.service;

import cn.edu.nyist.model.HomePageDataDTO;

/**
 * @ClassName HomePageService
 * @Description TODO
 * @Date 2020/2/28 13:41
 * @Created by typ
 */
public interface HomePageService {
    /**
     * 首页返回数据集合
     * @return
     */
    HomePageDataDTO getDataList() throws Exception;

}
