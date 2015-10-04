package com.cvg.controller;

import java.util.List;

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

	@RequestMapping(value="/addItem", method = RequestMethod.POST)//not sure if this work because of restcontrol or corsfilter
	public Item addItem(@RequestBody Item item) {
		
		dao.addItem(item);
		return item;
	}
	
	@RequestMapping(value = "/delete/{itemId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("itemId") int itemId) {
        dao.delete(itemId);
    }
		

}
