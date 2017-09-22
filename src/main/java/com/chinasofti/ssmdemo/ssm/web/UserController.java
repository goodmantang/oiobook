package com.chinasofti.ssmdemo.ssm.web;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.ssmdemo.ssm.common.IsNumber;
import com.chinasofti.ssmdemo.ssm.common.captcha.CreateCaptchaServlet;
import com.chinasofti.ssmdemo.ssm.dal.entity.Address;
import com.chinasofti.ssmdemo.ssm.dal.entity.BalanceRecord;
import com.chinasofti.ssmdemo.ssm.dal.entity.Bankcard;
import com.chinasofti.ssmdemo.ssm.dal.entity.UserInfo;
import com.chinasofti.ssmdemo.ssm.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService us;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserInfo ui, String captcha, HttpServletRequest request, ModelMap modelMap) {
		System.out.println("captcha : " + captcha);
		System.out.println("session : " + (String) request.getSession().getAttribute("captcha"));
		if (!captcha.equalsIgnoreCase((String) request.getSession().getAttribute("captcha"))) {
			modelMap.put("msg", "验证码不正确!");
			System.out.println("验证码不正确!");
			return "forward:/index.jsp";

		}

		System.out.println("name : " + ui.getUserName() + "password : " + ui.getPassword());

		if (ui.getPassword() == null || ui.getPassword().length() < 6 || ui.getUserName() == null
				|| ui.getUserName().length() < 6) {
			modelMap.put("msg", "用户名或密码格式不正确!");
			System.out.println("用户名或密码格式不正确!");
			return "forward:/index.jsp";
		}
		if (!check(ui)) {
			modelMap.put("msg", "用户名或密码错误!");
			System.out.println("用户名或密码错误!");
			return "forward:/index.jsp";
		}

		request.getSession().setAttribute("userId", us.selectByUserName(ui.getUserName()).getUserId());
		logger.info("登录用户名 : " + ui.getUserName());

		return "forward:/book/query1";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String toadd() {

		return "register";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(UserInfo ui, MultipartFile uploadfile, ModelMap modelMap, HttpServletRequest request) {
		System.out.println(ui);

		String uploadDir = request.getServletContext().getRealPath("/upload/user/");
		File fileDir = new File(uploadDir);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		String realFileDir = uploadDir + System.nanoTime() + uploadfile.getOriginalFilename();
		System.out.println("文件名 : " + uploadfile.getOriginalFilename());
		File file = new File(realFileDir);

		try {
			uploadfile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		ui.setRegistTime(new Date());
		ui.setImgUrl(realFileDir);
		us.add(ui);
		logger.info("新增的用户id : " + ui.getUserId());
		modelMap.put("msg", "恭喜注册成功！");
		return "forward:/index.jsp";
	}

	boolean check(UserInfo u) {
		UserInfo userFromDB = us.selectByUserName(u.getUserName());
		if (u.getPassword().equals(userFromDB.getPassword())) {
			return true;
		}
		return false;
	}

	@RequestMapping("query")
	public String queryUser(int pageIdx) {
		System.out.println(us.queryUser(pageIdx));
		System.out.println("当前页数 : " + pageIdx + " 数据总页数 : " + us.countUser());

		return "lalala";
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String tomodify(int userId, ModelMap modelMap) {
		UserInfo ui = us.queryUser(userId).get(0);
		modelMap.put("user", ui);

		return "";
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(UserInfo ui) {
		us.updateUser(ui);

		return "";
	}

	@RequestMapping(value = "addAddress", method = RequestMethod.GET)
	public String toaddAddress() {

		return "addAddress";
	}

	@RequestMapping(value = "addAddress", method = RequestMethod.POST)
	public String addAddress(Address address, ModelMap modelMap) {
		if (address.getMobile().length() != 11 || !IsNumber.isNumeric(address.getMobile())
				|| address.getZipNo().length() != 6 || !IsNumber.isNumeric(address.getZipNo())) {
			modelMap.put("msg", "你的输入不符合要求，请重新输入!");
			return "addAddress";
		}

		us.addAddress(address);
		modelMap.put("userId", address.getUserId());
		// return "redirect:detail?userId="+address.getUserId();
		return "forward:detail";
	}

	@RequestMapping(value = "forgetPwd", method = RequestMethod.GET)
	public String toForgetPwd() {

		return "forgetPwd";
	}

	@RequestMapping(value = "forgetPwd", method = RequestMethod.POST)
	public String ForgetPwd(String userName, int operate, String label, ModelMap modelMap) {

		UserInfo ui = us.selectByUserName(userName);
		if (ui==null||userName == null || userName.length() < 6 || label == null) {
			modelMap.put("msg", "您输入的参数误!!");
			System.out.println("您输入的参数误!!");
			return "";
		}

		if (operate == 0) {
			if (ui.getMobile().equals(label)) {
				modelMap.put("msg", "验证成功，新密码将发送带你手机");
				System.out.println("验证成功，新密码将发送带你手机");
				ui.setPassword(CreateCaptchaServlet.creatCeaptcha());
				us.updateUser(ui);
				return "forward:/index.jsp";
			} else {
				System.out.println("验证失败，手机号不正确!");
				modelMap.put("msg", "验证失败，手机号不正确!");

				return "forgetPwd";
			}
		} else {
			if (ui.getEmail().equals(label)) {
				System.out.println("验证成功，新密码将发送带你邮箱");
				modelMap.put("msg", "验证成功，新密码将发送带你邮箱");
				ui.setPassword(CreateCaptchaServlet.creatCeaptcha());
				us.updateUser(ui);
				return "forward:/index.jsp";
			} else {
				System.out.println("验证失败，邮箱不正确!");
				modelMap.put("msg", "验证失败，邮箱不正确!");
				return "forgetPwd";
			}
		}
	}

	@RequestMapping(value = "detail")
	public String detail(int userId, ModelMap modelmap) {
		UserInfo ui = us.selectById(userId);
		modelmap.put("user", ui);
		String uiImg = ui.getImgUrl().substring(ui.getImgUrl().indexOf("upload"));
		System.out.println("图片相对路径 : " + uiImg);
		modelmap.put("userImg", uiImg);

		List<Bankcard> bankcardList = us.queryBankcard(userId);
		List<Address> addressList = us.queryAddress(userId);
		modelmap.put("bankcard", bankcardList);
		modelmap.put("address", addressList);

		return "myOIO";
	}

	@RequestMapping(value = "recharge", method = RequestMethod.GET)
	public String toRecharge() {

		return "lalala";
	}

	@RequestMapping(value = "recharge", method = RequestMethod.POST)
	public String Recharge(int userId,Integer bankcard, BigDecimal amount, ModelMap modelMap) {
		modelMap.put("userId", userId);
		
		
		if (amount.compareTo(new BigDecimal("777")) == 0||bankcard==null) {
			modelMap.put("msg", "充值失败!");
			return "forward:myAccount";
		}
		us.addBalance(userId, amount);
		modelMap.put("msg", "充值成功!");
		logger.info("用户 "+userId+" 充值 "+amount);
		return "forward:myAccount";
	}

	@RequestMapping(value = "addBankcard", method = RequestMethod.GET)
	public String toAddBankcard() {

		return "addBankcard";

	}

	@RequestMapping(value = "addBankcard", method = RequestMethod.POST)
	public String AddBankcard(Bankcard bankcard, ModelMap modelMap) {

		if (!IsNumber.isNumeric(bankcard.getBankCardId())) {
			modelMap.put("msg", "你的输入不符合要求，请重新输入!");
			return "addBankcard";
		}

		us.addBankcard(bankcard);
		modelMap.put("userId", bankcard.getUserId());
		return "forward:detail";

	}

	@RequestMapping(value = "myAccount")
	public String queryMyAccount(int userId, ModelMap modelMap) {
		UserInfo ui = us.selectById(userId);
		modelMap.put("user", ui);
		String uiImg = ui.getImgUrl().substring(ui.getImgUrl().indexOf("upload"));
		System.out.println("图片相对路径 : " + uiImg);
		modelMap.put("userImg", uiImg);
		List<Bankcard> bankcardList = us.queryBankcard(userId);
		modelMap.put("bankcardList", bankcardList);
		return "myAccount";
	}
	
	@RequestMapping(value = "queryBalance", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryBalance(int userId,int pageIdx){
		System.out.println("查询记录");
		Map<String,Object> map = new HashMap<>();
		List<BalanceRecord> balanceRecordList = us.queryBalanceList(userId,pageIdx);
		System.out.println("balanceRecordList: " +balanceRecordList.get(0).getOperateTime());
		map.put("success", balanceRecordList.size()>0);
		map.put("balanceRecord", balanceRecordList);
		map.put("pageIdx", pageIdx);
		map.put("totalPage", us.countBalanceRecord(userId));
		return map;
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("userId");
		return "forward:/index.jsp";
	}
	
}
