package com.jbit.controller;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jbit.dao.CartitemDao;
import com.jbit.dao.CategoryDao;
import com.jbit.dao.CommentDao;
import com.jbit.dao.ConfigDao;
import com.jbit.dao.OrderDao;
import com.jbit.dao.OrderitemDao;
import com.jbit.dao.ProductDao;
import com.jbit.dao.ProductImageDao;
import com.jbit.dao.PropertyDao;
import com.jbit.dao.PropertyValueDao;
import com.jbit.dao.UserDao;
import com.jbit.entity.Cartitem;
import com.jbit.entity.Category;
import com.jbit.entity.Comment;
import com.jbit.entity.Config;
import com.jbit.entity.Md5;
import com.jbit.entity.Order;
import com.jbit.entity.Orderitem;
import com.jbit.entity.Page;
import com.jbit.entity.Product;
import com.jbit.entity.ProductImage;
import com.jbit.entity.Property;
import com.jbit.entity.PropertyValue;
import com.jbit.entity.User;
@Controller
public class UserController {
	@Resource 
	private CartitemDao cartitemDao;
	@Resource 
	private CategoryDao categoryDao;
	@Resource 
	private ProductImageDao productImageDao;
	@Resource 
	private CommentDao commentDao;
	@Resource 
	private ConfigDao configDao;
	@Resource 
	private OrderDao orderDao;
	@Resource 
	private OrderitemDao orderitemDao;
	@Resource 
	private ProductDao productDao;
	@Resource 
	private PropertyDao propertyDao;
	@Resource 
	private PropertyValueDao propertyValueDao;
	@Resource 
	private UserDao userDao;
	
	//注册用户
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(User user){
		//用户注册时将用户的设备信息添加到数据库
			user.setUSERNAME(System.getenv().get("USERNAME"));
			user.setUSERDOMAIN(System.getenv().get("USERDOMAIN"));
			user.setGroup("user");
			user.setPassword(Md5.md5Password(user.getPassword()));
			userDao.insertUser(user);
			return "jsp/registerSuccess";
		}
		
	//用户登录
	@RequestMapping(value="/loginIn",method=RequestMethod.POST)
	public String loginIn(Model model,HttpSession session,User user){
		//存储网站名称
		session.setAttribute("website_name", configDao.findAll().get(0).getValue());
		session.setAttribute("path", session.getServletContext().getRealPath("./upload/"));
		user.setUSERNAME(System.getenv().get("USERNAME"));
		user.setUSERDOMAIN(System.getenv().get("USERDOMAIN"));
		User user2=userDao.findLogin(user);
		if(user2==null){
			model.addAttribute("error","用户名或者密码错误！");
			return "jsp/login";
		}else{
			session.setAttribute("user", user2); 
			if(user2.getGroup().equals("user")){
				//前台页面
				return "redirect:start";
			}else{
				//后台页面
				return "redirect:/listUser";
			}
		}
	}
	
	//前台首页
	@RequestMapping(value="/start")
	public String start(Model model,HttpSession session){
		User user=(User)session.getAttribute("user");
		//用户购物车中的商品数量
		Integer sum=cartitemDao.findProduct(user.getId());
		model.addAttribute("sum",sum);
		//前台页面
		session.setAttribute("categoryList", categoryDao.findAll());
		return "jsp/home";
	}	
	
	
	//退出
		@RequestMapping(value="/logout")
		public String logout(HttpSession session){
			session.removeAttribute("user");
			return "jsp/login";
		}
	
	//分页显示用户
	@RequestMapping(value="/listUser")
	public String loginIn(Model model,HttpSession session,Integer pageIndex){
		Page page=new Page();
		page.setTotalCount(Integer.parseInt(userDao.findCount().toString()));
		page.setPageIndex(pageIndex);
		page.init();
		List<User> list=userDao.findPageList((page.getPageIndex()-1)*page.getPageSize(), page.getPageSize());
		model.addAttribute("page", page);
		model.addAttribute("pageIndex", page.getPageIndex());
		model.addAttribute("list", list);
		return "jsp/admin/listUser";
	}
	
