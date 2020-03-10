<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>搅拌站业务流程系统</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/layui/style/admin.css">
    <script src="/layui/layui.js"></script>
</head>
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <!-- 头部区域 -->
        <div class="layui-header">
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>默默</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="set/user/info.html">基本资料</a></dd>
                        <dd><a lay-href="set/user/password.html">修改密码</a></dd>
                        <%--<dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="/index.jsp">退出</a></li>
                <%--<li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>--%>
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="home/console.html">
                    <span>搅拌站业务流程系统</span>
                </div>

                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                    <li data-name="home" class="layui-nav-item layui-nav-itemed">
                        <a lay-href="/concrete/page/First" lay-tips="主页" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>主页</cite>
                        </a>
                    </li>
                    <li data-name="contract" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="组件" lay-direction="2">
                            <i class="layui-icon layui-icon-template"></i>
                            <cite>合同统计</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="Contractadd">
                                <a lay-href="/concrete/page/Contractadd">合同录入</a>
                            </dd>
                            <dd data-name="Contractlist">
                                <a lay-href="/concrete/page/Contractlist">合同列表</a>
                            </dd>
                            <dd data-name="Noticelist">
                                <a lay-href="/concrete/page/Noticelist">通知单列表</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="Sche" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="生产规划" lay-direction="2">
                            <i class="layui-icon layui-icon-component"></i>
                            <cite>生产规划</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="Schedule">
                                <a lay-href="/concrete/page/Schedule">生产计划</a>
                            </dd>
                            <dd data-name="Shedulelist">
                                <a lay-href="/concrete/page/Shedulelist">生产计划列表</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="Actual" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="生产模拟" lay-direction="2">
                            <i class="layui-icon layui-icon-console"></i>
                            <cite>生产模拟</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="Actualschelist">
                                <a lay-href="/concrete/page/Actualschelist">模拟生产</a>
                            </dd>
                            <dd data-name="Actualpro">
                                <a lay-href="/concrete/page/Actualpro">实际生产列表</a>
                            </dd>
                            <dd data-name="Transportation">
                                <a lay-href="/concrete/page/Transportation">运输单列表</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="Mixpro" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="配比实验" lay-direction="2">
                            <i class="layui-icon layui-icon-template-1"></i>
                            <cite>配比实验</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="Mixproportion">
                                <a lay-href="/concrete/page/Mixproportion">实验记录</a>
                            </dd>
                            <dd data-name="Mixproportionlist">
                                <a lay-href="/concrete/page/Mixproportionlist">配合比制度表</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="Man" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="管理" lay-direction="2">
                            <i class="layui-icon layui-icon-senior"></i>
                            <cite>原材料&车辆管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="Procurement">
                                <a lay-href="/concrete/page/Procurement">原材料统计</a>
                            </dd>
                            <dd data-name="Vehicle">
                                <a lay-href="/concrete/page/Vehicle">车辆统计</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="Finance" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="财务管理" lay-direction="2">
                            <i class="layui-icon layui-icon-rmb"></i>
                            <cite>财务管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="Finance1">
                                <a lay-href="/concrete/page/Finance1">财务统计</a>
                            </dd>
                            <dd data-name="Finance2">
                                <a lay-href="/concrete/page/Finance2">财务报表</a>
                            </dd>
                        </dl>
                    </li>
                    <li data-name="Acc" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="用户" lay-direction="2">
                            <i class="layui-icon layui-icon-user"></i>
                            <cite>用户</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="Finance1">
                                <a lay-href="/concrete/page/Account">账户管理</a>
                            </dd>
                        </dl>
                    </li>

                </ul>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>


        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="/concrete/page/First" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>
<script>
    layui.config({
        base: '/static/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'console']);
</script>
</body>
</html>