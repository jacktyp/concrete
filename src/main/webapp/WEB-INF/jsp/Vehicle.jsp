<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/3
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/layui/layui.all.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-fluid">
    <h2 style="color:#000000;padding: 10px">车辆管理</h2>
    <div class="layui-card">
        <div class="layui-card-body">
            <div class="layui-row layui-col-space10" style="height: 100px ">
                <div class="layui-col-md3 layui-bg-blue" style="height: 100px ;text-align:center;padding: 20px">
                    <h1 style="color: #e1edf7">10</h1>
                    <p>车辆类型1/辆</p>
                </div>
                <div class="layui-col-md3 layui-bg-cyan" style="height: 100px ;text-align:center;padding: 20px">
                    <a href="#" style="color: #e1edf7">
                        <h1 id="count2">1</h1>
                    </a>
                    <p>车辆类型2/辆</p>
                </div>
                <div class="layui-col-md3 layui-bg-green" style="height: 100px ;text-align:center;padding: 20px">
                    <a href="#" style="color: #e1edf7">
                        <h1 id="count3">50</h1>
                    </a>
                    <p>车辆类型3/辆</p>
                </div>
                <div class="layui-col-md3 layui-bg-orange" style="height: 100px ;text-align:center;padding: 20px">
                    <a href="#" style="color: #e1edf7">
                        <h1 id="count4">0</h1>
                    </a>
                    <p>车辆类型4/辆</p>
                </div>
            </div>
        </div>
        <hr class="layui-bg-gray">
        <div class="layui-card-body">
            <table class="layui-hide" id="veh1" lay-filter="vehfilter1"></table>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="vehbar1">
    <div class="search1">
        搜索ID：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
        <button type="button" onclick="addtest();" class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
    </div>
</script>
<script type="text/html" id="vehbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    function addtest() {
        layer.open({
            type: 2,
            content: 'http://localhost:8080/concrete/user/Vehicleadd',
            area: ['1200px', '600px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset: 'lt'
        })
    }
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#veh1'
            ,url: '/test/testdata1.json'
            //,count: total//数据总数，从服务端得到
            ,toolbar: '#vehbar1' //开启头部工具栏，并为其绑定左侧模板
            ,method: 'post'
            ,request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            ,cols: [[ //标题栏
                {field: 'Vehicle_id', title: '车辆编号', width: 120, sort: true}
                , {field: 'Vehicle_vehiclenumber', title: '车牌号', width: 120}
                , {field: 'Vehicle_name', title: '驾驶员', width: 160}
                , {field: 'Vehicle_maximumload', title: '车最大载量', width: 120}

                , {field: 'Vehicle_state', title: '车状态', width: 120}
                , {field: 'Vehicle_type', title: '车类型', width: 210}
                , {field: 'Vehicle_price', title: '运输价格', width: 120}
                , {fixed: 'right',title: '操作', width: 280, align: 'center', toolbar: '#vehbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,page: true //开启分页,
        });

        //监听工具条
        table.on('tool(vehfilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.Contract_id + ' 的查看操作');
            } else if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });
    });
</script>
</html>
