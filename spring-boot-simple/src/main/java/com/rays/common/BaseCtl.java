
package com.rays.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class BaseCtl {

	public ORSResponse validate(BindingResult bindingResult) {

// Pehle ek ORSResponse object banate hain jiska success flag true set hota hai.
//		Yeh assume karta hai ki initially validation pass ho jayegi.		
		
		
		ORSResponse res = new ORSResponse(true);

// Agar bindingResult.hasErrors() true return kare, iska matlab validation fail hui hai aur errors hain.
// 		Tab yeh code block execute hoga.		
		
		if (bindingResult.hasErrors()) {

// Jab validation errors milti hain, to response ka success flag ko false set kar dete hain.
			
			res.setSuccess(false);

// Ek HashMap banaya jata hai jisme validation errors ko store karenge (fieldName aur errorMessage ke form mein).
// 			getFieldErrors() se saare field-specific errors ka list milta hai.

			
			Map<String, String> errors = new HashMap<String, String>();

			List<FieldError> list = bindingResult.getFieldErrors();

// Har FieldError object ka field name aur error message nikal kar errors map me daalte hain:
//			e.getField(): Field ka naam jisme error hai (e.g., "username").
//			e.getDefaultMessage(): Us error ka message (e.g., "Username is required").			
			
			list.forEach(e -> {
				errors.put(e.getField(), e.getDefaultMessage());
			});

// errors map ko ORSResponse object me inputerror key ke andar add karte hain.
			
			res.addInputError(errors);
		}
		return res;
	}
	
// Agar validation pass hui (no errors), to success = true ke sath response return hoga.
//	Agar validation fail hui, to success = false aur saari errors response me add ho jayengi.	
}
