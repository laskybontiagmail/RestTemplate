package com.lasky.RestTemplate.utilities;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lasky.NativeModuleWrapper;

public class Utility {
	private static Utility singleton = null;
	private static Logger logger = LogManager.getLogger(Utility.class);
	
	private Utility() { 
		
	}
	
	/**
	 * Get the Singleton instance
	 */
	public static Utility getOnlyInstance() {
		if (Utility.singleton == null) {
			Utility.singleton = new Utility();
		}
		
		return Utility.singleton;
	}
	
	public <Type> String toJsonString(Type sourceObject) {
		JsonFactory jsonFactory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(jsonFactory);
		try {
			return mapper.writeValueAsString(sourceObject);
		} catch (JsonProcessingException jpexc) {
			jpexc.printStackTrace();
		}
		return null;
	}
	
	public boolean isNullOrEmpty(String string) {
		boolean result = false;
		
		if (string == null || string.isEmpty() || string.trim().isEmpty()) {
			result = true;
		}
		
		return result;
	}
	
	public void logFormattedException(Logger logger, Exception exception) {
		if (logger != null) {
			logger.info("");
			logger.info("======================================================================");
			logger.info(exception.getMessage());
			logger.info("======================================================================");
			logger.info("");
		}
	}
	
	
	public void logFormattedExceptionStackTrace(Logger logger, Exception exception) {
		if (logger != null) {
			String stackTrace = ExceptionUtils.getStackTrace(exception);
			
			logger.info("");
			logger.info("======================================================================");
			logger.info(stackTrace);
			logger.info("======================================================================");
			logger.info("");
		}
	}
	
	public String getSystemProcessIdLightWeightProcessId() {
		String processId = "";
		
		processId = "" + NativeModuleWrapper.getOnlyInstance().getLightWeightProcessId();
		logger.info("Thread id: " + this.getThreadId());
		
		return processId;
	}
	
	public String getThreadId() {
		long threadId = Thread.currentThread().getId();
		
		return "" + threadId;
	}
}
