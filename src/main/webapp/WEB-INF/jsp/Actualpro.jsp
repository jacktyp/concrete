<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/3
  Time: 10:03
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
    <h2 style="color:#000000;padding: 20px">实际生产列表</h2>
    <div class="layui-card">
        <table class="layui-hide" id="actpro1" lay-filter="actprofilter1"></table>
    </div>
</div>
</body>
<script type="text/html" id="actprobar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-xs layui-bg-orange" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>

<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#actpro1'
            ,url: 'http://localhost:8080/concrete/actualpro/findAllActualpro'
            ,toolbar: '#conbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', 'exports']
            , cols: [[ //标题栏
                {field: 'id', title: 'ID', width: 120, rowspan: 2, sort: true}
                //, {field: 'scheduleId', title: '计划编号', width: 100}
                //, {field: 'notificationId', title: '通知表编号', width: 100}
                //, {field: 'contractId', title: '合同编号', width: 100}
                //, {field: 'vehicleId', title: '车辆编号', width: 100}
                , {field: 'stoneamount', title: '实际生产石头总量\kg', width: 100}
                , {field: 'sandamount', title: '实际生产沙子总量\kg', width: 100}
                , {field: 'cementamount', title: '实际生产水泥总量\kg', width: 100}
                , {field: 'wateramount', title: '实际生产水总量\kg', width: 100}
                , {field: 'additiveamount', title: '实际生产添加剂总量\kg', width: 100}
                , {field: 'concreteamount', title: '实际生产混凝土总量\kg', width: 100}
                //, {field: 'time', title: '实际生产需时间', width: 100}
                , {field: 'productiontime', title: '实际生产开始时间', width: 100}
                , {field: 'endtiime', title: '实际生产结束时间', width: 100}
                , {field: 'registrant', title: '实际生产登记人', width: 100}
                , {field: 'registranttime', title: '实际生产登记时间', width: 100}
                , {fixed: 'right', title: '操作', width: 280, align: 'center', toolbar: '#actprobar2'} //这里的toolbar值是模板元素的选择器
            ]]
            , page: true //开启分页,
        });
        //监听工具条
        table.on('tool(actprofilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + '<br>'
                    +'实际生产石头总量：' + data.stoneamount + '<br>'
                    +'实际生产沙子总量：' + data.sandamount + '<br>'
                    +'实际生产水泥总量：' + data.cementamount + '<br>'
                    +'实际生产水总量：' + data.wateramount + '<br>'
                    +'实际生产添加剂总量：' + data.additiveamount + '<br>'
                    +'实际生产混凝土总量：' + data.concreteamount + '<br>'
                    +'实际生产需时间：' + data.time + '<br>'
                    +'实际生产开始时间：' + data.productiontime + '<br>'
                    +'实际生产结束时间：' + data.endtiime + '<br>'
                    +'实际生产登记人：' + data.registrant + '<br>'
                    +'实际生产登记时间：' + data.registranttime + '<br>');
            } else if (obj.event === 'edit') {
                var tr = $(obj.tr);
                layer.open({
                    title: '实际生产单修改',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Actualpromodify',
                    area: ['1200px', '620px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['20px', '50px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#actualpromodify").click();
                        othis.find('input[name="id"]').val(data.id);
                        othis.find('input[name="scheduleId"]').val(data.scheduleId);
                        othis.find('input[name="notificationId"]').val(data.notificationId);
                        othis.find('input[name="contractId"]').val(data.contractId);
                        othis.find('input[name="vehicleId"]').val(data.vehicleId);
                        othis.find('input[name="stoneamount"]').val(data.stoneamount);
                        othis.find('input[name="sandamount"]').val(data.sandamount);
                        othis.find('input[name="cementamount"]').val(data.cementamount);
                        othis.find('input[name="wateramount"]').val(data.wateramount);
                        othis.find('input[name="additiveamount"]').val(data.additiveamount);
                        othis.find('input[name="concreteamount"]').val(data.concreteamount);
                        othis.find('input[name="time"]').val(data.time);
                        othis.find('input[name="productiontime"]').val(data.productiontime);
                        othis.find('input[name="endtiime"]').val(data.endtiime);
                        othis.find('input[name="registrant"]').val(data.registrant);
                        othis.find('input[name="registranttime"]').val(data.registranttime);
                    }
                });
            } else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/actualpro/deleteActualproDTO",
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
