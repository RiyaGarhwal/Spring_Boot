
package com.rays.common;

import java.util.HashMap;
import java.util.Map;
//The ORSResponse class is designed to encapsulate a response in a structured way.
public class ORSResponse {

	// These are string constants representing keys for specific types of response data:

//  INPUT_ERROR: Used to store validation errors or input-related issues.
//  MESSAGE: Used to store general response messages.
//  DATA: Used to store actual response data.
//  The static final modifiers ensure these values are constant and accessible across instances of the class.
	
	public static final String INPUT_ERROR = "inputerror";
	public static final String MESSAGE = "message";
	public static final String DATA = "data";

//	result: A HashMap to store response content. It is initialized as an empty map to avoid NullPointerException.
//  success: A boolean that stores whether the operation was successful. Its default value is false
	
	private Map<String, Object> result = new HashMap<String, Object>();

	public boolean success = false;

// Default Constructor: Ek aise ORSResponse object banata hai jisme success ka value default false hota hai aur result ek empty map hota hai.	
	
	public ORSResponse() {
	}

// Parameterized Constructor: Aapko success flag ko true ya false set karne ki flexibility deta hai object banate waqt, aur result map wahi empty rehta hai.	
	
	public ORSResponse(boolean success) {
		this.success = success;
	}

// isSuccess aur setSuccess: success flag ko check karne aur set karne ke liye use hote hain.
//	getResult aur setResult: result map ka data access karne aur modify karne ke liye use hote hain.	
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

// Utility Methods
//	These methods provide convenience for adding specific types of data to the response.


// Adds an input error message or data to the result map under the INPUT_ERROR key.	
	
	public void addInputError(Object value) {
		result.put(INPUT_ERROR, value);
	}

// Adds a message to the result map under the MESSAGE key.	
	
	public void addMessage(Object value) {
		result.put(MESSAGE, value);
	}

// Adds general data to the result map under the DATA key.
	
	public void addData(Object value) {
		result.put(DATA, value);
	}

// A generic method to add any key-value pair to the result map.	
	
	public void addResult(String key, Object value) {
		result.put(key, value);
	}

}
