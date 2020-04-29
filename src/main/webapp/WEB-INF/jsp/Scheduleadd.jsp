<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/4
  Time: 14:37
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
<div class="layui-fluid" id="scheduleadd1">
    <form class="layui-form">
        <div class="layui-form-item">
            <input type="hidden" name="notificationId" lay-verify="title" autocomplete="off" placeholder="通知表编号"
                   class="layui-input">
            <input type="hidden" name="contractId" lay-verify="title" autocomplete="off" placeholder="合同表编号"
                   class="layui-input">
            <input type="hidden" name="time" lay-verify="title" autocomplete="off" placeholder="请填写分钟数" value="20"
                   class="layui-input">
            <%--<div class="layui-inline">
                <label class="layui-form-label">通知表编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="notificationId" lay-verify="title" autocomplete="off" placeholder="通知表编号"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">合同表编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="contractId" lay-verify="title" autocomplete="off" placeholder="合同表编号"
                           class="layui-input">
                </div>
            </div>--%>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">生产计划名</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入生产计划名"
                           class="layui-input">
                </div>
            </div>
        </div>
        <%-- <div class="layui-form-item">
             <div class="layui-inline">
                 <label class="layui-form-label">计划生产所需车辆编号</label>
                 <div class="layui-input-inline">
                     <input type="text" name="vehicleId" lay-verify="title" autocomplete="off" placeholder="计划生产所需车辆编号"
                            class="layui-input">
                 </div>
             </div>
         </div>--%>

        <div class="layui-form-item">
            <%--<div class="layui-inline">
                <label class="layui-form-label">计划生产所需总时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="time" lay-verify="title" autocomplete="off" placeholder="请填写分钟数"
                           class="layui-input">
                </div>
            </div>--%>
            <div class="layui-inline">
                <label class="layui-form-label">计划生产开始时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="productiontime" lay-verify="title" autocomplete="off" id="test5"
                           placeholder="yyyy-MM-dd"
                           class="layui-input">
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">计划生产结束时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="endtiime" lay-verify="title" autocomplete="off" id="test6"
                               placeholder="yyyy-MM-dd"
                               class="layui-input">
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">生产计划添加人</label>
                <div class="layui-input-inline">
                    <input type="text" name="registrant" lay-verify="title" autocomplete="off" placeholder="录入人姓名"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">生产计划添加日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="registranttime" class="layui-input test-item" id="test7" placeholder="yyyy-MM-dd">
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
        //日期时间选择器
        laydate.render({
            elem: '#test7'
            , eventElem: '#test7-1'
            , trigger: 'click'
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            console.log(data.field);
            $.ajax({
                url: "http://localhost:8080/concrete/schedule/addScheduleDTO",
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