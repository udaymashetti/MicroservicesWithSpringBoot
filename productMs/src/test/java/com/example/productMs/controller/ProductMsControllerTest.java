//package com.example.productMs.controller;
//
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.example.productMs.entity.ProductEntity;
//import com.example.productMs.service.ProductService;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = ProductController.class)
//public class ProductMsControllerTest {
//	@MockBean
//	private ProductService productServ;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	private ProductEntity ProductEntity1;
//	private ProductEntity ProductEntity2;
//	
//	@Autowired
//    private WebApplicationContext wac;
//
//	@Before
//	public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//
//	}
//	
//	
//	public void product1() {
//		ProductEntity1 = new ProductEntity();
//		ProductEntity1.setProductid(5);
//		ProductEntity1.setProductDesc("TestString");
//		ProductEntity1.setProductManufacturer("dummy1");
//		ProductEntity1.setProductName("dimmy2");
//		ProductEntity1.setProductType("hjhj");
//	}
//	public void product2() {
//		ProductEntity2 = new ProductEntity();
//		ProductEntity2.setProductid(6);
//		ProductEntity2.setProductDesc("TestSdtring");
//		ProductEntity2.setProductManufacturer("dudmmy1");
//		ProductEntity2.setProductName("dimdmy2");
//		ProductEntity2.setProductType("hjhdj");
//	}
//	
//	@Before
//	public void setUp() {
//		product1();
//		product2();
//	} 
//	
//	@Test
//	public void testSubmitCustomerFailsValidation() throws Exception {
//		this.mockMvc.perform(post("/insertProduct").requestAttr("productid", ProductEntity1.getProductid()).param("productName", ProductEntity1.getProductName())
//				
//						.param("productType", ProductEntity1.getProductType()).param("productDesc", ProductEntity1.getProductDesc()).param("productManufacturer", ProductEntity1.getProductManufacturer()))
//				.andExpect(status().isOk()).andDo(print());
//	}
//}
