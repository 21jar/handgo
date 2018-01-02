package com.stackfing.handgo.service.serviceImpl;

import com.stackfing.handgo.entity.ProductType;
import com.stackfing.handgo.mapper.ProductTypeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTypeServiceImplTest {

	@Autowired
	private ProductTypeMapper productTypeMapper;

	@Test
	public void selectAllRoot() {
		List<ProductType> productTypeList = productTypeMapper.selectAllRoot();
		for (ProductType p : productTypeList) {
			System.out.println(p);
		}
	}

	@Test
	public void selectAllChildrenByParentId() {
		List<ProductType> productTypes = productTypeMapper.selectAllChildrenByParentId(Long.valueOf(1L));
		for (ProductType p:
			 productTypes) {
			System.out.println(p);
		}
	}
}