	//分页显示分类
	@RequestMapping(value="/categorylist")
	public String categorylist(Model model,HttpSession session,Integer pageIndex){
		Page page=new Page();
		page.setTotalCount(Integer.parseInt(categoryDao.findCount().toString()));
		page.setPageIndex(pageIndex);
		page.init();
		List<Category> list=categoryDao.findPageList((page.getPageIndex()-1)*page.getPageSize(), page.getPageSize());
		model.addAttribute("page", page);
		model.addAttribute("pageIndex", page.getPageIndex());
		model.addAttribute("list", list);
		return "jsp/admin/listCategory";
	}
	
	//分页显示属性值数据
	@RequestMapping(value="/propertylist")
	public String propertylist(Model model,HttpSession session,Integer pageIndex,Integer cid){
		Page page=new Page();
		page.setTotalCount(Integer.parseInt(propertyDao.findcount(cid).toString()));
		page.setPageIndex(pageIndex);
		page.init();
		List<Property> list=propertyDao.findPageList((page.getPageIndex()-1)*page.getPageSize(), page.getPageSize(),cid);
		model.addAttribute("page", page);
		model.addAttribute("pageIndex", page.getPageIndex());
		model.addAttribute("list", list);
		model.addAttribute("cid", cid);
		return "jsp/admin/listProperties";
	}

	//添加分类
		@RequestMapping(value="/addCategory",method=RequestMethod.POST)
		public String addCategory(Model model,HttpServletRequest  request,MultipartFile image,Category category   ){
			String path = request.getSession().getServletContext().getRealPath("./upload/");  
	        String fileName =  image.getOriginalFilename();
	        File dir = new File(path,fileName);          
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        //MultipartFile自带的解析方法  
	        try {
				image.transferTo(dir);
			} catch (Exception e) {
				e.printStackTrace();
			}  
	        category.setImgPath(fileName);
	        categoryDao.insertCategory(category);
			return "redirect:categorylist";
		}
	
		//属性的操作
		@RequestMapping(value="/edit")
		public String edit(Model model,HttpSession session,Integer id,String opt,Property property,Integer cid,Category category,Product product){
			//查看属性
			if(opt.equals("view")){
				model.addAttribute("property",propertyDao.findById(id));
				return "jsp/admin/editProperty";
			}
			//修改属性
			if(opt.equals("updateProperty")){
				property.setCategory(categoryDao.findById(cid));
				propertyDao.updateProperty( property);
				return "redirect:propertylist?cid="+cid;
			}
			//删除属性的同时级联删除属性的值
			if(opt.equals("deleteProperty")){
				propertyDao.deleteProperty(id);
				return "redirect:propertylist?cid="+cid;
			}
			//查看分类
			if(opt.equals("viewCategory")){
				model.addAttribute("category",categoryDao.findById(id));
				return "jsp/admin/editCategory";
			}
			//删除分类
			if(opt.equals("deleteCategory")){
				categoryDao.deleteById(id);
				return "redirect:categorylist";
			}
			
			//发货
			if(opt.equals("deliver")){
				orderDao.updateStatus(id);
				return "redirect:listOrder";
			}
			
			//删除商品
			if(opt.equals("deleteProduct")){
				productDao.deleteById(id);
				return "redirect:listProduct?cid="+cid;
			}
			//查看商品
			if(opt.equals("viewProduct")){
				model.addAttribute("product",productDao.findById(id));
				return "jsp/admin/editProduct";
			}
			
			return null;
		}	
		
		//根据分类id获得商品		3个业务共用一个方法，其中一个查询业务没有实现
		@RequestMapping(value="/listProduct")
		public String listProduct(Model model,Integer pageIndex ,Integer cid,String opt,String keyword){
			Page page=new Page();
			page.setTotalCount(productDao.findCount(cid,keyword));
			page.setPageIndex(pageIndex);
			page.init();
			List<Product> list=productDao.fidnPageList((page.getPageIndex()-1)*page.getPageSize(),page.getPageSize(), cid,keyword);
			for (Product product : list) {
				product.setCommentCount(productDao.findCommentCountById(product.getId()));
				productDao.updateProduct(product);
			}
			model.addAttribute("list",list);
			model.addAttribute("page",page);
			model.addAttribute("cid",cid);
			model.addAttribute("category", categoryDao.findById(cid));
			model.addAttribute("opt", opt);
			model.addAttribute("keyword", keyword);
			if(opt==null){
				return "jsp/admin/listProduct";
			}else if(opt.equals("font")){
				return "jsp/category";
			}else if(opt.equals("frontSearch")){
				return "jsp/category";
			}
			return null;
		}	
		
