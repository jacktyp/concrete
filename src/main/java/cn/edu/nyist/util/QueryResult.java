package cn.edu.nyist.util;

/**
 * @Classname QueryResult
 * @Description TODO
 * @Date 2020/2/2 20:10
 * @Created by typ
 */
import java.io.Serializable;
import java.util.List;

public class QueryResult<T> implements Serializable {
    private long rowCount;
    private List<T> items;

    public QueryResult(List<T> items, long rowCount) {
        this.items = items;
        this.rowCount = rowCount;
    }

    public long getRowCount() {
        return this.rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    public List<T> getItems() {
        return this.items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
