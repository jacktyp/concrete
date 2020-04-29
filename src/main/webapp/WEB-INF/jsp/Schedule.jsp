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
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layui/style/admin.css">
    <script src="/layui/echarts.min.js"></script>
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/layui/layui.all.js" charset="utf-8"></script>
    <script src="/layui/jquery.min.js"></script>
</head>
<body>
<div class="layui-fluid">
    <h2 style="color:#000000;padding: 10px">生产计划</h2>
    <div class="layui-card">
        <div class="layui-card-body">
            <div class="layui-row">
                <div class="layui-col-sm6">
                    <div id="Sechart1" style="width: 620px;height:275px;"></div>
                </div>
                <div class="layui-col-sm6">
                    <div id="Sechart2" style="width: 620px;height:275px;"></div>
                </div>
            </div>
        </div>
        <hr class="layui-bg-gray">
        <div class="layui-card-body">
            <table class="layui-hide" id="sche1" lay-filter="sche2"></table>
        </div>
    </div>

</div>
</body>
<script type="text/html" id="schbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-xs layui-bg-blue" lay-event="add"><i class="layui-icon layui-icon-add-circle"></i>添加生产计划</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i
            class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script type="text/html" id="buttonTpl">
    {{#  if(d.remark == 1){ }}
    <button class="layui-btn layui-btn-xs">完成</button>
    {{#  } else { }}
    <button class="layui-btn layui-btn-primary layui-btn-xs">未完成</button>
    {{#  } }}
</script>
<script>
    layui.config({
        base: '/static/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'console']);
    var stone, sand, cement, additive, vehicleName = new Array(), vehicleCount = new Array();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/concrete/material/selectMaterial",
        async: false,
        success: function (data) {
            //console.log(data);
            var obj = data["msg"];
            //console.log(obj);
            var obj2 = JSON.parse(obj);
            //console.log(obj2);
            sand = obj2["sand"];
            stone = obj2["stone"];
            cement = obj2["cement"];
            additive = obj2["additive"];
            //console.log(stone+"  "+sand+"  "+cement+"  "+additive);
        }
    });
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
        }
    });
    var Sechart1 = echarts.init(document.getElementById('Sechart1'));
    var option1 = {
        title: {
            text: '原材料的剩余量'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data: ['石子', '沙', '水泥', '添加剂']
        },
        xAxis: [
            {
                type: 'category',
                data: [''],
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '剩余量/10t'
            }
        ],
        series: [
            {
                name: '石子',
                type: 'bar',
                data: [stone/10000]
            },
            {
                name: '沙',
                type: 'bar',
                data: [sand/10000]
            },
            {
                name: '水泥',
                type: 'bar',
                data: [cement/10000]
            },
            {
                name: '添加剂',
                type: 'bar',
                data: [additive/10000]
            }
        ]

    };
    Sechart1.setOption(option1);

    var Sechart2 = echarts.init(document.getElementById('Sechart2'));
    var option2 = {
        title: {
            text: '车辆剩余量'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data: ['车型1', '车型2', '车型3', '车型4']
        },
        xAxis: [
            {
                type: 'category',
                data: [''],
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '数量/辆'
            }
        ],
        series: [
            {
                name: '车型1',
                type: 'bar',
                data: [vehicleCount[0]]
            },
            {
                name: '车型2',
                type: 'bar',
                data: [vehicleCount[1]]
            },
            {
                name: '车型3',
                type: 'bar',
                data: [vehicleCount[2]]
            },
            {
                name: '车型4',
                type: 'bar',
                data: [vehicleCount[3]]
            }
        ]

    };
    Sechart2.setOption(option2);

    layui.use(['table'], function () {
        var table = layui.table;

//展示已知数据
        table.render({
            elem: '#sche1'
            , url: 'http://localhost:8080/concrete/notification/findAllNotificationByState'
            //, toolbar: '#notbar1' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'print', 'exports']
            , cols: [[ //标题栏
                {field: 'id', title: '通知单编号', width: 120, rowspan: 2, sort: true}
                , {field: 'contractId', title: '合同编号', width: 120, rowspan: 2, sort: true}
                , {field: 'mixproportionId', title: '状态',templet: '#buttonTpl', width: 120, rowspan: 2}
                , {field: 'concreteamount', title: '混凝土总量\m³', width: 100}
                , {field: 'stoneamount', title: '所需石头总量\kg', width: 100}
                , {field: 'sandamount', title: '所需沙子总量\kg', width: 100}
                , {field: 'cementamount', title: '所需水泥总量\kg', width: 100}
                , {field: 'wateramount', title: '所需水总量\kg', width: 100}
                , {field: 'additiveamount', title: '所需添加剂总量\kg', width: 100}

                , {field: 'registrant', title: '通知单登记人', width: 120, rowspan: 2}
                , {field: 'registranttime', title: '通知单登记日期', width: 210, rowspan: 2}
                , {fixed: 'right', title: '操作', width: 300, rowspan: 2, align: 'center', toolbar: '#schbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            , id: 'testReload'
            , page: true //开启分页,
            , limit: 10
        });

//监听工具条
        table.on('tool(sche2)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('通知单编号：' + data.id + '<br>'
                    + '混凝土总量：' + data.concreteamount + '<br>'
                    + '所需石头总量：' + data.stoneamount + '<br>'
                    + '所需沙子总量：' + data.sandamount + '<br>'
                    + '所需水泥总量：' + data.cementamount + '<br>'
                    + '所需水总量：' + data.wateramount + '<br>'
                    + '所需添加剂总量：' + data.additiveamount + '<br>'
                    + '通知单登记人：' + data.registrant + '<br>'
                    + '通知单登记日期：' + data.registranttime + '<br>');
            } else if (obj.event === 'add') {
                layer.msg('ID：' + data.Contract_id + ' 的查看操作');
                layer.open({
                    title: '添加生产计划',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Scheduleadd',
                    area: ['1000px', '620px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['20px', '50px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#scheduleadd1").click();
                        othis.find('input[name="contractId"]').val(data.contractId);
                        othis.find('input[name="notificationId"]').val(data.id);
                    }
                });
            } else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/notification/deleteNotification",
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
