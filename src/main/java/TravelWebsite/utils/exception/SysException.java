/**
 * 
 */
package TravelWebsite.utils.exception;

/**
 * @author 3187102230 ���ѱ�
 * ����������
 * �Զ����쳣��������
 */
public class SysException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//�쳣��Ϣ
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
