package br.com.bbnsdevelop.webservices.customeradministration.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	private int id;
	private String name;	
	private String phone;
	private String  email;
	
	
	

}
