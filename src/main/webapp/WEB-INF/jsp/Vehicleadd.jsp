<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/4
  Time: 14:24
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
    <form class="layui-form">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">驾驶员</label>
                <div class="layui-input-inline">
                    <input type="test" name="name" lay-verify="title" autocomplete="off" placeholder="姓名"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车牌号</label>
                <div class="layui-input-inline">
                    <input type="text" name="vehiclenumber" lay-verify="title" autocomplete="off" placeholder="车牌号"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车的最大载量</label>
                <div class="layui-input-inline">
                    <input type="text" name="maximumload" lay-verify="title" autocomplete="off" placeholder="数值"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">运输价格</label>
                <div class="layui-input-inline">
                    <input type="text" name="price" class="layui-input test-item" placeholder="运输价格">
                </div>
            </div>
            <%--<div class="layui-inline">
                <label class="layui-form-label">车辆类型</label>
                <div class="layui-input-inline">
                    <input type="text" name="type" class="layui-input test-item" placeholder="车辆类型">
                </div>
            </div>--%>
            <div class="layui-form" lay-filter="">
                <div class="layui-form-item">
                    <label class="layui-form-label">车辆类型</label>
                    <div class="layui-input-inline">
                        <select name="type" lay-verify="required" lay-search="">
                            <option value="1">泵车</option>
                            <option value="2">搅拌车10方</option>
                            <option value="3">搅拌车15方</option>
                            <option value="4">搅拌车20方</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
           <%-- <div class="layui-inline">
                <label class="layui-form-label">车辆状态</label>
                <div class="layui-input-block">
                    <input type="text" name="state" lay-verify="title" autocomplete="off" placeholder="车辆状态"
                           class="layui-input">
                </div>
            </div>--%>
            <div class="layui-form" lay-filter="">
                <div class="layui-form-item">
                    <label class="layui-form-label">车辆状态</label>
                    <div class="layui-input-inline">
                        <select name="state" lay-verify="required" lay-search="">
                            <option value="1">空闲</option>
                            <option value="0">出车</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , $ = layui.$;
        form.render();
        //日期时间选择器
        laydate.render({
            elem: '#test5'
            , eventElem: '#test5-1'
            , trigger: 'click'
        });

        //日期时间选择器
        laydate.render({
            elem: '#test6'
            , eventElem: '#test6-1'
            , trigger: 'click'
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            console.log(data.field);
            $.ajax({
                url: "http://localhost:8080/concrete/vehicle/addVehicle",
                type: "POST",
                data: data.field,
                success: function (msg) {
                    if (msg != null) {
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        window.parent.location.reload();
                    } else {
                        layer.msg("添加失败", {icon: 5});
                    }
                }
            });
            return false;
        });

    });
</script>
</html>