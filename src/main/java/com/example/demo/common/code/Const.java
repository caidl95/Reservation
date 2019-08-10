package com.example.demo.common.code;

/**
 * 常量类
 * @author hy
 *
 */
public class Const {
	 /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";

    /**
     * 手机短信的数字key
     */
    public static final String SESSION_KEY_PHONE_CODE = "SESSION_KEY_MOBILE_CODE";

    /**
     * 手机短信的手机号key
     */
    public static final String SESSION_KEY_PHONE = "SESSION_KEY_MOBILE";

    /**
     * 图形验证码存入session的key
     */
    public static final String SESSION_KEY_IMAGE = "SESSION_KEY_IMAGE_CODE";
    
    /**
     * 用户名存入session的key
     */
    public static final String SESSION_CURRENT_USER = "currentUser";
    
    
	//
	public static String basePath;
	
	public static String baseUrl;
	
	static {
		basePath = System.getProperty( "user.home" );
		baseUrl = System.getProperty( "user.home" );
	}
	

		

	public static void main(String[] args) {
		    System.out.println("user_home:"  + System.getProperty( "user.home" ));     
		      
	}
	
	
	
	

	/**
	 *  数据为空
	 */
	public static final String EMPTY_DATA_MESSAGE = "获取数据失败，请重试";

	/**
	 * 保存成功
	 */
	public static final String SAVE_SUCCESS = "保存成功";

	/**
	 * 保存失败
	 */
	public static final String SAVE_FIALED = "保存失败，请重试";

	/**
	 *  修改成功
	 */
	public static final String UPDATE_SUCCESS = "修改成功";

	/**
	 *  修改失败
	 */
	public static final String UPDATE_FIALED = "修改失败，请重试";

	/**
	 * 删除成功
	 */
	public static final String DELETE_SUCCESS = "删除成功";

	/**
	 *  删除失败
	 */
	public static final String DELETE_FIALED = "删除失败，请重试";

	/** 
	 * 启用成功
	 */
	public static final String ENABLED_SUCCESS = "启用成功";

	/** 
	 * 启用失败
	 */
	public static final String ENABLED_FIALED = "启用失败，请重试";

	/**
	 * 禁用成功
	 */
	public static final String DISABLE_SUCCESS = "禁用成功";

	/**
	 * 禁用失败
	 */
	public static final String DISABLE_FIALED = "禁用失败，请重试";

	/**
	 * 必须登录
	 */
	public static final String MUST_LOGIN = "请登录后再进行操作";

	/**
	 * 用户被禁用
	 */
	public static final String USER_DISABLE = "用户已被禁用";

	/**
	 * 用户被删除
	 */
	public static final String USER_DELETE = "用户信息不存在";

	/**
	 * 权限不足
	 */
	public static final String NO_PERMISSON = "权限不足，操作失败";

	/**
	 * 菜单禁用 
	 */
	public static final String MENU_DISABLE = "功能已被禁用，操作失败";

	/**
	 * 分配角色成功
	 */
	public static final String ALLOCATION_ROLE_SUCCESS = "分配角色成功";

	/**
	 * 分配角色失败
	 */
	public static final String ALLOCATION_ROLE_FIALED = "分配角色失败，请重试";

	/**
	 * 分配权限成功 
	 */
	public static final String ALLOCATION_PERMISSION_SUCCESS = "分配权限成功";

	/**
	 * 分配权限失败
	 */
	public static final String ALLOCATION_PERMISSION_FIALED = "分配权限失败，请重试";

	/**
	 * token认证信息已失效
	 */
	public static final String TOKEN_FAILURE = "认证信息已失效";

	/**
	 * 已经是最新版本
	 */
	public static final String IS_NEW_VERSION = "已经是最新版本";

	/**
	 * 有版本更新
	 */
	public static final String HAVE_NEW_VERSION = "检测到最新版";

	/**
	 * 公共的对象
	 */
	public static final Object OBJECT = new Object();

	/**
	 * 为空值的 公共的对象
	 */
	public static final Object NULL_OBJECT = null;
}