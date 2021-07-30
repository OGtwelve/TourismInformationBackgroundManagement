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
 * @author 3187102230 王佳宝 畅游旅游网 处理异常解析器
 */
@Component("SysExceptionResolver")
public class SysExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();
		SysException sysException = null;

		//判断该异常是否是 自定义异常
		if (ex instanceof SysException) {
			//强转该异常为 自定义异常
			sysException = (SysException) ex;
		} else {
			//声明该异常类为 自定义异常
			sysException = new SysException("系统维护");
		}

		//把异常消息传入 error.jsp
		modelAndView.addObject("error", sysException.getMessageString());
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
