package hu.ma.cfl.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Product {
	
	private int id;
	private String name;
	private int price;
	private String description;
	private String imagePath;

}