		//修改分类
				@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
				public String updateCategory(HttpSession session,MultipartFile image,Category category){
					//图片上传
					String path=session.getServletContext().getRealPath("./upload/");
					File file2=new File(path,image.getOriginalFilename());
					try {
						image.transferTo(file2);
					} catch (Exception e) {
						e.printStackTrace();
					}				
					category.setImgPath(image.getOriginalFilename());
					categoryDao.updateCategory(category);
					return "redirect:categorylist";
				}
				
				//根据分类id、用户id获得商品 
				@RequestMapping(value="/listOrder")
				public String listOrder(HttpSession session,Model model,Integer pageIndex,Integer uid,String address,String opt){
					Page page=new Page();
					page.setTotalCount(orderDao.findcount(uid,address));
					page.setPageIndex(pageIndex);
					page.init();
					List<Order> list=orderDao.findPageList((page.getPageIndex()-1)*page.getPageSize(),page.getPageSize(),uid,address);
					model.addAttribute("list",list);
					model.addAttribute("page",page);
					model.addAttribute("uid",uid);
					model.addAttribute("opt",opt);
					model.addAttribute("address",address);
					List<User> userList=userDao.findAll();
					model.addAttribute("userList",userList);
					List<Category> categoryList=categoryDao.findAll();
					model.addAttribute("categoryList",categoryList);
					//用户购物车中的商品数量
					User user=(User)session.getAttribute("user");
					Integer sum=cartitemDao.findProduct(user.getId());
					model.addAttribute("sum",sum);
					if(opt==null){
						return "jsp/admin/listOrder";
					}else if(opt.equals("front")){
						return "jsp/myOrder";
					}
					return null;
				}	
				
				//根据分类id获得商品
				@RequestMapping(value="/imagelist")
				public String imagelist(Model model,Integer pageIndex,Integer pid){
					Page page=new Page();
					page.setTotalCount(productImageDao.findcount(pid));
					page.setPageIndex(pageIndex);
					page.init();
					List<ProductImage> all=new ArrayList<ProductImage>();
					List<ProductImage> cover=new ArrayList<ProductImage>();
					List<ProductImage> head=new ArrayList<ProductImage>();
					List<ProductImage> detail=new ArrayList<ProductImage>();
					all=productImageDao.findPageList((page.getPageIndex()-1)*page.getPageSize(),page.getPageSize(), pid);
					model.addAttribute("page",page);
					model.addAttribute("pid",pid);
					model.addAttribute("all",all);
					return "jsp/admin/listProductImage";
				}	

				//设置 产品的属性值
				@RequestMapping(value="/propertyValue")
				public String propertyValue(Model model,Integer pid,Integer pageIndex){
					Page page=new Page();
					page.setTotalCount(Integer.parseInt(propertyValueDao.findcount(pid).toString()));
					page.setPageIndex(pageIndex);
					page.init();
					List<PropertyValue> list=propertyValueDao.findPageList((page.getPageIndex()-1)*page.getPageSize(),page.getPageSize(),pid);
					model.addAttribute("list",list);
					model.addAttribute("page",page);
					model.addAttribute("pid",pid);
					model.addAttribute("product",productDao.findById(pid));
					return "jsp/admin/editPropertyValue";
				}	
				
				//修改产品的属性值
				@RequestMapping(value="/updatePropertyValue")
				public String updatePropertyValue(Model model,String str,Integer id,Integer cid){
					System.out.println(str);
					for (int i = 0; i < str.split(",").length; i++) {
						propertyValueDao.updatePropertyValue(id,str.split(",")[i]);
					}
					return "jsp/admin/listProduct?cid="+cid;
				}
				
				//修改产品的属性值
				@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
				public String updateProduct(Model model,Product product,Integer cid){
					productDao.updateProduct2(product);
					return "redirect:listProduct?cid="+cid;
				}
				
				//添加产品
				@RequestMapping(value="/addProduct",method=RequestMethod.POST)
				public String addProduct(Product product,Integer cid){
					product.setCategory(categoryDao.findById(cid));
					productDao.insertProduct(product);
					return "redirect:listProduct?cid="+cid;
				}
				
