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
    <script src="/layui/jquery.min.js"></script>
</head>
<body>
<div class="layui-fluid" id="noticeadd" >
    <form class="layui-form" action="/concrete/user1/addUser" method="post" lay-filter="formTest">
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
                <label class="layui-form-label">混凝土需求量</label>
                <div class="layui-input-inline">
                    <input type="text" name="concreteamount" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">混凝土强度等级</label>
                <div class="layui-input-inline">
                    <input type="text" name="mixproportionId" lay-verify="title" autocomplete="off" placeholder="如：C20、C25..."
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">石头总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="stoneamount" lay-verify="title" autocomplete="off" placeholder="kg"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">沙子总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="sandamount" lay-verify="title" autocomplete="off" placeholder="kg"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">水泥总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="cementamount" lay-verify="title" autocomplete="off" placeholder="kg"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">添加剂总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="additiveamount" lay-verify="title" autocomplete="off" placeholder="kg"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">水总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="wateramount" lay-verify="title" autocomplete="off" placeholder="kg"
                           class="layui-input">
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
                           placeholder="yyyy-MM-dd">
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
        });

        //日期时间选择器
        laydate.render({
            elem: '#test6'
            , eventElem: '#test6-1'
            , trigger: 'click'
        });
        //监听提交
        form.on('submit(demo1)', function(data){
            $.ajax({
                url: "http://localhost:8080/concrete/notification/addNotification",
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

        /*var mixproportionId = data.field.mixproportionId;
        //var mixproportionId2=Request.Form("mixproportionId");
        //var mixproportionId2 = Ext.get('mixproportionId');
        console.log("mixproportionId2="+mixproportionId);
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/concrete/mixproportion/selectMixproportion",
            data:  {id:mixproportionId},
            async: false,
            success: function(data1){
                console.log(data1);
            }
        });*/
    });
</script>

</html>