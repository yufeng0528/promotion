package yike.example.dao;

import yike.example.obj.Account;

public interface AccountDao {

	Account selectByPrimaryKey(Long id);
	
	void updateAccountInfo(Account account);
}
