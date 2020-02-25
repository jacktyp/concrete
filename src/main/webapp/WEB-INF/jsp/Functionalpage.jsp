<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>搅拌站业务流程系统</title>
    <link rel="stylesheet" href="/layui/css/layui.css">

    <script src="/layui/layui.js"></script>
    <style>
        /*对layui中的样式进行重写*/
        .layui-tab-content {
            padding: 0;/*layui-tab-content:默认有padding: 10px;的值，因为iframe的绝对定位脱离文档流，所以会存在20px的空白空间*/
        }
        .show-frame {
            top: 60px!important;
            /*默认.layui-layout-admin .layui-body {
                top: 60px;
                bottom: 44px;
            }*/
            overflow: hidden;/*消除浏览器最右边的滚动条*/
        }
        .frame {
            position: absolute;
            padding: 10px;/*与layui-footer隔开一段距离*/
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body class="layui-layout-body" onload="index0()">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><h3>搅拌站业务流程系统</h3></div>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-icon" name="f0" id="0" title="首页" content="/concrete/page/First"><i class="layui-icon">&#xe68e;</i> 首页</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe663;</i> 合同统计</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" name="c1" id="1" title="合同录入" content="/concrete/page/Contractadd">合同录入</a></dd>
                        <dd><a href="javascript:;" name="c2" id="2" title="合同列表" content="/concrete/page/Contractlist">合同列表</a></dd>
                        <dd><a href="javascript:;" name="c3" id="3" title="通知单列表" content="/concrete/page/Noticelist">通知单列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe857;</i> 生产规划</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" name="s1" id="4" title="生产计划" content="/concrete/page/Schedule">生产计划</a></dd>
                        <dd><a href="javascript:;" name="s2" id="5" title="生产计划列表" content="/concrete/page/Shedulelist">生产计划列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item ">
                    <a href="javascript:;"><i class="layui-icon">&#xe665;</i> 生产模拟</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" name="p1" id="6" title="模拟生产" content="/concrete/page/Actualschelist">模拟生产</a></dd>
                        <dd><a href="javascript:;" name="p2" id="7" title="实际生产列表" content="/concrete/page/Actualpro">实际生产列表</a></dd>
                        <dd><a href="javascript:;" name="p3" id="8" title="运输单列表" content="/concrete/page/Transportation">运输单列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe656;</i> 配比实验</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" name="m1" id="9" title="实验记录" content="/concrete/page/Mixproportion">实验记录</a></dd>
                        <dd><a href="javascript:;" name="m2" id="10" title="配合比制度表" content="/concrete/page/Mixproportionlist">配合比制度表</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe674;</i> 管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" name="pm1" id="11" title="原材料存储管理" content="/concrete/page/Procurement">原材料存储管理</a></dd>
                        <dd><a href="javascript:;" name="pm2" id="12" title="车辆统计" content="/concrete/page/Vehicle">车辆统计</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe672;</i> 财务管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" name="f1" id="13" title="财务统计" content="/concrete/page/Finance1">财务统计</a></dd>
                        <dd><a href="javascript:;" name="f2" id="14" title="财务报表" content="/concrete/page/Finance2">财务报表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab layui-tab-brief" lay-allowClose="true" lay-filter="empTab">
            <ul class="layui-tab-title">
                <li class="layui-this "><%--<i class="layui-icon">&#xe68e;</i>--%></li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show"><%--<h1 style="color: #5FB878">后台管理系统</h1>--%></div>
            </div>
        </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 2020 搅拌站业务流程系统
    </div>
</div>
</div>
</body>

<script>
    function index0(){

    }
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        var $ = layui.$;

        $("[name=f0]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=c1]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=c2]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=c3]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=s1]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=s2]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=p1]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=p2]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=p3]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=m1]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=m2]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=pm1]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=pm2]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=f1]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
        $("[name=f2]").click(function () {
            var id = $(this).attr("id");
            var content = $(this).attr("content");
            if($("li[lay-id="+id+"]").length==0){
                element.tabAdd("empTab",{
                    title:$(this).attr("title"),
                    content:"<iframe src='"+content+"' class='frame' frameborder='0'></iframe>",
                    id:id
                })
            }
            element.tabChange('empTab',id)
        });
    });
</script>


</html>