package br.com.bbnsdevelop.webservices.customeradministration.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.bbnsdevelop.webservices.customeradministration.customer.CustomerDetail;
import br.com.bbnsdevelop.webservices.customeradministration.customer.DeleteCustomerDetailsResponse;
import br.com.bbnsdevelop.webservices.customeradministration.customer.GetAllCustomerDetailsResponse;
import br.com.bbnsdevelop.webservices.customeradministration.customer.GetCustomerDetailsResponse;
import br.com.bbnsdevelop.webservices.customeradministration.customer.Status;
import br.com.bbnsdevelop.webservices.customeradministration.dtos.Customer;

@Component
public class CustumerService {

	private List<Customer> customerList;

	{
		this.customerList = Arrays.asList(
				Customer.builder().id(1).name("Jose").phone("9999-9999").email("jose@gmail.com").build(),
				Customer.builder().id(2).name("Maria").phone("9999-9999").email("maria@gmail.com").build(),
				Customer.builder().id(3).name("Tião").phone("9999-9999").email("tiao@gmail.com").build(),
				Customer.builder().id(4).name("Marcos").phone("9999-9999").email("marcos@gmail.com").build(),
				Customer.builder().id(5).name("Ze").phone("9999-9999").email("ze@gmail.com").build());

	}

	public GetCustomerDetailsResponse findCustomerById(int id) {
		Optional<Customer> customerOptional = this.customerList.stream().filter(c -> c.getId() == id).findAny();
		if (customerOptional.isPresent()) {
			GetCustomerDetailsResponse response = new GetCustomerDetailsResponse();
			response.setCustomerDetail(convertToCustomerDetail(customerOptional.get()));
			return response;
		} else {
			return null;
		}

	}

	public GetAllCustomerDetailsResponse findAll() {
		GetAllCustomerDetailsResponse responseDetail = new GetAllCustomerDetailsResponse();
		this.customerList.forEach(customer -> {		
			responseDetail.getCustomerDetail().add(convertToCustomerDetail(customer));
		});
		return responseDetail;
	}
	
	public DeleteCustomerDetailsResponse deleteById(int id) {
		Status status = null;
		Optional<Customer> customerOptional = this.customerList.stream().filter(c -> c.getId() == id).findAny();
		if (customerOptional.isPresent()) {
			//this.customerList.remove(customerOptional.get());
			status = Status.SUCCESS;
		}else {
			status = Status.FAILURE;
		}
		DeleteCustomerDetailsResponse response = new DeleteCustomerDetailsResponse();
		response.setStatus(status);
		return response;
		
	}

	private CustomerDetail convertToCustomerDetail(Customer customer) {
		CustomerDetail detail = new CustomerDetail();
		detail.setId(customer.getId());
		detail.setName(customer.getName());
		detail.setPhone(customer.getPhone());
		detail.setEmail(customer.getEmail());
		return detail;
	}

}
