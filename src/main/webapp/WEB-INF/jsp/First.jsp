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
    <script src="/layui/jquery.min.js"></script>
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
                    <p class="layuiadmin-big-font" id="dayOfProduction"></p>
                    <p>
                        月生产量
                        <span class="layuiadmin-span-color"><span id="monthOfProduction"></span>方 <i class="layui-inline layui-icon layui-icon-flag"></i></span>
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
                    <p class="layuiadmin-big-font" id="dayOfNoProduction"></p>
                    <p>
                        最近一个月未生产量
                        <span class="layuiadmin-span-color"><span id="monthOfNoProduction"></span>方<i class="layui-inline layui-icon layui-icon-face-cry"></i></span>
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

                    <p class="layuiadmin-big-font" id="dayOfNewProduction"></p>
                    <p>
                        最近一个月新增量
                        <span class="layuiadmin-span-color"><span id="monthOfNewProduction"></span>方<i class="layui-inline layui-icon layui-icon-face-smile"></i></span>
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

                    <p class="layuiadmin-big-font">102000</p>
                    <p>
                        总收入
                        <span class="layuiadmin-span-color"> <i class="layui-inline layui-icon layui-icon-rmb"></i></span>
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
                            <div id="echart1" style="width: 700px;height:450px;"></div>
                            <%--<div id="echart2" style="width: 800px;height:450px;"></div>--%>
                            <div id="echart3" style="width: 700px;height:450px;"></div>
                        </div>

                    </div>
                    <div class="layui-col-sm4">
                        <div class="layuiadmin-card-list">
                            <p class="layuiadmin-normal-font">月新增</p>
                            <span>同上期增长</span>
                            <div class="layui-progress layui-progress-big" lay-showpercent="yes" lay-filter="p1">
                                <div id="pp1" class="layui-progress-bar"></div>
                            </div>
                        </div>
                        <div class="layuiadmin-card-list">
                            <p class="layuiadmin-normal-font">月总产量</p>
                            <span>同上期增长</span>
                            <div class="layui-progress layui-progress-big" lay-showPercent="yes" lay-filter="p2">
                                <div id="pp2" class="layui-progress-bar"></div>
                            </div>
                        </div>
                        <%--<div class="layuiadmin-card-list">
                            <p class="layuiadmin-normal-font">月收入</p>
                            <span>同上期增长</span>
                            <div class="layui-progress layui-progress-big" lay-showPercent="yes" lay-filter="p3">
                                <div class="layui-progress-bar" lay-percent="0%"></div>
                            </div>
                        </div>--%>
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
    var contractOfTen,planOfTen,productOfTen,addressDistribution,contractDis,actualDis;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/concrete/homePage/dataList",
        async: false,
        success: function(data){
            console.log(data);
            var obj = data["msg"];
            console.log(obj);
            var obj2 = JSON.parse(obj);
            /**
             * 生产量
             */
            var dayOfProduction = obj2["dayOfProduction"];
            document.getElementById("dayOfProduction").innerHTML  = dayOfProduction;
            var monthOfProduction = obj2["monthOfProduction"];
            document.getElementById("monthOfProduction").innerText = monthOfProduction;
            /**
             * 未生产量
             */
            var dayOfNoProduction = obj2["dayOfNoProduction"];
            document.getElementById("dayOfNoProduction").innerText = dayOfNoProduction;
            var monthOfNoProduction = obj2["monthOfNoProduction"];
            document.getElementById("monthOfNoProduction").innerText = monthOfNoProduction;
            /**
             * 新增生产量
             */
            var dayOfNewProduction = obj2["dayOfNewProduction"];
            document.getElementById("dayOfNewProduction").innerText = dayOfNewProduction;
            var monthOfNewProduction = obj2["monthOfNewProduction"];
            document.getElementById("monthOfNewProduction").innerText = monthOfNewProduction;
            /**
             * 合同，计划，实际生产 近十天的和
             */
            contractOfTen = obj2["contractOfTen"];
            planOfTen = obj2["planOfTen"];
            productOfTen = obj2["productOfTen"];
            /**
             * 合同表地址百分比
             */
            addressDistribution = obj2["addressDistribution"];
            /**
             * 同上期增
             */
            var increaseDistribution = obj2["increaseDistribution"];
            contractDis = increaseDistribution["contractDis"];
            actualDis = increaseDistribution["actualDis"];
            //element.progress('p1', contractDis);
            //element.progress('p2', actualDis);
        }
    });
    layui.use('element', function(){
        var element = layui.element;
        //条形图的赋值
        $("#pp1").attr("lay-percent",contractDis);
        $("#pp2").attr("lay-percent",actualDis);
        element.init();
    });
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#c1'
            ,width: '700px' //设置容器宽度
            ,height: '505px'
            ,arrow: 'always' //始终显示箭头
        });
    });
    var contractnum=new Array(),contracttime=new Array()
        ,plannum=new Array(),plantime=new Array()
        ,productnum=new Array(),producttime=new Array();
    for(var i = 0; i < contractOfTen.length; i++){//纵横坐标表的数据的获取
        contractnum[i]=contractOfTen[i].amountNum;
        contracttime[i]=contractOfTen[i].timeToStr;
    }
    for(var i = 0; i < planOfTen.length; i++){
        plannum[i]=planOfTen[i].amountNum;
        plantime[i]=planOfTen[i].timeToStr;
    }
    for(var i = 0; i < productOfTen.length; i++){
        productnum[i]=productOfTen[i].amountNum;
        producttime[i]=productOfTen[i].timeToStr;
    }
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
            boundaryGap: false,
            data:contracttime
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
                data: contractnum

            },
            {
                name: '计划生产',
                type: 'line',
                seriesLayoutBy: 'row',
                data: plannum
            },
            {
                name: '实际生产',
                type: 'line',
                seriesLayoutBy: 'row',
                data: productnum
            }
        ]
    };
    echart1.setOption(option1);
/*
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
    echart2.setOption(option2);*/

    var addressname=new Array(),addressfre=new Array(),address=[];
    addressname=Object.keys(addressDistribution);
    addressfre=Object.values(addressDistribution);
    for(i=0;i<addressname.length;i++){//进行饼状图数据格式转换
        var json1={};
        json1["name"]=addressname[i];
        json1["value"]= parseFloat(addressfre[i]);
        address.push(json1);
    }
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
            data: addressname
        },
        series: [
            {
                name: '地区',
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
                data:address
            }
        ]
    };
    echart3.setOption(option3);

</script>
</html>