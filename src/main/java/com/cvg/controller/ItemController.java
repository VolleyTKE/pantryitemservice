package com.cvg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvg.dao.DAO;
import com.cvg.dao.DAOImpl;
import com.cvg.model.Item;

@Controller
@RestController
@RequestMapping("/api")
public class ItemController {
	
	
	private DAO dao = new DAOImpl();
	
	@RequestMapping(value="/getAllItems", method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody List<Item> listAllItems()	{
		return dao.getAllItems();
	}
	
	
	@RequestMapping(value="/{itemid}", method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody Item getItemDetails(@PathVariable int itemid){
		return dao.getItemByID(itemid);
	}

	@RequestMapping(value="/addItem", method = RequestMethod.POST)
	public Item addItem(@RequestBody Item item) {
		
		dao.addItem(item);
		return item;
	}
		

}
