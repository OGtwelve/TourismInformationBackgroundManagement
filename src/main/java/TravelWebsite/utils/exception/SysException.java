/**
 * 
 */
package TravelWebsite.utils.exception;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 * 自定义异常处理器类
 */
public class SysException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//异常信息
	private String messageString;

	public String getMessageString() {
		return messageString;
	}

	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}

	public SysException(String messageString) {
		super();
		this.messageString = messageString;
	}
	
}
