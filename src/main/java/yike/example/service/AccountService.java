package yike.example.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import yike.example.dao.AccountDao;
import yike.example.obj.Account;

@Service
public class AccountService {

	@Resource
	private AccountDao accountDao;
	
	@Cacheable(value="account", key="'aco_' + #id", condition = "#id != null")
	public Account getById(Long id) {
		return accountDao.selectByPrimaryKey(id);
	}
	
	public void updateAccountInfo(Account account) {
		//
		accountDao.updateAccountInfo(account);
	}
}
