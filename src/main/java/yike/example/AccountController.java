package yike.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.yiguo.qiakr.util.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import yike.dto.BaseResponseDTO;
import yike.dto.AccountUpdateDTO;
import yike.example.mq.AccountCreateListener;
import yike.example.mq.AccountUpdateListener;
import yike.example.obj.Account;
import yike.example.service.AccountService;

@Api(description="账户管理")
@RestController
public class AccountController {

	@Resource
	private AccountService accountService;
	
	@Resource
	private AccountCreateListener accountCreateListener;
	
	@Resource
	private AccountUpdateListener accountUpdateListener;
	
	@ApiOperation(value = "查找", notes = "根据用户ID查找用户", response=Account.class)
	@RequestMapping(value="/account/account.json", method=RequestMethod.GET)
	public Object account(@ApiParam(value="用户id") @RequestParam Long id) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setStatus(0);
		Map<String, Object> result = new HashMap<>();
		result.put("account", accountService.getById(id));
		baseResponseDTO.setResult(result);
		return baseResponseDTO;
	}
	
	@RequestMapping(value="/account/accounts.json", method=RequestMethod.GET)
	public Object accounts(String ids) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setStatus(0);
		
		List<Long> idList = StringUtil.split2LongList(ids);
		List<List<Long>> pages = Lists.partition(idList, 1);
		//Java8语法
		List<CompletableFuture<Account>> futures = 
				pages.stream().map(page -> page.get(0))
							  .map(id -> CompletableFuture.supplyAsync(() -> {
				return accountService.getById(id);
			})).collect(Collectors.toList());
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
		
		List<Account> accounts = futures.stream().map(future -> future.join()).collect(Collectors.toList());
		
		Map<String, Object> result = new HashMap<>();
		result.put("accounts", accounts);
		
		baseResponseDTO.setResult(result);
		return baseResponseDTO;
	}
	
	@RequestMapping(value="/account/asyncAccount", method=RequestMethod.GET)
	public Callable<BaseResponseDTO> asyncAccount(Long id) {
		Callable<BaseResponseDTO> asyncTask = new Callable<BaseResponseDTO>() {

			@Override
			public BaseResponseDTO call() throws Exception {
				BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
				baseResponseDTO.setStatus(0);
				Map<String, Object> result = new HashMap<>();
				result.put("account", accountService.getById(id));
				
				Thread.sleep(1000);
				
				baseResponseDTO.setResult(result);
				return baseResponseDTO;
			}
		};

		return asyncTask;
	}
	
	@RequestMapping(value="/account/asyncAccountException", method=RequestMethod.GET)
	public Callable<BaseResponseDTO> asyncAccountException(Long id) {
		Callable<BaseResponseDTO> asyncTask = new Callable<BaseResponseDTO>() {

			@Override
			public BaseResponseDTO call() throws Exception {
				BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
				baseResponseDTO.setStatus(0);
				Map<String, Object> result = new HashMap<>();
				result.put("account", accountService.getById(id));
				int x= 1/0;
				baseResponseDTO.setResult(result);
				return baseResponseDTO;
			}
		};

		return asyncTask;
	}
	
	@ApiOperation(value = "创建")
	@RequestMapping(value="/account/account.json", method=RequestMethod.POST)
	public Object addAccount(@ApiParam(value="用户Name") @RequestParam String accountName) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setStatus(0);
		
		accountCreateListener.send(accountName);
		return baseResponseDTO;
	}
	
	@ApiOperation(value = "创建2")
	@RequestMapping(value="/account/account2.json", method=RequestMethod.POST)
	public Object addAccount2(@ApiParam(value="用户Name") @RequestParam String accountName,
			@ApiParam(value="用户id") @RequestParam Long accountId) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setStatus(0);
		
		accountCreateListener.send(accountId, accountName);
		return baseResponseDTO;
	}
	
	@ApiOperation(value = "更新")
	@RequestMapping(value="/account/account.json", method=RequestMethod.PUT)
	public Object updateAccount(@ApiParam(value="用户Name") @RequestParam String accountName,
			@ApiParam(value="用户id") @RequestParam Long accountId) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setStatus(0);
		
		accountUpdateListener.send(accountId, accountName);
		return baseResponseDTO;
	}
	
	@ApiOperation(value = "更新2")
	@RequestMapping(value="/account/account2.json", method=RequestMethod.PUT)
	public Object updateAccount2(AccountUpdateDTO accountDTO) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setStatus(0);
		
		Account account = new Account();
		account.setApnsToken(accountDTO.getApnsToken());
		account.setEmail(accountDTO.getEmail());
		account.setInviteCode(accountDTO.getInviteCode());
		account.setMobile(accountDTO.getMobile());
		account.setUsername(accountDTO.getUsername());
		account.setId(accountDTO.getId());
		accountService.updateAccountInfo(account);
		
		return baseResponseDTO;
	}
}
