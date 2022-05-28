package hu.ma.cfl.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SubscriptionItem {
	
	private int id;
	private Subscription subscription;
	private Product product;
	private int quantity;
	

}
