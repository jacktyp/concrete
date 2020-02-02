package cn.edu.nyist.util;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 分页工具类
 */
public class QueryUtil {
    /**
     * 根据分页条件得到分页数据集合
     *
     * @param list
     * @param pageSize
     * @param pageIndex
     * @param <T>
     * @return
     */
    public static <T> QueryResult<T> getListByPageInfo(List<T> list, Integer pageSize, Integer pageIndex) {
        QueryResult emptyQueryResult = new QueryResult(Lists.newArrayList(), 0);
        if (list == null) {
            return emptyQueryResult;
        }
        int querySize = list.size();
        if (pageIndex == null && pageSize == null) {
            return new QueryResult<>(list, querySize);
        }
        boolean pageConditionIllegal = pageIndex == null
                || pageSize == null
                || pageIndex <= 0
                || pageSize <= 0;
        if (pageConditionIllegal) {
            return emptyQueryResult;
        }
        if (pageSize * (pageIndex - 1) > querySize) {
            return emptyQueryResult;
        } else {
            List<T> resultList = Lists.newArrayList();
            if (pageIndex * pageSize >= querySize) {
                resultList = list.subList(pageSize * (pageIndex - 1), querySize);
            } else {
                resultList = list.subList(pageSize * (pageIndex - 1), pageIndex * pageSize);
            }
            return new QueryResult<>(resultList, querySize);
        }
    }

    public static StringBuffer addSql(String[] addressCode) {
        StringBuffer sql = new StringBuffer();
        if (addressCode != null && addressCode.length != 0) {
            if (addressCode.length == 1) {
                sql.append(" and t1.province_code = '" + addressCode[0] + "' ");
            } else if (addressCode.length == 2) {
                sql.append("  and t1.city_code = '" + addressCode[1] + "' ");
            } else if (addressCode.length == 3) {
                sql.append("  and t1.county_code = '" + addressCode[2] + "' ");
            } else if (addressCode.length == 4) {
                sql.append("  and t1.town_code = '" + addressCode[3] + "'");
            }
        }
        return sql;
    }

    public static String[] stringToArray(String s) {
        if (Strings.isNullOrEmpty(s)) {
            return null;
        }
        String[] picture = s.split(",");
        return picture;
    }
}
