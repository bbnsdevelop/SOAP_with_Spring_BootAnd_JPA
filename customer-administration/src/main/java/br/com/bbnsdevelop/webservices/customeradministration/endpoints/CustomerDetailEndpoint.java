package br.com.bbnsdevelop.webservices.customeradministration.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.bbnsdevelop.webservices.customeradministration.customer.CustomerDetail;
import br.com.bbnsdevelop.webservices.customeradministration.customer.GetCustomerDetailsRequest;
import br.com.bbnsdevelop.webservices.customeradministration.customer.GetCustomerDetailsResponse;

@Endpoint
public class CustomerDetailEndpoint {

	@PayloadRoot(namespace = "http://customer.customeradministration.webservices.bbnsdevelop.com.br", localPart = "GetCustomerDetailsRequest")
	@ResponsePayload
	public GetCustomerDetailsResponse processCustomerDetailRequest(@RequestPayload GetCustomerDetailsRequest request) {
		GetCustomerDetailsResponse response = new GetCustomerDetailsResponse();
		CustomerDetail detail = new CustomerDetail();
		detail.setId(2222);
		detail.setName("Jose");
		detail.setPhone("99999-99999");
		detail.setEmail("jose@gmail.com");
		
		response.setCustomerDetail(detail);		
		return response;
		
	}
}
