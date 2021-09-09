package com.penruins.community.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.FinancePO;
import com.penruins.community.entity.VO.FinanceVO;
import com.penruins.community.entity.VO.PageVO;
import com.penruins.community.mapper.FinanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinanceService {
  @Autowired
  private FinanceMapper financeMapper;

  public PageVO<FinanceVO> getFinances(int page, int limit) {
    Page<FinanceVO> financeVOpage = new Page<>(page, limit);
    financeVOpage = financeMapper.selectFinanceListPage(financeVOpage);
    List<FinanceVO> finances = financeVOpage.getRecords();
    PageVO<FinanceVO> pageVO = PageVO.<FinanceVO>builder()
            .records(finances.isEmpty() ? new ArrayList<>() : finances)
            .total(financeVOpage.getTotal())
            .current(financeVOpage.getCurrent())
            .size(financeVOpage.getSize())
            .build();
    return pageVO;
  }

  public boolean insertFinance(String userId) {
    FinancePO financePO = new FinancePO();
    String id = IdUtil.objectId();
    financePO.setId(id);
    financePO.setUserId(userId);
    financeMapper.insert(financePO);
    return true;
  }
}
