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
            data: ['2019.1.1', '2019.1.2', '2019.1.3', '2019.1.4', '2019.1.5', '2019.1.6', '2019.1.7','2019.1.8','2019.1.9','2019.12.31']
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
                data: [2000, 0, 12, 500, 0, 1000, 0,0,0,0]

            },
            {
                name: '沙子支出',
                type: 'line',
                color: '#00FF00',
                seriesLayoutBy: 'row',
                data: [500, 500, 500, 500, 500, 480, 500, 500, 480, 500]
            },
            {
                name: '水泥支出',
                type: 'line',
                seriesLayoutBy: 'row',
                data: [350, 390, 333, 400, 412, 450, 0,230,233,500]
            },
            {
                name: '添加剂支出',
                type: 'line',
                seriesLayoutBy: 'row',
                data: [350, 390, 1000, 400, 412, 450, 0,230,233,500]
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
            data: ['车型1支出','车型2支出', '车型3支出','车型4支出' ]
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
            data: ['2019.1.1', '2019.1.2', '2019.1.3', '2019.1.4', '2019.1.5', '2019.1.6', '2019.1.7','2019.1.8','2019.1.9','2019.12.31']
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
                data: [2000, 0, 12, 500, 0, 1000, 0,0,0,0]

            },
            {
                name: '车型2支出',
                type: 'line',
                color: '#00FF00',
                seriesLayoutBy: 'row',
                data: [500, 500, 500, 500, 500, 480, 500, 500, 480, 500]
            },
            {
                name: '车型3支出',
                type: 'line',
                seriesLayoutBy: 'row',
                data: [350, 390, 333, 400, 412, 450, 0,230,233,500]
            },
            {
                name: '车型4支出',
                type: 'line',
                seriesLayoutBy: 'row',
                data: [350, 390, 333, 400, 1000, 450, 0,230,233,500]
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
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
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
                data: [200, 170, 240, 244, 200, 220, 210]
            },
            {
                name: '收入',
                type: 'bar',
                stack: '总量',
                label: {
                    show: true
                },
                data: [320, 302, 341, 374, 390, 450, 420]
            },
            {
                name: '支出',
                type: 'bar',
                stack: '总量',
                label: {
                    show: true,
                    position: 'left'
                },
                data: [-120, -132, -101, -134, -190, -230, -210]
            }
        ]
    };
    fechart3.setOption(option3);
</script>
</html>
