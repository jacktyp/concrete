<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/3
  Time: 10:02
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
    <h2 style="color:#000000;padding: 20px">运输单添加</h2>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <%--<div class="layui-inline">
                    <label class="layui-form-label">车辆编号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="vehicleId" lay-verify="title" autocomplete="off" placeholder="车辆id³"
                               class="layui-input">
                    </div>
                </div>--%>
                <div class="layui-form" lay-filter="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">车辆编号</label>
                        <div class="layui-input-inline">
                            <select name="vehicleId" lay-verify="required" lay-search="" lay-filter="vehicleId"  id="vehicleId">
                                <option value="">选择车辆</option>
                                <%--<option value="1">空闲</option>
                                <option value="0">出车</option>--%>
                            </select>
                        </div>
                    </div>
                </div>
               <%-- <div class="layui-inline">
                    <label class="layui-form-label">合同编号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="contractId" lay-verify="title" autocomplete="off" placeholder="合同id³"
                               class="layui-input">
                    </div>
                </div>--%>
            </div>

           <%-- <div class="layui-inline">
                <label class="layui-form-label">车载量</label>
                <div class="layui-input-inline">
                    <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>--%>
            <div class="layui-inline">
                <label class="layui-form-label">发车时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="time" lay-verify="title" id="test5" autocomplete="off" placeholder="yyyy-MM-dd"
                           class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">

            <div class="layui-inline">
                <label class="layui-form-label">运输表登记人</label>
                <div class="layui-input-inline">
                    <input type="text" name="registrant" lay-verify="title" autocomplete="off" placeholder="录入人姓名"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">运输表登记时间</label>
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
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/layui.all.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , $ = layui.$;

        layui.$.ajax({ // 使用layui模块化加载
            url: "http://localhost:8080/concrete/vehicle/findAll",
            type: 'GET',
            async: false,
            success: function(data1) {
                //console.log("data1"+data1);
                var data = data1.data;
                var selects='';
                for(var b in data){
                    //console.log("id="+data[b].id);
                    var  its='<option value="'+data[b].id+'">'+"车辆编号"+data[b].id+";"+"车最大载量"+data[b].maximumload+'</option>';
                    selects +=its;
                }
                $("#vehicleId").append(selects);
                form.render();//菜单渲染 把内容加载进去
            }
        });
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
        });
        //监听提交
        form.on('submit(demo1)', function(data){
            /*console.log(data.field);*/
            $.ajax({
                url: "http://localhost:8080/concrete/transportation/addTransportDTO",
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

</body>
</html>