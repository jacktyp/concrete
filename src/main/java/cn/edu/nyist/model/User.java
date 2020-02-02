package cn.edu.nyist.model;

public class User {
    /**
     *  id
     */
    private Integer id;

    /**
     *  用户名
     */
    private String userName;

    /**
     *  用户密码
     */
    private String userPassword;

    /**
     *  用户类型
     */
    private String userType;

    /**
     *  真实姓名
     */
    private String realname;

    /**
     *  手机电话
     */
    private String userTelephone;

    /**
     *  是否在线（0/1）
     */
    private String userState;

    /**
     *  用户职位信息
     */
    private String userPostion;

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return user_password 
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param userPassword 
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return user_type 
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param userType 
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return realname 
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param realname 
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return user_telephone 
     */
    public String getUserTelephone() {
        return userTelephone;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param userTelephone 
     */
    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone == null ? null : userTelephone.trim();
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return user_state 
     */
    public String getUserState() {
        return userState;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param userState 
     */
    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @return user_postion 
     */
    public String getUserPostion() {
        return userPostion;
    }

    /**
     * 
     * @author typ
     * @date 2020-02-02 11:57:09
     * @param userPostion 
     */
    public void setUserPostion(String userPostion) {
        this.userPostion = userPostion == null ? null : userPostion.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                ", realname='" + realname + '\'' +
                ", userTelephone='" + userTelephone + '\'' +
                ", userState='" + userState + '\'' +
                ", userPostion='" + userPostion + '\'' +
                '}';
    }
}