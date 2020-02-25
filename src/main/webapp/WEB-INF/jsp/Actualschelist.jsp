<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/4
  Time: 14:55
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
</head>

<body>
<div class="layui-fluid">
    <h2 style="color:#000000;padding: 10px">模拟生产</h2>
    <div class="layui-card">
        <table class="layui-hide" id="actschlist1" lay-filter="actschlistfilter1"></table>
    </div>
</div>
</body>

<script type="text/html" id="actschelistbar1">
    <div class="search1">
        搜索ID：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
</script>
<script type="text/html" id="actschelistbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="add">模拟生产</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#actschlist1'
            ,url: '/test/testdata1.json'
            //,count: total//数据总数，从服务端得到
            ,toolbar: '#actschelistbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,method: 'post'
            ,request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            ,cols: [[ //标题栏
                {field: 'Schedule_id', title: '生产计划编号', width: 120 ,rowspan: 2, sort: true}
                , {field: 'Schedule_name', title: '生产计划名', width: 120 ,rowspan: 2}
                , {field: 'Schedule_state', title: '生产状态', width: 120 ,rowspan: 2}
                , {field: 'Mixproportion_concretegrade', title: '混凝土等级', width: 120 ,rowspan: 2}
                , {field: 'Mixproportion_mp', title: '混泥土配合比', width: 120 ,rowspan: 2}
                , {field: 'Mixproportion_state', title: '是否合格',templet: '#switchTpl', width: 100}
                /* , {align: 'center', title: '所需各种原材料数量', colspan: 5} //colspan即横跨的单元格数，这种情况下不用设置field和width
             ], [*/
                , {field: 'Notification_stoneamount', title: '计划石头总量\kg', width: 100}
                , {field: 'Notification_sandamount', title: '计划沙子总量\kg', width: 100}
                , {field: 'Notification_cementamount', title: '计划水泥总量\kg', width: 100}
                , {field: 'Notification_wateramount', title: '计划水总量\kg', width: 100}
                , {field: 'Notification_additiveamount', title: '计划添加剂总量\kg', width: 100}

                , {field: 'Schedule_time', title: '计划生产需时间', width: 100}
                , {field: 'Schedule_productiontime', title: '生产开始时间', width: 100}
                , {field: 'Schedule_endtiime', title: '生产结束时间', width: 100}
                , {field: 'Schedule_registrant', title: '计划登记人', width: 100}
                , {field: 'Schedule_registranttime', title: '计划登记时间', width: 100}
                , {fixed: 'right',title: '操作', width: 240 ,rowspan: 2, align: 'center', toolbar: '#actschelistbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,id: 'testReload'
            ,page: true //开启分页,
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
        table.on('tool(actschlistfilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.Contract_id + ' 的查看操作');
            } else if (obj.event === 'add') {
                layer.open({
                    type: 2,
                    content: 'http://localhost:8080/concrete/user/Actualproadd',
                    area: ['1200px', '600px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: 'lt'
                });
            } else if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
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