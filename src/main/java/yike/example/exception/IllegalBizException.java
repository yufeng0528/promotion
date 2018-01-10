package yike.example.exception;

/**
 * 业务没处理正确
 * @author Administrator
 *
 */
public class IllegalBizException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1740027488465230174L;

	public IllegalBizException(String msg) {
		super(msg);
	}
}
