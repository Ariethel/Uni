package canzoneSanremo;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@CheckParameters
public class CheckParametersInterceptor {
    
    @AroundInvoke
    public Object count(InvocationContext ic) throws Exception{
        Integer voteParameters = (Integer)ic.getParameters()[0];
        if(voteParameters<10){
            System.out.println("Impedisco chiamata di getVotes con parametro " + voteParameters);
            return null;
        }
        return ic.proceed();
    }
    
}
