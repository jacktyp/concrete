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

<script type="text/html" id="schbar1">
    <div class="search1">
        搜索ID：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
</script>
<script type="text/html" id="schbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="add">添加生产计划</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
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
            data: ['石子', '沙','水泥','添加剂']
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
                name: '剩余量/m³'
            }
        ],
        series: [
            {
                name: '石子',
                type: 'bar',
                data: [1000]
            },
            {
                name: '沙',
                type: 'bar',
                data: [2000]
            },
            {
                name: '水泥',
                type: 'bar',
                data: [2000]
            },
            {
                name: '添加剂',
                type: 'bar',
                data: [100]
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
            data: ['车型1', '车型2', '车型3', '车型4' ]
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
                name: '数量'
            }
        ],
        series: [
            {
                name: '车型1',
                type: 'bar',
                data: [10]
            },
            {
                name: '车型2',
                type: 'bar',
                data: [2]
            },
            {
                name: '车型3',
                type: 'bar',
                data: [50]
            },
            {
                name: '车型4',
                type: 'bar',
                data: [30]
            }
        ]

    };
    Sechart2.setOption(option2);

    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#sche1'
            , url: '/test/testdata1.json'
            , toolbar: '#schbar1' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }]
            , method: 'post'
            , request: {
                pageName: 'page' //页码的参数名称，默认：page
                , limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            , cols: [[ //标题栏
                {field: 'id', title: '通知单编号', width: 120, rowspan: 2, sort: true}
                , {field: 'contractId', title: '合同编号', width: 120, rowspan: 2, sort: true}
                , {field: 'mixproportionId', title: '配合比编号', width: 120, rowspan: 2, sort: true}
                , {field: 'Notification_stoneamount', title: '所需石头总量\kg', width: 100}
                , {field: 'Notification_sandamount', title: '所需沙子总量\kg', width: 100}
                , {field: 'Notification_cementamount', title: '所需水泥总量\kg', width: 100}
                , {field: 'Notification_wateramount', title: '所需水总量\kg', width: 100}
                , {field: 'Notification_additiveamount', title: '所需添加剂总量\kg', width: 100}
                , {fixed: 'right', title: '操作', width: 240, rowspan: 2, align: 'center', toolbar: '#schbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,id: 'testReload'
            , page: true //开启分页,
            , limit: 10
        });
        //搜素
        var $ = layui.$, active  = {
            reload: function(){
                var demoReload = $('#demoReload');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        key: {
                            id: demoReload.val()
                        }
                    }
                }, 'data');
            }
        };
        $('.search1 .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //监听工具条
        table.on('tool(sche2)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.Contract_id + ' 的查看操作');
            } else if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
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
                    offset:['20px', '50px']
                });
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
