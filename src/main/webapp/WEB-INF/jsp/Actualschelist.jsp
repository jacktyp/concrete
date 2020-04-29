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
    <script src="/layui/jquery.min.js"></script>
</head>

<body>
<div class="layui-fluid">
    <h2 style="color:#000000;padding: 10px">模拟生产</h2>
    <div class="layui-card">
        <table class="layui-hide" id="actschlist1" lay-filter="actschlistfilter1"></table>
    </div>
</div>
</body>
<script type="text/html" id="actschelistbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-xs layui-bg-blue" lay-event="add"><i class="layui-icon layui-icon-add-circle"></i>实际生产</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script type="text/html" id="buttonTpl">
    {{#  if(d.state == 1){ }}
    <button class="layui-btn layui-btn-xs">完成</button>
    {{#  } else { }}
    <button class="layui-btn layui-btn-primary layui-btn-xs">未完成</button>
    {{#  } }}
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#actschlist1'
            ,url: 'http://localhost:8080/concrete/schedule/findAllScheduleByState'
            //,toolbar: '#conbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', 'exports']
            ,cols: [[ //标题栏
                {field: 'id', title: '生产计划编号', width: 150 ,rowspan: 2, sort: true}
                , {field: 'name', title: '生产计划名', width: 120 ,rowspan: 2}
                //, {field: 'notificationId', title: '通知单编号', width: 120 ,rowspan: 2, sort: true}
                //, {field: 'contractId', title: '合同编号', width: 120 ,rowspan: 2, sort: true}
                // , {field: 'vehicleId', title: '车辆编号', width: 120 ,rowspan: 2}
                , {field: 'state', title: '计划状态', templet: '#buttonTpl',width: 120 ,rowspan: 2, sort: true}
                //, {field: 'time', title: '计划生产需时间', width: 120 ,rowspan: 2}
                , {field: 'productiontime', title: '生产开始时间', width: 150}
                , {field: 'endtiime', title: '生产结束时间', width: 150}
                , {field: 'registrant', title: '计划登记人', width: 100}
                , {field: 'registranttime', title: '计划登记时间', width: 150}
                , {fixed: 'right',title: '操作', width: 240 ,rowspan: 2, align: 'center', toolbar: '#actschelistbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,page: true //开启分页,
        });

        //监听工具条
        table.on('tool(actschlistfilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('生产计划编号：' + data.id + '<br>'
                    +'生产计划名：' + data.name + '<br>'
                    +'计划状态：' + data.state + '<br>'
                    +'计划生产需时间：' + data.time + '<br>'
                    +'生产开始时间：' + data.productiontime + '<br>'
                    +'生产结束时间：' + data.endtiime + '<br>'
                    +'计划登记人：' + data.registrant + '<br>'
                    +'计划登记时间：' + data.registranttime + '<br>'
                );
            } else if (obj.event === 'add') {
                layer.open({
                    title: '实际生产数据填写',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Actualproadd',
                    area: ['1030px', '600px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset:  ['20px', '50px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#actualadd").click();
                        othis.find('input[name="notificationId"]').val(data.notificationId);
                        othis.find('input[name="contractId"]').val(data.contractId);
                        othis.find('input[name="scheduleId"]').val(data.id);
                    }
                });
            } else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/schedule/deleteSchedule",
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