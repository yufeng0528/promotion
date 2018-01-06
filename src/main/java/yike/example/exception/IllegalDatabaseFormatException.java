package yike.example.exception;

/**
 * 非法数据库数据结构错误
 * @author Administrator
 *
 */
public class IllegalDatabaseFormatException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5483512983172428963L;

	public IllegalDatabaseFormatException(String msg, String rightFormate) {
		super(msg + " 正确的格式为：" + rightFormate);
	}
}
