package com.batch14.product_management_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["com.batch14.product_management_service"])
class ProductManagementServiceApplication

fun main(args: Array<String>) {
	runApplication<ProductManagementServiceApplication>(*args)
}
