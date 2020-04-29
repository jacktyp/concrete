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
    <script src="/layui/jquery.min.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-col-sm12">
        <div class="layui-card">
            <div class="layui-card-header">
                财务支出统计图
            </div>
            <div class="layui-card-body">
                <div class="layui-row">
                    <div class="layui-col-sm6">
                        <div id="fechart1" style="width: 600px;height:235px;"></div>
                    </div>
                    <div class="layui-col-sm6">
                        <div id="fechart2" style="width: 600px;height:235px;"></div>
                    </div>
                </div>
            </div>
            <div class="layui-card-header">
                财务统计图
            </div>
            <div class="layui-card-body">
                <div class="layui-row">
                    <div class="layui-col-sm12">
                        <div id="fechart3" style="width: 1200px;height:535px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.config({
        base: '/static/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'console']);

    var date,listState1,listState2,listState3,listState4;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/concrete/procure/selectProcure",
        async: false,
        success: function(data){
            //console.log(data);
            var obj = data["msg"];
           // console.log(obj);
            var obj2 = JSON.parse(obj);
            //console.log(obj2);
            date = obj2["listData"];
            listState1 = obj2["listState1"];
            listState2 = obj2["listState2"];
            listState3 = obj2["listState3"];
            listState4 = obj2["listState4"];
            /*console.log(date);
            console.log(listState1);
            console.log(listState2);
            console.log(listState3);
            console.log(listState4);*/
       }
    });
    var listData,listPrice;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/concrete/transportation/selectTransport",
        async: false,
        success: function(data){
            /*console.log(data);
            var obj = data["data"];
            console.log(obj);
            var obj2 = JSON.parse(obj);
            //console.log(obj2);*/
            //console.log(data);
            var obj = data["msg"];
            //console.log(obj);
            var obj2 = JSON.parse(obj);
            //console.log(obj2);
            listData = obj2["listData"];
            listPrice = obj2["listPrice"];
        }
    });
    var dataList,expenditureList,profitList,incomeList;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/concrete/financestic/findAllActualpro",
        async: false,
        success: function(data){
            console.log(data);
            /*var obj = data["msg"];
            console.log(obj);*/
            var obj = data["msg"];
            console.log(obj);
            var obj2 = JSON.parse(obj);
            console.log(obj2);
            dataList = obj2["dataList"];
            expenditureList = obj2["expenditureList"];
            profitList = obj2["profitList"];
            incomeList = obj2["incomeList"];
        }
    });

    var fechart1 = echarts.init(document.getElementById('fechart1'));
    var option1 = {
        title: {
            text: '原材料支出费用'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['石头支出','沙子支出', '水泥支出','添加剂支出' ]
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            name: '日期',
            boundaryGap: false,
            data: date
        },
        yAxis: {
            type: 'value',
            name: '费用/元'
        },
        series: [
            {
                name: '石头支出',
                type: 'line',
                stack: '总量',
                seriesLayoutBy: 'row',
                data: listState1

            },
            {
                name: '沙子支出',
                type: 'line',
                color: '#00FF00',
                seriesLayoutBy: 'row',
                data: listState2
            },
            {
                name: '水泥支出',
                type: 'line',
                seriesLayoutBy: 'row',
                data: listState3
            },
            {
                name: '添加剂支出',
                type: 'line',
                seriesLayoutBy: 'row',
                data: listState4
            }
        ]
    };
    fechart1.setOption(option1);

    var fechart2 = echarts.init(document.getElementById('fechart2'));
    var option2 = {
        title: {
            text: '车辆支出费用'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['车辆支出' ]
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            name: '日期',
            boundaryGap: false,
            data: listData
        },
        yAxis: {
            type: 'value',
            name: '费用/元'
        },
        series: [
            {
                name: '车型1支出',
                type: 'line',
                stack: '总量',
                seriesLayoutBy: 'row',
                data: listPrice

            }
        ]
    };
    fechart2.setOption(option2);

    var fechart3 = echarts.init(document.getElementById('fechart3'));
    var option3 = {
        title: {
            text: '统计'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['利润', '支出', '收入']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'value'
            }
        ],
        yAxis: [
            {
                type: 'category',
                axisTick: {
                    show: false
                },
                data: dataList
            }
        ],
        series: [
            {
                name: '利润',
                type: 'bar',
                label: {
                    show: true,
                    position: 'inside'
                },
                data: profitList
            },
            {
                name: '收入',
                type: 'bar',
                stack: '总量',
                label: {
                    show: true
                },
                data: incomeList
            },
            {
                name: '支出',
                type: 'bar',
                stack: '总量',
                label: {
                    show: true,
                    position: 'left'
                },
                data: expenditureList
            }
        ]
    };
    fechart3.setOption(option3);
</script>
</html>
