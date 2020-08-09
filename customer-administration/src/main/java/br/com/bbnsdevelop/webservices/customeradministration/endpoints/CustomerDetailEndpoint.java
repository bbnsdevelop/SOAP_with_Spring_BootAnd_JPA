package br.com.bbnsdevelop.webservices.customeradministration.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.bbnsdevelop.webservices.customeradministration.customer.GetCustomerDetailsRequest;
import br.com.bbnsdevelop.webservices.customeradministration.customer.GetCustomerDetailsResponse;
import br.com.bbnsdevelop.webservices.customeradministration.services.CustumerService;

@Endpoint
public class CustomerDetailEndpoint {

	@Autowired
	private CustumerService service;
	
	@PayloadRoot(namespace = "http://customer.customeradministration.webservices.bbnsdevelop.com.br", localPart = "GetCustomerDetailsRequest")
	@ResponsePayload
	public GetCustomerDetailsResponse processCustomerDetailRequest(@RequestPayload GetCustomerDetailsRequest request) {
		GetCustomerDetailsResponse response = service.findCustomerById(request.getId());
			
		return response;
		
	}
}
