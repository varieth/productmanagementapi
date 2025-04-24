package com.inventorial.inventorymanager;



public interface InventoryProjection {
	Long getProd_id();

	String getName();

	String getProd_desc();

	int getProd_quantity();

	String getProd_location();

	String getCategory_name();

	Double getPrice();

	Double getCost();

	String getBarcode();
}