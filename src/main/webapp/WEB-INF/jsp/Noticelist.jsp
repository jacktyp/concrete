<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/2
  Time: 13:31
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
    <h2 style="color:#000000;padding: 20px">通知单列表</h2>
    <div class="layui-card">
        <table class="layui-hide" id="not1" lay-filter="not2"></table>
    </div>
</div>
<script type="text/html" id="buttonTpl">
    {{#  if(d.mixproportionId == 1){ }}
    <button class="layui-btn layui-btn-xs">完成</button>
    {{#  } else { }}
    <button class="layui-btn layui-btn-primary layui-btn-xs">未完成</button>
    {{#  } }}
</script>
<script type="text/html" id="notbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-xs layui-bg-orange" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table
            ,$ = layui.$;

        //展示已知数据
        table.render({
            elem: '#not1'
            , url: 'http://localhost:8080/concrete/notification/findAllNotification'
            //, toolbar: '#notbar1' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'print', 'exports']
            , cols: [[ //标题栏
                {field: 'id', title: '通知单编号', width: 120, rowspan: 2, sort: true}
                , {field: 'contractId', title: '合同编号', width: 120, rowspan: 2, sort: true}
                , {field: 'mixproportionId', title: '状态', width: 120,templet: '#buttonTpl', rowspan: 2, sort: true}
                , {field: 'concreteamount', title: '混凝土总量\m³', width: 100}
                , {field: 'stoneamount', title: '所需石头总量\kg', width: 100}
                , {field: 'sandamount', title: '所需沙子总量\kg', width: 100}
                , {field: 'cementamount', title: '所需水泥总量\kg', width: 100}
                , {field: 'wateramount', title: '所需水总量\kg', width: 100}
                , {field: 'additiveamount', title: '所需添加剂总量\kg', width: 100}

                , {field: 'registrant', title: '通知单登记人', width: 120, rowspan: 2}
                , {field: 'registranttime', title: '通知单登记日期', width: 210, rowspan: 2}
                , {fixed: 'right', title: '操作', width: 240, rowspan: 2, align: 'center', toolbar: '#notbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            , page: true //开启分页,
            , limit: 10
        });

        //监听工具条
        table.on('tool(not2)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('通知单编号：' + data.id + '<br>'
                    +'混凝土总量：' + data.concreteamount + '<br>'
                    +'所需石头总量：' + data.stoneamount + '<br>'
                    +'所需沙子总量：' + data.sandamount + '<br>'
                    +'所需水泥总量：' + data.cementamount + '<br>'
                    +'所需水总量：' + data.wateramount + '<br>'
                    +'所需添加剂总量：' + data.additiveamount + '<br>'
                    +'通知单登记人：' + data.registrant + '<br>'
                    +'通知单登记日期：' + data.registranttime + '<br>');
            } else if (obj.event === 'edit') {
                var tr = $(obj.tr);
                layer.open({
                    title: '通知单修改',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Noticemodify',
                    area: ['1200px', '620px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['20px', '50px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#notmodify").click();
                        othis.find('input[name="id"]').val(data.id);
                        othis.find('input[name="contractId"]').val(data.contractId);
                        othis.find('input[name="mixproportionId"]').val(data.mixproportionId);
                        othis.find('input[name="stoneamount"]').val(data.stoneamount);
                        othis.find('input[name="sandamount"]').val(data.sandamount);
                        othis.find('input[name="cementamount"]').val(data.cementamount);
                        othis.find('input[name="wateramount"]').val(data.wateramount);
                        othis.find('input[name="additiveamount"]').val(data.additiveamount);
                        othis.find('input[name="concreteamount"]').val(data.concreteamount);
                        othis.find('input[name="registrant"]').val(data.registrant);
                        othis.find('input[name="registranttime"]').val(data.registranttime);
                    }
                });
            } else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/notification/deleteNotification",
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