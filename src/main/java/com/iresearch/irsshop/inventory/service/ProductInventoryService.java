package com.iresearch.irsshop.inventory.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iresearch.irsshop.inventory.dao.RedisDAO;
import com.iresearch.irsshop.inventory.domain.ProductInventory;
import com.iresearch.irsshop.inventory.mapper.ProductInventoryMapper;

/**
 * 商品库存Service实现类
 * 
 * @author Administrator
 *
 */
@Service("productInventoryService")
public class ProductInventoryService {

	@Resource
	private ProductInventoryMapper productInventoryMapper;
	@Resource
	private RedisDAO redisDAO;

	public void updateProductInventory(ProductInventory productInventory) {
		productInventoryMapper.updateProductInventory(productInventory);
	}

	/**
	 * 根据商品id查询商品库存
	 * 
	 * @param productId
	 *            商品id
	 * @return 商品库存
	 */
	public ProductInventory findProductInventory(Integer productId) {
		return productInventoryMapper.findProductInventory(productId);
	}

	public void removeProductInventoryCache(ProductInventory productInventory) {
		String key = "product:inventory:" + productInventory.getProductId();
		redisDAO.delete(key);
	}

	/**
	 * 设置商品库存的缓存
	 * 
	 * @param productInventory
	 *            商品库存
	 */
	public void setProductInventoryCache(ProductInventory productInventory) {
		String key = "product:inventory:" + productInventory.getProductId();
		redisDAO.set(key, String.valueOf(productInventory.getInventoryCnt()));
	}

	/**
	 * 获取商品库存的缓存
	 * 
	 * @param productId
	 * @return
	 */
	public ProductInventory getProductInventoryCache(Integer productId) {
		Long inventoryCnt = 0L;

		String key = "product:inventory:" + productId;
		String result = redisDAO.get(key);

		if (result != null && !"".equals(result)) {
			try {
				inventoryCnt = Long.valueOf(result);
				return new ProductInventory(productId, inventoryCnt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
