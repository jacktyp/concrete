<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/18
  Time: 8:43
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
    <div class="layui-row layui-col-space15">

        <div class="layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    生产量
                    <span class="layui-badge layui-bg-blue layuiadmin-badge">天</span>
                </div>
                <div class="layui-card-body layuiadmin-card-list">
                    <p class="layuiadmin-big-font">9,999,666</p>
                    <p>
                        总计生产量
                        <span class="layuiadmin-span-color">88万 <i class="layui-inline layui-icon layui-icon-flag"></i></span>
                    </p>
                </div>
            </div>
        </div>

        <div class="layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    未生产量
                    <span class="layui-badge layui-bg-cyan layuiadmin-badge">天</span>
                </div>
                <div class="layui-card-body layuiadmin-card-list">
                    <p class="layuiadmin-big-font">33,555</p>
                    <p>
                        最近一个月未生产量
                        <span class="layuiadmin-span-color">2323<i class="layui-inline layui-icon layui-icon-face-cry"></i></span>
                    </p>
                </div>
            </div>
        </div>

        <div class="layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    新增生产量
                    <span class="layui-badge layui-bg-orange layuiadmin-badge">天</span>
                </div>
                <div class="layui-card-body layuiadmin-card-list">

                    <p class="layuiadmin-big-font">66,666</p>
                    <p>
                        最近一个月新增量
                        <span class="layuiadmin-span-color">15% <i class="layui-inline layui-icon layui-icon-face-smile"></i></span>
                    </p>
                </div>
            </div>
        </div>

        <div class="layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    收入
                    <span class="layui-badge layui-bg-green layuiadmin-badge">月</span>
                </div>
                <div class="layui-card-body layuiadmin-card-list">

                    <p class="layuiadmin-big-font">999,666</p>
                    <p>
                        总收入
                        <span class="layuiadmin-span-color">*** <i class="layui-inline layui-icon layui-icon-dollar"></i></span>
                    </p>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-col-sm12">
        <div class="layui-card">
            <div class="layui-card-header">
                数据图表
            </div>
            <div class="layui-card-body">
                <div class="layui-row">
                    <div class="layui-col-sm8 layui-carousel" id="c1">
                        <div carousel-item="">
                            <div id="echart1" style="width: 800px;height:335px;"></div>
                            <div id="echart2" style="width: 800px;height:335px;"></div>
                            <div id="echart3" style="width: 800px;height:335px;"></div>
                        </div>

                    </div>
                    <div class="layui-col-sm4">
                        <div class="layuiadmin-card-list">
                            <p class="layuiadmin-normal-font">月新增数</p>
                            <span>同上期增长</span>
                            <div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="p1">
                                <div class="layui-progress-bar layui-bg-green" lay-percent="30%"></div>
                            </div>
                        </div>
                        <div class="layuiadmin-card-list">
                            <p class="layuiadmin-normal-font">月总产量数</p>
                            <span>同上期增长</span>
                            <div class="layui-progress layui-progress-big" lay-showPercent="true" lay-filter="p2">
                                <div class="layui-progress-bar" lay-percent="20%"></div>
                            </div>
                        </div>
                        <div class="layuiadmin-card-list">
                            <p class="layuiadmin-normal-font">月收入</p>
                            <span>同上期增长</span>
                            <div class="layui-progress layui-progress-big" lay-showPercent="true" lay-filter="p3">
                                <div class="layui-progress-bar" lay-percent="25%"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    layui.use('element', function(){
        var element = layui.element;
    });
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#c1'
            ,width: '800px' //设置容器宽度
            ,height: '335px'
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
    var echart1 = echarts.init(document.getElementById('echart1'));
    var option1 = {
        title: {
            text: '近10天生产展示图'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['新增生产','计划生产', '实际生产' ]
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
            name: '总数/m³'
        },
        series: [
            {
                name: '新增生产',
                type: 'line',
                stack: '总量',
                seriesLayoutBy: 'row',
                data: [2000, 0, 12, 500, 0, 1000, 0,0,0,0]

            },
            {
                name: '计划生产',
                type: 'line',
                seriesLayoutBy: 'row',
                data: [500, 500, 500, 500, 500, 480, 500, 500, 480, 500]
            },
            {
                name: '实际生产',
                type: 'line',
                seriesLayoutBy: 'row',
                data: [350, 390, 333, 400, 412, 450, 0,230,233,500]
            }
        ]
    };
    echart1.setOption(option1);

    var echart2 = echarts.init(document.getElementById('echart2'));
    var option2 = {
        title: {
            text: '近10天支出/收入'
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
            data: ['支出', '收入']
        },
        xAxis: [
            {
                type: 'category',
                data: ['2019.1.1', '2019.1.2', '2019.1.3', '2019.1.4', '2019.1.5', '2019.1.6', '2019.1.7','2019.1.8','2019.1.9','2019.12.31'],
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '金额/万元'
            }
        ],
        series: [
            {
                name: '支出',
                type: 'bar',
                data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
            },
            {
                name: '收入',
                type: 'bar',
                data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
            }
        ]

    };
    echart2.setOption(option2);

    var echart3 = echarts.init(document.getElementById('echart3'));
    var option3 = {
        title: {
            text: '销售地区占比'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            top: 10,
            right: 10,
            data: ['王集镇', '汲滩镇', '邓州市', '曹集', '赵庄','小李庄','其他']
        },
        series: [
            {
                name: '地区名',
                type: 'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: [
                    {value: 335, name: '汲滩镇'},
                    {value: 310, name: '邓州市'},
                    {value: 234, name: '曹集'},
                    {value: 135, name: '赵庄'},
                    {value: 1548, name: '小李庄'},
                    {value: 1548, name: '其他'}
                ]
            }
        ]
    };
    echart3.setOption(option3);

</script>
</html>