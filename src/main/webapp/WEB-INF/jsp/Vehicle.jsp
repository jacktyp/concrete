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
    <script src="/layui/jquery.min.js"></script>
</head>
<body>
<div class="layui-fluid">
    <h2 style="color:#000000;padding: 10px">车辆管理</h2>
    <div class="layui-card">
        <div class="layui-card-body">
            <div class="layui-row layui-col-space10" style="height: 100px ">
                <div class="layui-col-md3 layui-bg-blue" style="height: 100px ;text-align:center;padding: 20px">
                    <h1 style="color: #e1edf7"><span id="vehicleCount0"></span></h1>
                    <p>泵车/辆</p>
                </div>
                <div class="layui-col-md3 layui-bg-cyan" style="height: 100px ;text-align:center;padding: 20px">
                    <a href="#" style="color: #e1edf7">
                        <h1 id="count2"><span id="vehicleCount1"></span></h1>
                    </a>
                    <p>搅拌车10方/辆</p>
                </div>
                <div class="layui-col-md3 layui-bg-green" style="height: 100px ;text-align:center;padding: 20px">
                    <a href="#" style="color: #e1edf7">
                        <h1 id="count3"><span id="vehicleCount2"></span></h1>
                    </a>
                    <p>搅拌车15方/辆</p>
                </div>
                <div class="layui-col-md3 layui-bg-orange" style="height: 100px ;text-align:center;padding: 20px">
                    <a href="#" style="color: #e1edf7">
                        <h1 id="count4"><span id="vehicleCount3"></span></h1>
                    </a>
                    <p>搅拌车20方/辆</p>
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
        <button type="button" onclick="addtest();" class="layui-btn layui-btn-sm"><i class="layui-icon layui-icon-add-1">增加车辆</i></button>
    </div>
</script>
<script type="text/html" id="vehbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-xs layui-bg-orange" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script type="text/html" id="buttonTpl">
    {{#  if(d.state == 1){ }}
    <button class="layui-btn layui-btn-xs">空闲</button>
    {{#  } else { }}
    <button class="layui-btn layui-btn-primary layui-btn-xs">已出车</button>
    {{#  } }}
</script>
<script type="text/javascript">
    function addtest() {
        layer.open({
            title:'添加车辆',
            type: 2,
            content: 'http://localhost:8080/concrete/page/Vehicleadd',
            area: ['1000px', '400px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset: ['10px', '20px']
        })
    }
</script>
<script>
    var vehicleName = new Array(), vehicleCount = new Array();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/concrete/vehicle/selectVehicle",
        async: false,
        success: function (data1) {
            //console.log(data1);
            var obj = data1["msg"];
            //console.log(obj);
            var obj2 = JSON.parse(obj);
            //console.log(obj2);
            for(var i in obj2){
                //表示遍历数组，而i表示的是数组的下标值，
                //result[i]表示获得第i个json对象即JSONObject
                //result[i]通过.字段名称即可获得指定字段的值
                vehicleName[i] = obj2[i].vehicleName;
                vehicleCount[i] =obj2[i].vehicleCount;
                //console.log("vehicleName="+obj2[i].vehicleName);
                //console.log("vehicleCount="+obj2[i].vehicleCount);
            }
            //console.log("vehicleName1="+vehicleName);
            //console.log("vehicleCount1="+vehicleCount);
            document.getElementById("vehicleCount0").innerText = vehicleCount[0];
            document.getElementById("vehicleCount1").innerText = vehicleCount[1];
            document.getElementById("vehicleCount2").innerText = vehicleCount[2];
            document.getElementById("vehicleCount3").innerText = vehicleCount[3];
        }
    });
    layui.use(['table'], function () {
        var table = layui.table;
        //展示已知数据
        table.render({
            elem: '#veh1'
            ,url: 'http://localhost:8080/concrete/vehicle/findAll'
            ,toolbar: '#vehbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', 'exports']
            ,cols: [[ //标题栏
                {field: 'id', title: 'ID', width: 120, sort: true}
                , {field: 'vehiclenumber', title: '车牌号', width: 120}
                , {field: 'name', title: '驾驶员', width: 160}
                , {field: 'maximumload', title: '车最大载量', width: 120}
                , {field: 'state', title: '车状态', templet: '#buttonTpl', width: 120}
                , {field: 'type', title: '车类型', width: 210}
                , {field: 'price', title: '运输价格', width: 120}
                , {fixed: 'right',title: '操作', width: 280, align: 'center', toolbar: '#vehbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,page: true //开启分页,
        });

        //监听工具条
        table.on('tool(vehfilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('车辆编号：' + data.id + '<br>'
                    +'车牌号：' + data.vehiclenumber + '<br>'
                    +'驾驶员：' + data.name + '<br>'
                    +'车最大载量：' + data.maximumload + '<br>'
                    +'车状态：' + data.state + '<br>'
                    +'车类型：' + data.type + '<br>'
                    +'运输价格：' + data.price + '<br>');
            } else if (obj.event === 'edit') {
                layer.open({
                    title: '车辆信息修改',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Vehiclemodify',
                    area: ['1000px', '400px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['20px', '50px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#vehmodify").click();
                        othis.find('input[name="id"]').val(data.id);
                        othis.find('input[name="vehiclenumber"]').val(data.vehiclenumber);
                        othis.find('input[name="name"]').val(data.name);
                        othis.find('input[name="maximumload"]').val(data.maximumload);
                        othis.find('input[name="state"]').val(data.state);
                        othis.find('input[name="type"]').val(data.type);
                        othis.find('input[name="price"]').val(data.price);
                    }
                });
            } else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/vehicle/deleteVehicle",
                        type: "POST",
                        data: {id:data.id},
                        success: function (msg) {
                            if (msg != null) {
                                //删除这一行
                                obj.del();
                                //关闭弹框
                                layer.close(index);
                                layer.msg("删除成功", {icon: 6});
                            } else {
                                layer.msg("删除失败", {icon: 5});
                            }
                        }
                    });
                    return false;
                });
            }
        });
    });
</script>
</html>
