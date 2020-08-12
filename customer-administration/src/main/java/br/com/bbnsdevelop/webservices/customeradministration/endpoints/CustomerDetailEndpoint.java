package br.com.bbnsdevelop.webservices.customeradministration.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.bbnsdevelop.webservices.customeradministration.customer.DeleteCustomerDetailsRequest;
import br.com.bbnsdevelop.webservices.customeradministration.customer.DeleteCustomerDetailsResponse;
import br.com.bbnsdevelop.webservices.customeradministration.customer.GetAllCustomerDetailsRequest;
import br.com.bbnsdevelop.webservices.customeradministration.customer.GetAllCustomerDetailsResponse;
import br.com.bbnsdevelop.webservices.customeradministration.customer.GetCustomerDetailsRequest;
import br.com.bbnsdevelop.webservices.customeradministration.customer.GetCustomerDetailsResponse;
import br.com.bbnsdevelop.webservices.customeradministration.services.CustumerService;

@Endpoint
public class CustomerDetailEndpoint {

	@Autowired
	private CustumerService service;
	
	@PayloadRoot(namespace = "http://customer.customeradministration.webservices.bbnsdevelop.com.br", localPart = "GetCustomerDetailsRequest")
	@ResponsePayload
	public GetCustomerDetailsResponse processGetCustomerDetailsResponse(@RequestPayload GetCustomerDetailsRequest request) {
		GetCustomerDetailsResponse response = service.findCustomerById(request.getId());			
		return response;		
	}
	
	@PayloadRoot(namespace = "http://customer.customeradministration.webservices.bbnsdevelop.com.br", localPart = "GetAllCustomerDetailsRequest")
	@ResponsePayload
	public GetAllCustomerDetailsResponse processGetAllCustomerDetailsResponse(@RequestPayload GetAllCustomerDetailsRequest request) {
		GetAllCustomerDetailsResponse response = service.findAll();			
		return response;		
	}
	
	@PayloadRoot(namespace = "http://customer.customeradministration.webservices.bbnsdevelop.com.br", localPart = "DeleteCustomerDetailsRequest")
	@ResponsePayload
	public DeleteCustomerDetailsResponse processDeleteCustomerDetails(@RequestPayload DeleteCustomerDetailsRequest request) {
		DeleteCustomerDetailsResponse response = service.deleteById(request.getId());			
		return response;		
	}
	
	
}
