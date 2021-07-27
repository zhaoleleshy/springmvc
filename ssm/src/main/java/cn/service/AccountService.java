package cn.service;

import cn.dao.AccountDao;
import cn.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    public void saveAccount(Account account);
}
