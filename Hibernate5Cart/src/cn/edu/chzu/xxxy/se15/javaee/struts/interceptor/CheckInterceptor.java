package cn.edu.chzu.xxxy.se15.javaee.struts.interceptor;

import java.util.Locale;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 国际化拦截：extends AbstractInterceptor
 * implements Interceptor
 * */
public class CheckInterceptor implements Interceptor{
	private static final long serialVersionUID = -1112495747942034188L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ActionContext ac = ai.getInvocationContext();
		Map<String, Object> session = ac.getSession();
		Locale locale = (Locale)session.get("WW_TRANS_I18N_LOCALE");
		if(locale==null){
			locale = new Locale("zh","CN");
			session.put("WW_TRANS_I18N_LOCALE",locale);
		}
		return ai.invoke();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}