package com.jiangcl.gmall.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiangcl
 * @date 2020/9/17
 * @desc
 */

@Data
@AllArgsConstructor
public class PageInfo<T> implements Serializable {
    private long currentPage;

    private long pages;

    private long pageSize;

    private long totalCount;

    private List<T> results;

}