				//网站设置
				@RequestMapping(value="/configedit")
				public String configedit(Model model,Integer pageIndex){
					Page page=new Page();
					page.setTotalCount(configDao.findcount());
					page.setPageIndex(pageIndex);
					page.init();
					List<Config> list=configDao.findPageList((page.getPageIndex()-1)*page.getPageSize(),page.getPageSize());
					model.addAttribute("page", page);
					model.addAttribute("list", list);
					return "jsp/admin/editConfig";
				}
				
				//网站设置
				@RequestMapping(value="/updateConfig",method=RequestMethod.POST)
				public String updateConfig(Model model,ArrayList<Config> list){
					System.out.println(list);
					for (Config config : list) {
						configDao.insertConfig(config.getId(),config.getValue());
					}
					return "redirect:configedit";
				}	
				
				//通过订单id获得订单
				@RequestMapping(value="/findOrderById")
				public String findOrderById(Integer oid,Model model,String opt,Integer pid){
					model.addAttribute("order", orderDao.findOrderById(oid));
					if(opt==null){
						return "jsp/confirmPay";
					}else if(opt.equals("fukuan")){
						return "jsp/pay";
					}else if(opt.equals("payed")){
						orderDao.updateStatus3(oid);
						return "jsp/payed";
					}else if(opt.equals("pingjia")){
						model.addAttribute("orderItem", orderitemDao.findOrderitemByOid(oid));
						model.addAttribute("commentCount", commentDao.findCommentByPid(pid));
						return "jsp/comment";
					}
					return null;
				}
				
				//确认收货
				@RequestMapping(value="/confirmed")
				public String confirmed(Integer oid,Model model,HttpSession session){
					User user=(User)session.getAttribute("user");
					//用户购物车中的商品数量
					Integer sum=cartitemDao.findProduct(user.getId());
					model.addAttribute("sum",sum);
					orderDao.updateStatus2(oid);
					return "jsp/confirmed";
				}	
				
				//我的购物车
				@RequestMapping(value="/cartlist")
				public String cartlist(HttpSession session,Integer uid,Model model,Integer pageIndex){
					//用户购物车中的商品数量
					User user=(User)session.getAttribute("user");
					Integer sum=cartitemDao.findProduct(user.getId());
					model.addAttribute("sum",sum);
					
					Page page=new Page();
					page.setTotalCount(cartitemDao.findCount(uid));
					page.setPageIndex(pageIndex);
					page.init();
					List<Cartitem> list=cartitemDao.findPageList((page.getPageIndex()-1)*page.getPageSize(),page.getPageSize(),uid);
					model.addAttribute("page", page);
					model.addAttribute("list", list);
					model.addAttribute("uid", uid);
					return "jsp/cart";
				}
				
				//评价商品
				@RequestMapping(value="/addComment",method=RequestMethod.POST)
				public String addComment(HttpSession session,Comment comment,Integer pid,Integer oid){
					User user=(User)session.getAttribute("user");
					comment.setCreateDate(new Timestamp(new Date().getTime()));
					comment.setUser(user);
					comment.setProduct(productDao.findById(pid));
					commentDao.insertComment(comment);
					
					Orderitem orderitem=new Orderitem();
					orderitem.setOrder(orderDao.findOrderById(oid));
					orderitem.getOrder().setStatus(6);
					orderitem.setProduct(productDao.findById(pid));
					orderitem.setComment(comment);
					orderitem.setNumber(1);
					orderitemDao.insertOrderitem(orderitem);
					return "redirect:listOrder?uid="+user.getId()+"&opt=front";
				}
				
				//通过id获取商品
				@RequestMapping(value="/findProductById")
				public String findProductById(Integer id,Model model,Integer pageIndex){
					Page page=new Page();
					page.setTotalCount(commentDao.findcount(id));
					page.setPageIndex(pageIndex);
					page.init();
					List<Comment> list=commentDao.findPageList((page.getPageIndex()-1)*page.getPageSize(), page.getPageSize(), id);
					model.addAttribute("list", list);
					model.addAttribute("page", page);
					model.addAttribute("id", id);
					model.addAttribute("product", productDao.findById(id));
					return "jsp/product";
				}
				
				//通过id删除购物车
				@RequestMapping(value="/deleteCart")
				@ResponseBody
				public String deleteCart(Integer id){
					cartitemDao.deleteById(id);
					return "success";
				}
				
				
}
