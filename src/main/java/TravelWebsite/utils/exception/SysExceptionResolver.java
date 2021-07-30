/**
 * 
 */
package TravelWebsite.utils.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 3187102230 ���ѱ� ���������� �����쳣������
 */
@Component("SysExceptionResolver")
public class SysExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();
		SysException sysException = null;

		//�жϸ��쳣�Ƿ��� �Զ����쳣
		if (ex instanceof SysException) {
			//ǿת���쳣Ϊ �Զ����쳣
			sysException = (SysException) ex;
		} else {
			//�������쳣��Ϊ �Զ����쳣
			sysException = new SysException("ϵͳά��");
		}

		//���쳣��Ϣ���� error.jsp
		modelAndView.addObject("error", sysException.getMessageString());
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
