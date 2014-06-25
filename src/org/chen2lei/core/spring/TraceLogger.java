package org.chen2lei.core.spring;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TraceLogger {
	private static final Logger LOG = Logger.getLogger(TraceLogger.class);
	long startTime;
	@Pointcut("execution(* org.chen2lei.service.register.business.*.*(..))")
	public void logTrace() {
	}
	
	@Before("logTrace()")
	public void logBefore(JoinPoint joinPoint) {
		 
		startTime = System.currentTimeMillis();
	}

	//@Around("logTrace()")
	public void log(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		joinPoint.proceed();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("---");
		buffer.append(System.currentTimeMillis() - start);
		buffer.append(" ms, finish caslling ");
		buffer.append(joinPoint.getSignature().getDeclaringType().getName());
		buffer.append(".");
		buffer.append(joinPoint.getSignature().getName());
		LOG.debug(buffer);
	}
	
	
	 @AfterReturning(
		      pointcut = "logTrace()",
		      returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		 	System.out.println("monitor returning : " + joinPoint.getSignature().getName());
		System.out.println(System.currentTimeMillis() - startTime);

	   }

}
