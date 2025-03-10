package com.eraky.crudSystemSample.dto;


import lombok.Data;

@Data
public class OrderDTO {
    private String productName;
    private double price;
    private int quantity;
}
