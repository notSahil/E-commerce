package com.thbs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.exception.CartItemException;
import com.thbs.exception.UserException;
import com.thbs.modal.CartItem;
import com.thbs.modal.User;
import com.thbs.response.ApiResponse;
import com.thbs.service.CartItemService;
import com.thbs.service.UserService;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemController {

	private CartItemService cartItemService;
	private UserService userService;
	
	public CartItemController(CartItemService cartItemService,UserService userService) {
		this.cartItemService=cartItemService;
		this.userService=userService;
	}
	
	@DeleteMapping("/del/{cartItemId}")
	public ResponseEntity<ApiResponse> deleteCartItemHandler(@PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt) {
	    try {
	        User user = userService.findUserProfileByJwt(jwt);
	        cartItemService.removeCartItem(user.getId(), cartItemId);
	        ApiResponse res = new ApiResponse("Item Removed From Cart", true);
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
	    } catch (CartItemException | UserException e) {
	        // Handle exceptions appropriately
	        ApiResponse res = new ApiResponse(e.getMessage(), false);
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	    }
	}
	
	@PutMapping("/{cartItemId}")
	public ResponseEntity<CartItem>updateCartItemHandler(@PathVariable Long cartItemId, @RequestBody CartItem cartItem, @RequestHeader("Authorization")String jwt) throws CartItemException, UserException{
		
		User user=userService.findUserProfileByJwt(jwt);
		
		CartItem updatedCartItem =cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
		
		//ApiResponse res=new ApiResponse("Item Updated",true);
		
		return new ResponseEntity<>(updatedCartItem,HttpStatus.ACCEPTED);
	}
}