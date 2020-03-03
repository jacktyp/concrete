<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/2
  Time: 13:31
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
    <form class="layui-form" action="/concrete/user1/addUser" method="post">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">合同编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="contractId" lay-verify="title" autocomplete="off" placeholder=""
                           class="layui-input">
                </div>
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">混凝土计划需求量</label>
                <div class="layui-input-inline">
                    <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">混凝土强度等级</label>
                <div class="layui-input-inline">
                    <%--<input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="如：A15、A20、C10、C15..."
                           class="layui-input">--%>
                    <select name="modules" lay-verify="title" lay-search="">
                        <option value="">直接选择或搜索选择</option>
                        <option value="1">A10</option>
                        <option value="2">A12</option>
                        <option value="3">A20</option>
                        <option value="5">C15</option>
                        <option value="6">C20</option>
                        <option value="7">C25</option>
                        <option value="8">C30</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">通知单添加人</label>
                <div class="layui-input-inline">
                    <input type="text" name="registrant" lay-verify="title" autocomplete="off" placeholder="录入人姓名"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">通知单添加日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="registranttime" class="layui-input test-item" id="test6"
                           placeholder="yyyy-MM-dd HH:mm:ss">
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
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期时间选择器
        laydate.render({
            elem: '#test5'
            , eventElem: '#test5-1'
            , trigger: 'click'
            //,lang: 'en'
        });

        //日期时间选择器
        laydate.render({
            elem: '#test6'
            , eventElem: '#test6-1'
            , trigger: 'click'
            //,lang: 'en'
        });
    });
</script>

</html>