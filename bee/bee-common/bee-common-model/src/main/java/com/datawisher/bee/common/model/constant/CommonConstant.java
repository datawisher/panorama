package com.datawisher.bee.common.model.constant;

public class CommonConstant {

	/**
	 * 正常状态
	 */
	public static final Integer STATUS_NORMAL = 0;

	/**
	 * 禁用状态
	 */
	public static final int STATUS_DISABLE = 1;

	/**
	 * 锁定状态
	 */
	public static final int STATUS_LOCKED = 2;

	/**
	 * 未删除
	 */
	public static final int DEL_NO = 0;

    /**
     * 已删除
     */
    public static final int DEL_YES = 1;

	/**
	 * 系统日志类型： 登录
	 */
	public static final int LOG_TYPE_1 = 1;
	
	/**
	 * 系统日志类型： 操作
	 */
	public static final int LOG_TYPE_2 = 2;

	/**
	 * 操作日志类型： 查询
	 */
	public static final int OPERATE_TYPE_1 = 1;
	
	/**
	 * 操作日志类型： 添加
	 */
	public static final int OPERATE_TYPE_2 = 2;
	
	/**
	 * 操作日志类型： 更新
	 */
	public static final int OPERATE_TYPE_3 = 3;
	
	/**
	 * 操作日志类型： 删除
	 */
	public static final int OPERATE_TYPE_4 = 4;
	
	/**
	 * 操作日志类型： 导入
	 */
	public static final int OPERATE_TYPE_5 = 5;
	
	/**
	 * 操作日志类型： 导出
	 */
	public static final int OPERATE_TYPE_6 = 6;

    /**
     *  返回值正确code
     */
    public static final int CODE_OK_0 = 0;
    /**
     *  返回值错误code（未定义错误）
     */
    public static final int CODE_ERROR_1 = 1;

    /**
     *  返回系统code错误码
     */
    public static final int CODE_SERVER_500 = 500;

	/**
	 * 返回业务code错误码
	 */
	public static final int CODE_BIZ_10000 = 10000;
	public static final int CODE_BIZ_20000 = 20000;
	public static final int CODE_BIZ_30000 = 30000;

	/**
     *  0：一级菜单
     */
    public static final Integer MENU_TYPE_0  = 0;
   /**
    *  1：子菜单 
    */
    public static final Integer MENU_TYPE_1  = 1;
    /**
     *  2：按钮权限
     */
    public static final Integer MENU_TYPE_2  = 2;

}
