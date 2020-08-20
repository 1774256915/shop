package com.javabishe1234.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.javabishe1234.entity.product.Brand;
import com.javabishe1234.entity.product.Product;
import com.javabishe1234.entity.product.ProductType;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import com.javabishe1234.service.BrandService;
import com.javabishe1234.service.ProductService;
import com.javabishe1234.service.ProductTypeService;

@Component("initSystem")
public class InitSystem implements ServletContextListener,ApplicationContextAware{

	@SuppressWarnings("unused")
	private static ApplicationContext applicationContext;
	
	public static Map<Integer, Brand> brandMap=new HashMap<Integer,Brand>();
	
	
	
	@Resource
	private BrandService brandService;
	
	@Resource
	private ProductTypeService productTypeService;
	
	@Resource
	private ProductService productService;
	

	/**
	 * 加载数据到application缓存中
	 * @param application
	 */
	public void loadData(ServletContext application){
		
		List<ProductType> productTypeList = productTypeService.findProductTypeList();
		application.setAttribute("productTypeList", productTypeList); //
		   
		
	   // 销量排行
       Product s_product = new Product();
       s_product.setIs_del(0);
       List<Product> productListBySale = productService.list(s_product , 1, 3, Sort.Direction.DESC, "sale");
	   application.setAttribute("productListBySale", productListBySale); // 所有类别
	   
	   // 搜索页店铺热销
	   Product searchProduct = new Product();
	   searchProduct.setIs_del(0);
       List<Product> searchProductList = productService.list(searchProduct , 1, 4, Sort.Direction.DESC, "sale");
	   application.setAttribute("searchProductList", searchProductList); // 所有类别
	   
	   Product product = new Product();
       product.setIs_del(0);
       product.setProductType(productTypeService.getById(3));
	   List<Product> productListByTypeId3 = productService.list(product , 1, 6, Sort.Direction.DESC, "sale");
	   application.setAttribute("productListByTypeId3", productListByTypeId3); // 商城超市
	   
	   
	   Product product2 = new Product();
       product2.setIs_del(0);
       product2.setProductType(productTypeService.getById(2));
	   List<Product> productListByTypeId2 = productService.list(product2 , 1, 6, Sort.Direction.DESC, "sale");
	   application.setAttribute("productListByTypeId2", productListByTypeId2); // 服饰
	   
	   Product sproduct = new Product();
       sproduct.setIs_del(0);
       sproduct.setProductType(productTypeService.getById(1));
	   List<Product> productListByTypeId1 = productService.list(sproduct , 1, 6, Sort.Direction.DESC, "sale");
	   application.setAttribute("productListByTypeId1", productListByTypeId1); //3c数码
	   
	   Product ssproduct = new Product();
	   ssproduct.setIs_del(0);
	   ssproduct.setProductType(productTypeService.getById(4));
	   List<Product> productListByTypeId4 = productService.list(ssproduct , 1, 6, Sort.Direction.DESC, "sale");
	   application.setAttribute("productListByTypeId4", productListByTypeId4); //家用电器
	   
	   Product sxproduct = new Product();
	   sxproduct.setIs_del(0);
	   sxproduct.setProductType(productTypeService.getById(5));
	   List<Product> productListByTypeId5 = productService.list(sxproduct , 1, 6, Sort.Direction.DESC, "sale");
	   application.setAttribute("productListByTypeId5", productListByTypeId5); //家用电器
		
	   
		Brand brand = new Brand();
		brand.setIs_display(1);
		List<Brand>brandList = brandService.list(brand, 1, 18, Sort.Direction.DESC, "sort");
		application.setAttribute("brandList", brandList); // 品牌盛宴
		
		// 3c数码 品牌
		List<Brand> brandNumericalList = brandService.getBrandListByTypeId(1);
		application.setAttribute("brandNumericalList", brandNumericalList); 
		
		// 服饰品牌
		List<Brand> brandCostumeList = brandService.getBrandListByTypeId(2);
		application.setAttribute("brandCostumeList", brandCostumeList); 
		
		// 商城超市品牌
		List<Brand> brandShopList = brandService.getBrandListByTypeId(3);
		application.setAttribute("brandShopList", brandShopList);  
		
		// 家用电器品牌
		List<Brand> brandElectricalList = brandService.getBrandListByTypeId(3);
		application.setAttribute("brandElectricalList", brandElectricalList); 
		
		//今日特惠
		List<Product> productlList = productService.list(s_product, 1, 12, Sort.Direction.ASC, "productPrice");
		application.setAttribute("productlList", productlList); 
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		loadData(sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		InitSystem.applicationContext=applicationContext;
	}

}
