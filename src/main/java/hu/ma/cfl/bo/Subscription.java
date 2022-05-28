package hu.ma.cfl.bo;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Subscription {
	@Getter
	private int id;
	private Customer customer;
	private LocalDate subscriptionDate;
	private Frequency frequency;
	private String address;
	private List<SubscriptionItem> items;
	

}
