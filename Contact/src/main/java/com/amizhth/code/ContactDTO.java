package com.amizhth.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContactDTO {
	
	private String name;
	private String email;
	private String message;
	
	private String responseMessage;

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
