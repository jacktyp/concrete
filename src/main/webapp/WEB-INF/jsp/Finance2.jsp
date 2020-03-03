<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/25
  Time: 10:41
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
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/layui/style/admin.css">
    <script src="/layui/echarts.min.js"></script>
    <script src="/layui/layui.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-col-sm12">
        <div class="layui-card">
            <div class="layui-card-header">
                各类财务表
            </div>
            <div class="layui-card-body">
                <div class="layui-row layui-col-space10">
                    <div class="layui-col-sm4">
                        <table class="layui-hide" id="fin1" lay-filter="finfilter1"></table>
                    </div>
                    <div class="layui-col-sm4">
                        <table class="layui-hide" id="fin2" lay-filter="finfilter2"></table>
                    </div>
                    <div class="layui-col-sm4">
                        <table class="layui-hide" id="fin3" lay-filter="finfilter3"></table>
                    </div>
                </div>
            </div>
            <div class="layui-card-header">
                财务统计表
            </div>
            <div class="layui-card-body">
                <div class="layui-row">
                    <div class="layui-col-sm12">
                        <table class="layui-hide" id="fin4" lay-filter="finfilter4"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="finbar1">
    <div>原材料支出表</div>
</script>
<script type="text/html" id="finbar2">
    <div>车辆费用支出表</div>
</script>
<script type="text/html" id="finbar3">
    <div>混凝土收入表</div>
</script>
<script type="text/html" id="finbar4">
    <div>财务统计表</div>
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;
        //原材料支出表
        table.render({
            elem: '#fin1'
            //,url: '/test/testdata1.json'
            //,count: total//数据总数，从服务端得到
            ,toolbar: '#finbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,cols: [[ //标题栏
                {field: 'Schedule_id', title: 'ID'}
                , {field: 'Schedule_name', title: '日期'}
                , {field: 'Schedule_state', title: '类型', }
                , {field: 'Mixproportion_concretegrade', title: '支出金额'}
            ]]
            ,data:[{
                "Schedule_id":"1"
                ,"Schedule_name":"1"
                ,"Schedule_state":"1"
                ,"Mixproportion_concretegrade":"1"
            }]
            ,page: true //开启分页,
        });

        //车辆费用支出表
        table.render({
            elem: '#fin2'
            //,url: '/test/testdata1.json'
            //,count: total//数据总数，从服务端得到
            ,toolbar: '#finbar2' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,cols: [[ //标题栏
                {field: 'Schedule_id', title: 'ID'}
                , {field: 'Schedule_name', title: '日期'}
                , {field: 'Schedule_state', title: '类型', }
                , {field: 'Mixproportion_concretegrade', title: '支出金额'}
            ]]
            ,data:[{
                "Schedule_id":"1"
                ,"Schedule_name":"1"
                ,"Schedule_state":"1"
                ,"Mixproportion_concretegrade":"1"
            }]
            ,page: true //开启分页,
        });

        //混凝土收入表
        table.render({
            elem: '#fin3'
            //,url: '/test/testdata1.json'
            //,count: total//数据总数，从服务端得到
            ,toolbar: '#finbar3' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,cols: [[ //标题栏
                {field: 'Schedule_id', title: 'ID'}
                , {field: 'Schedule_name', title: '日期'}
                , {field: 'Mixproportion_concretegrade', title: '支出金额'}
            ]]
            ,data:[{
                "Schedule_id":"1"
                ,"Schedule_name":"1"
                ,"Mixproportion_concretegrade":"1"
            }]
            ,page: true //开启分页,
        });

        //财务统计表
        table.render({
            elem: '#fin4'
            //,url: '/test/testdata1.json'
            //,count: total//数据总数，从服务端得到
            ,toolbar: '#finbar4' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,cols: [[ //标题栏
                {field: 'Schedule_id', title: 'ID'}
                , {field: 'Schedule_name', title: '日期'}
                , {field: 'Mixproportion_concretegrade', title: '利润'}
                , {field: '3', title: '收入'}
                , {field: '4', title: '支出'}
            ]]
            ,data:[{
                "Schedule_id":"1"
                ,"Schedule_name":"1"
                ,"Mixproportion_concretegrade":"1"
                ,"3":"1"
                ,"4":"1"
            }]
            ,page: true //开启分页,
        });

    })
</script>
</html>
