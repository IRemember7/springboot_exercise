package life.majiang.community.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult implements Serializable {
    //总记录数
    private int totalCount;
    //每页记录数
    private int pageSize;
    //总页数
    private int totalPage;
    //数据库当前页数的起始数
    private int currPage;

    public PageResult(int totalCount, int pageSize, int currPage) {
        this.totalCount = totalCount; //数据库总记录数
        this.pageSize = pageSize;  //每页几条
        this.currPage = (currPage-1)*pageSize; 
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize); //计算总页数
    }
}
