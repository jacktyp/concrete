<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>搅拌站业务流程系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layui/style/admin.css">
    <link rel="stylesheet" href="/layui/style/login.css" media="all">
    <script src="/layui/layui.js"></script>
    <script src="/layui/lib/admin.js"></script>
    <script src="/layui/lib/index.js"></script>
</head>
<body>
<form action="">
<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>搅拌站业务流程系统</h2>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username" <%--for="LAY-user-login-username"--%>></label>
                <input type="text" name="userName" lay-verify="required" placeholder="用户名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password"<%-- for="LAY-user-login-password"--%>></label>
                <input type="password" name="userPassword" lay-verify="required" placeholder="密码" class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="layui-row">
                    <div class="layui-col-xs7">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                        <input type="text" name="" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
                    </div>
                    <div class="layui-col-xs5">
                        <div style="margin-left: 10px;">
                            <img src="https://www.oschina.net/action/user/captcha" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="demo1">登 入</button>
            </div>
            <div class="layui-row">
                <div class="layui-col-md6" style="text-align: left">
                    <a href="forget.jsp" class="layadmin-link" style="margin-top: 7px;">忘记密码？</a>
                </div>
                <div class="layui-col-md6" style="text-align: right">
                    <a href="reg.jsp" class="layadmin-user-jump-change layadmin-link">注册帐号</a>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-trans layadmin-user-login-footer">
        <p>© 2020 搅拌站业务流程系统</p>
    </div>
  <%--  <a href="/concrete/page/Functionalpage">授权管理</a></dd>
    <a href="/concrete/page/Functionalpage1">授权管理1</a></dd>
    <a href="/concrete/page/Functionalpage2">授权管理2</a></dd>
    <a href="/concrete/page/Functionalpage3">授权管理3</a></dd>
    <a href="/concrete/page/Functionalpage4">授权管理4</a></dd>--%>
</div>
</form>
</body>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , $ = layui.$;
    //form.render();
    //监听提交
    form.on('submit(demo1)', function(data){
        //layer.msg(JSON.stringify(data.field));
        console.log(JSON.stringify(data.field));
        $.ajax({
            url: "http://localhost:8080/concrete/user/login",
            type: "POST",
            data: data.field,
            success: function (data) {
                console.log("data"+data);
                var msg = data.msg;
                console.log("msg"+msg);
                if (msg == "1") {
                    /*var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭
                    window.parent.location.reload();*/
                    layer.msg('登入成功1', {
                        offset: '15px'
                        //,icon: 5
                        ,time: 5000
                        ,btn: ['明白了', '知道了', '哦']
                    });
                    layer.confirm('登入成功1？');
                    window.location = "http://localhost:8080/concrete/page/Functionalpage"
                }else if(msg == "2"){
                    layer.msg('登入成功2', {
                        offset: '15px'
                        //,icon: 5
                        ,time: 5000
                        ,btn: ['明白了', '知道了', '哦']
                    });
                   // layer.confirm('登入成功2？');
                    window.location = "http://localhost:8080/concrete/page/Functionalpage"
                } else if(msg == "3"){
                    layer.msg('登入成功3', {
                        offset: '15px'
                        //,icon: 5
                        ,time: 5000
                        ,btn: ['明白了', '知道了', '哦']
                    });
                    layer.confirm('登入成功3？');
                    window.location = "http://localhost:8080/concrete/page/Functionalpage"
                }else if(msg == "4"){
                    layer.msg('登入成功4', {
                        offset: '15px'
                        //,icon: 5
                        ,time: 5000
                        ,btn: ['明白了', '知道了', '哦']
                    });
                    layer.confirm('登入成功4？');
                    window.location = "http://localhost:8080/concrete/page/Functionalpage"
                }else{
                    layer.msg("登录失败", {
                        icon: 5
                        ,time: 5000
                        ,btn: ['明白了', '知道了', '哦']
                    });
                    //layer.confirm('登录失败？');
                    window.location = "http://localhost:8080/"
                }
            }
        });
        return false;
    });
    })

</script>
</html>
