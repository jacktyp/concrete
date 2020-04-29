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
    <h2 style="color:#000000;padding: 20px">运输单列表</h2>
    <div class="layui-card">
        <table class="layui-hide" id="tran1" lay-filter="tranfilter1"></table>
    </div>
</div>
<script type="text/html" id="tranbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-xs layui-bg-orange" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;
        //展示已知数据
        table.render({
            elem: '#tran1'
            ,url: 'http://localhost:8080/concrete/transportation/findAllTransport'
            //,toolbar: '#conbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', 'exports']
            ,cols: [[ //标题栏
                {field: 'id', title: '运输单编号', width: 120 ,rowspan: 2, sort: true}
                , {field: 'vehicleId', title: '车辆编号', width: 120 ,rowspan: 2}
                //, {field: 'contractId', title: '合同编号', width: 120 ,rowspan: 2}
                //, {field: 'vehicle', title: '车载量', width: 160 ,rowspan: 2}
                , {field: 'time', title: '发车时间', width: 160 ,rowspan: 2}
                , {field: 'registrant', title: '运输表登记人', width: 120 ,rowspan: 2}
                , {field: 'registranttime', title: '运输表登记时间', width: 100}
                , {fixed: 'right',title: '操作', width: 240 ,rowspan: 2, align: 'center', toolbar: '#tranbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,page: true //开启分页,
            ,limit: 10
        });
        //监听工具条
        table.on('tool(tranfilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('运输单编号：' + data.id + '<br>'
                    +'车辆编号：' + data.vehicleId + '<br>'
                    //+'车载量：' + data.vehicle + '<br>'
                    +'发车时间：' + data.time + '<br>'
                    +'运输表登记人：' + data.registrant + '<br>'
                    +'运输表登记时间：' + data.registranttime + '<br>');
            } else if (obj.event === 'edit') {
                var tr = $(obj.tr);
                layer.open({
                    title: '运输单修改',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Transportationmodify',
                    area: ['1000px', '400px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['20px', '50px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#transportmodify").click();
                        othis.find('input[name="id"]').val(data.id);
                        othis.find('input[name="vehicleId"]').val(data.vehicleId);
                        //othis.find('input[name="contractId"]').val(data.contractId);
                        othis.find('input[name="vehicle"]').val(data.vehicle);
                        othis.find('input[name="time"]').val(data.time);
                        othis.find('input[name="registrant"]').val(data.registrant);
                        othis.find('input[name="registranttime"]').val(data.registranttime);
                    }
                });
            } else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/transportation/deleteTransportDTO",
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

</body>
</html>