<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/3/1
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>搅拌站业务流程系统</title>
    <meta name="renderer" content="webkit">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layui/style/admin.css">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/layui/layui.all.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改账户</div>
                <div class="layui-card-body" pad15>
                    <form class="layui-form" action="" method="post" id="accmodify">
                        <div class="layui-form" lay-filter="">
                            <div class="layui-form-item">
                                <label class="layui-form-label">id</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="id"  lay-verify="title" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">用户类型</label>
                                <div class="layui-input-inline">
                                    <select name="userType" lay-verify="">
                                        <option value="1" selected>超级管理员</option>
                                        <option value="2" disabled>普通管理员</option>
                                    </select>
                                </div>
                                <div class="layui-form-mid layui-word-aux">当前角色不可更改为其它角色</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userName"  lay-verify="title" autocomplete="off"class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">真实姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="realname" lay-verify="title" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">请填写务必真实姓名!!!</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">手机</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userTelephone" value="" lay-verify="phone" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">用户职位信息</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userPostion" lay-verify="title" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="setmyinfo">确认</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重新填写</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>

</html>