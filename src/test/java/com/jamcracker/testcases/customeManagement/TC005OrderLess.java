package com.jamcracker.testcases.customeManagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.customer.CustomerAdminLogin;
import com.jamcracker.commonFunctions.customer.OrderLess;
import com.jamcracker.entity.service.OrderLessData;
import com.jamcracker.excel.reader.OrderLessReader;
import com.jamcracker.utilities.TestBase;

public class TC005OrderLess extends TestBase {
	
	@DataProvider(name = "orderLessData")
	public OrderLessData[] getOrderLessData() {
		OrderLessReader reader = new OrderLessReader(System.getProperty("user.dir") + "/Data/CustomerCreationData.xls");
		return reader.getOrderLessData("OrdersData.xls", "OrderLessSheet");
	}

	@BeforeMethod
	@Parameters({"browser","storeUrl"})
	public void setUp(String browser, String url) {
		init(browser, url);
	}
	
	@Test(dataProvider="orderLessData")
	public void testOrderLess(OrderLessData olData) throws Exception {
		
		CustomerAdminLogin custLogin = new CustomerAdminLogin();
		custLogin.customerAdminLogin(olData.getEmail(), olData.getPassword());
		OrderLess orderLess = new OrderLess();
		orderLess.orderLess(olData);
		
	}

}
